/*
 * Copyright (c) 2015-2019 Uli Bubenheimer
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package org.bubenheimer.android.databinding.adapter

import androidx.annotation.Px
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingListener
import androidx.databinding.InverseBindingMethod
import androidx.databinding.InverseBindingMethods
import androidx.databinding.adapters.ListenerUtil
import androidx.viewpager2.widget.ViewPager2
import org.bubenheimer.android.databinding.R

interface OnPageScrollStateChanged {
    fun onPageScrollStateChanged(state: Int)
}

interface OnPageScrolled {
    fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int)
}

interface OnPageSelected {
    fun onPageSelected(position: Int)
}

@InverseBindingMethods(InverseBindingMethod(type = ViewPager2::class, attribute = "currentItem"))
object ViewPager2BindingAdapter {
    @BindingAdapter("currentItem")
    @JvmStatic
    fun setCurrentItem(view: ViewPager2, currentItem: Int) {
        if (view.currentItem != currentItem) {
            view.currentItem = currentItem
        }
    }

    @BindingAdapter(
        requireAll = false, value = [
            "onPageScrollStateChanged",
            "onPageScrolled",
            "onPageSelected",
            "currentItemAttrChanged"
        ]
    )
    @JvmStatic
    fun registerOnPageChangeCallback(
        view: ViewPager2,
        scrollState: OnPageScrollStateChanged?,
        scrolled: OnPageScrolled?,
        selected: OnPageSelected?,
        attrChange: InverseBindingListener?
    ) {
        val newValue = if (
            scrollState == null &&
            scrolled == null &&
            selected == null &&
            attrChange == null
        ) null else object : ViewPager2.OnPageChangeCallback() {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                @Px positionOffsetPixels: Int
            ) {
                scrolled?.onPageScrolled(position, positionOffset, positionOffsetPixels)
            }

            override fun onPageSelected(position: Int) {
                selected?.onPageSelected(position)
                attrChange?.onChange()
            }

            override fun onPageScrollStateChanged(state: Int) {
                scrollState?.onPageScrollStateChanged(state)
            }
        }

        val oldValue = ListenerUtil.trackListener(view, newValue, R.id.tag_viewpagerbindingadapter)
        if (oldValue != null) {
            view.unregisterOnPageChangeCallback(oldValue)
        }

        if (newValue != null) {
            view.registerOnPageChangeCallback(newValue)
        }
    }
}

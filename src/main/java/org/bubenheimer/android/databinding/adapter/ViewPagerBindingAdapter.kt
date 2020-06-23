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

import androidx.databinding.BindingAdapter
import androidx.databinding.adapters.ListenerUtil
import androidx.viewpager.widget.ViewPager
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import org.bubenheimer.android.databinding.R

class ViewPagerBindingAdapter private constructor() {
    companion object {
        @BindingAdapter(requireAll = false, value = [
            "onPageScrollStateChanged",
            "onPageScrolled",
            "onPageSelected"
        ])
        fun setOnPageChangeListener(
                view: ViewPager,
                scrollState: OnPageScrollStateChanged?,
                scrolled: OnPageScrolled?,
                selected: OnPageSelected?
        ) {
            val newValue = if (scrollState == null && scrolled == null && selected == null) null
            else object : OnPageChangeListener {
                override fun onPageScrolled(
                        position: Int,
                        positionOffset: Float,
                        positionOffsetPixels: Int
                ) {
                    scrolled?.onPageScrolled(position, positionOffset, positionOffsetPixels)
                }

                override fun onPageSelected(position: Int) {
                    selected?.onPageSelected(position)
                }

                override fun onPageScrollStateChanged(state: Int) {
                    scrollState?.onPageScrollStateChanged(state)
                }
            }

            val oldValue =
                    ListenerUtil.trackListener(view, newValue, R.id.tag_viewpagerbindingadapter)
            if (oldValue != null) {
                view.removeOnPageChangeListener(oldValue)
            }

            if (newValue != null) {
                view.addOnPageChangeListener(newValue)
            }
        }
    }

    interface OnPageScrollStateChanged {
        fun onPageScrollStateChanged(state: Int)
    }

    interface OnPageScrolled {
        fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int)
    }

    interface OnPageSelected {
        fun onPageSelected(position: Int)
    }
}

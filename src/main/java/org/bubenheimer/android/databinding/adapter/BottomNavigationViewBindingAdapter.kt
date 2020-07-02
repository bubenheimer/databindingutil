/*
 * Copyright (c) 2015-2020 Uli Bubenheimer
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
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.bottomnavigation.BottomNavigationView.OnNavigationItemReselectedListener
import java.util.*

object BottomNavigationViewBindingAdapter {
    @BindingAdapter("onNavigationItemSelected")
    @JvmStatic
    fun setOnNavigationItemSelectedListener(
        view: BottomNavigationView,
        listener: BottomNavigationView.OnNavigationItemSelectedListener?
    ) = view.setOnNavigationItemSelectedListener(listener)

    @BindingAdapter("onNavigationItemReselected")
    @JvmStatic
    fun setOnNavigationItemReselectedListener(
        view: BottomNavigationView,
        listener: OnNavigationItemReselectedListener?
    ) = view.setOnNavigationItemReselectedListener(listener)

    @BindingAdapter("itemVisibility")
    @JvmStatic
    fun setItemVisibility(view: BottomNavigationView, bitSet: BitSet) {
        val menu = view.menu
        val cnt = menu.size()
        for (i in 0 until cnt) {
            menu.getItem(i).isVisible = bitSet[i]
        }
    }
}

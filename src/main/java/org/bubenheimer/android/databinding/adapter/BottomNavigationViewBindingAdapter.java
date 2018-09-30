/*
 * Copyright (c) 2015-2017 Uli Bubenheimer
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
 */

package org.bubenheimer.android.databinding.adapter;

import androidx.databinding.BindingAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomnavigation.BottomNavigationView.OnNavigationItemReselectedListener;
import com.google.android.material.bottomnavigation.BottomNavigationView.OnNavigationItemSelectedListener;
import android.view.Menu;

import java.util.BitSet;

public final class BottomNavigationViewBindingAdapter {
    @BindingAdapter("onNavigationItemSelected")
    public static void setOnNavigationItemSelectedListener(
            final BottomNavigationView view, final OnNavigationItemSelectedListener listener) {
        view.setOnNavigationItemSelectedListener(listener);
    }

    @BindingAdapter("onNavigationItemReselected")
    public static void setOnNavigationItemReselectedListener(
            final BottomNavigationView view, final OnNavigationItemReselectedListener listener) {
        view.setOnNavigationItemReselectedListener(listener);
    }

    @BindingAdapter("itemVisibility")
    public static void setItemVisibility(final BottomNavigationView view, final BitSet bitSet) {
        final Menu menu = view.getMenu();
        final int cnt = menu.size();
        for (int i = 0; i < cnt; ++i) {
            //TODO replace with setVisible once BottomNavigationView is fixed: https://issuetracker.google.com/issues/37124140
            menu.getItem(i).setEnabled(bitSet.get(i));
//            menu.getItem(i).setVisible(bitSet.get(i));
        }
    }

    private BottomNavigationViewBindingAdapter() {
        throw new UnsupportedOperationException();
    }
}

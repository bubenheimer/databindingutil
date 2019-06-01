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

package org.bubenheimer.android.databinding.adapter;

import androidx.databinding.BindingAdapter;
import androidx.databinding.adapters.ListenerUtil;
import androidx.viewpager.widget.ViewPager;

import org.bubenheimer.android.databinding.R;

public final class ViewPagerBindingAdapter {
    @BindingAdapter(requireAll = false,
            value = {"onPageScrollStateChanged", "onPageScrolled", "onPageSelected"})
    public static void setOnPageChangeListener(
            final ViewPager view, final OnPageScrollStateChanged scrollState,
            final OnPageScrolled scrolled, final OnPageSelected selected) {
        final ViewPager.OnPageChangeListener newValue;
        if (scrollState == null && scrolled == null && selected == null) {
            newValue = null;
        } else {
            newValue = new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(final int position, final float positionOffset,
                                           final int positionOffsetPixels) {
                    if (scrolled != null) {
                        scrolled.onPageScrolled(position, positionOffset, positionOffsetPixels);
                    }
                }

                @Override
                public void onPageSelected(final int position) {
                    if (selected != null) {
                        selected.onPageSelected(position);
                    }
                }

                @Override
                public void onPageScrollStateChanged(final int state) {
                    if (scrollState != null) {
                        scrollState.onPageScrollStateChanged(state);
                    }
                }
            };
        }
        final ViewPager.OnPageChangeListener oldValue =
                ListenerUtil.trackListener(view, newValue, R.id.tag_viewpagerbindingadapter);
        if (oldValue != null) {
            view.removeOnPageChangeListener(oldValue);
        }
        if (newValue != null) {
            view.addOnPageChangeListener(newValue);
        }
    }

    public interface OnPageScrollStateChanged {
        void onPageScrollStateChanged(int state);
    }

    public interface OnPageScrolled {
        void onPageScrolled(int position, float positionOffset, int positionOffsetPixels);
    }

    public interface OnPageSelected {
        void onPageSelected(int position);
    }

    private ViewPagerBindingAdapter() {
        throw new UnsupportedOperationException();
    }
}

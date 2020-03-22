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

package org.bubenheimer.android.databinding.adapter;

import com.google.android.material.button.MaterialButton;

import org.bubenheimer.android.databinding.Check;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.BindingAdapter;
import androidx.databinding.InverseBindingListener;
import androidx.databinding.InverseBindingMethod;
import androidx.databinding.InverseBindingMethods;

@InverseBindingMethods({
        @InverseBindingMethod(
                type = MaterialButton.class,
                attribute = "checked"
        )
})
public final class MaterialButtonBindingAdapter {
    @BindingAdapter("checked")
    public static void setChecked(
            final @NonNull MaterialButton view,
            final boolean checked
    ) {
        if (view.isChecked() != checked) {
            view.setChecked(checked);
        }
    }

    @BindingAdapter(
            value =  {"onCheckedChanged", "checkedAttrChanged"},
            requireAll = false
    )
    public static void setListeners(
            final @NonNull MaterialButton view,
            final @Nullable MaterialButton.OnCheckedChangeListener listener,
            final @Nullable InverseBindingListener attrChange
    ) {
        if (attrChange == null) {
            Check.notNull(listener);
            view.addOnCheckedChangeListener(listener);
        } else {
            view.addOnCheckedChangeListener((buttonView, isChecked) -> {
                if (listener != null) {
                    listener.onCheckedChanged(buttonView, isChecked);
                }
                attrChange.onChange();
            });
        }
    }

    private MaterialButtonBindingAdapter() {
        throw new UnsupportedOperationException();
    }
}

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
import androidx.databinding.InverseBindingListener
import androidx.databinding.InverseBindingMethod
import androidx.databinding.InverseBindingMethods
import com.google.android.material.button.MaterialButton

@InverseBindingMethods(InverseBindingMethod(type = MaterialButton::class, attribute = "checked"))
public object MaterialButtonBindingAdapter {
    @BindingAdapter("checked")
    @JvmStatic
    public fun setChecked(view: MaterialButton, checked: Boolean) {
        if (view.isChecked != checked) {
            view.isChecked = checked
        }
    }

    @BindingAdapter(
        requireAll = false, value = [
            "onCheckedChanged",
            "checkedAttrChanged"
        ]
    )
    @JvmStatic
    public fun setListeners(
        view: MaterialButton,
        listener: MaterialButton.OnCheckedChangeListener?,
        attrChange: InverseBindingListener?
    ) {
        if (attrChange == null) {
            view.addOnCheckedChangeListener(listener!!)
        } else {
            view.addOnCheckedChangeListener { buttonView: MaterialButton, isChecked: Boolean ->
                listener?.onCheckedChanged(buttonView, isChecked)
                attrChange.onChange()
            }
        }
    }
}

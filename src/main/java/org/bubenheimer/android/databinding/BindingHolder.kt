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
package org.bubenheimer.android.databinding

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

open class BindingHolder<T : ViewDataBinding>(val binding: T) :
        RecyclerView.ViewHolder(binding.root) {
    companion object {
        // same approach as in DataBindingUtil
        fun <T : ViewDataBinding> inflate(
                inflater: LayoutInflater,
                parent: ViewGroup?,
                @LayoutRes layoutId: Int
        ): T = DataBindingUtil.inflate(inflater, layoutId, parent, false)

        fun <T : ViewDataBinding> create(
                inflater: LayoutInflater,
                parent: ViewGroup?,
                @LayoutRes layoutId: Int
        ): BindingHolder<T> = BindingHolder(inflate(inflater, parent, layoutId))
    }
}

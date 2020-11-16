/*
 * Copyright (C) 2020 The Android Open Source Project
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
package com.jroomdev.info_movies.screen.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.jroomdev.info_movies.R
import com.jroomdev.info_movies.databinding.ItemMainListBinding

class MovieListAdapter() : RecyclerView.Adapter<MovieListAdapter.MovieListViewHolder>() {

    private val items: MutableList<String> = mutableListOf()

    init {
        items.add("Popularity")
    }

    override fun onCreateViewHolder(
      parent: ViewGroup,
      viewType: Int
    ): MovieListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ItemMainListBinding>(
          inflater,
          R.layout.item_main_list,
          parent,
          false
        )
        return MovieListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieListViewHolder, position: Int) {
        holder.binding.apply {
            adapter = MovieAdapter()
            executePendingBindings()
        }
    }

    override fun getItemCount() = items.size

    class MovieListViewHolder(val binding: ItemMainListBinding) :
        RecyclerView.ViewHolder(binding.root)
}
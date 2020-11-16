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
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.jroomdev.info_movies.R
import com.jroomdev.info_movies.data.model.Movie
import com.jroomdev.info_movies.databinding.ItemMainMovieBinding

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    private val items: MutableList<Movie> = mutableListOf()
    private var _clickedItem: MutableLiveData<Int> = MutableLiveData(0)
    fun clickedItemFilter(id: Int): Boolean {
        return _clickedItem.value == id
    }

    fun refreshClickedItem(id: Int) {
        _clickedItem.value = id
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MovieViewHolder {

        val inflater = LayoutInflater.from(parent.context)

        val binding = DataBindingUtil.inflate<ItemMainMovieBinding>(
            inflater,
            R.layout.item_main_movie,
            parent,
            false
        )

        return MovieViewHolder(binding).apply {
        }
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {

        val rank = position + 1

        holder.binding.apply {
            movie = items[position]
            adapter = this@MovieAdapter
            movieRank.text = rank.toString()
            movieDetailRank.text = rank.toString()
            executePendingBindings()
        }

        holder.bindViewHolder()
    }

    override fun getItemCount() = items.size

    fun addMovieList(movies: List<Movie>) {
        items.addAll(movies)
        notifyDataSetChanged()
    }

    class MovieViewHolder(val binding: ItemMainMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindViewHolder() {
            with(binding) {

                movieRankCard.setOnClickListener {
                    adapter?.refreshClickedItem(movie?.id!!)
                }
                executePendingBindings()
            }
        }
    }
}
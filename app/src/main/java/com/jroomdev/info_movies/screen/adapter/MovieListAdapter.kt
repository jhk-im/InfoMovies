package com.jroomdev.info_movies.screen.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.jroomdev.info_movies.R
import com.jroomdev.info_movies.databinding.ItemMainListBinding
import com.jroomdev.info_movies.screen.main.MainViewModel

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
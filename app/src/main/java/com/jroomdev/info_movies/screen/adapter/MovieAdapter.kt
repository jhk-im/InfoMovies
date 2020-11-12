package com.jroomdev.info_movies.screen.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jroomdev.info_movies.R
import com.jroomdev.info_movies.data.model.Movie
import com.jroomdev.info_movies.databinding.ItemMainMovieBinding

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    private val items: MutableList<Movie> = mutableListOf()

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
        holder.binding.apply {
            movie = items[position]
            executePendingBindings()
        }
        holder.bindViewHolder(items[position], position)
    }

    override fun getItemCount() = items.size

    fun addMovieList(movies: List<Movie>) {
        items.addAll(movies)
        notifyDataSetChanged()
    }

    class MovieViewHolder(val binding: ItemMainMovieBinding) :
        RecyclerView.ViewHolder(binding.root){

        fun bindViewHolder(movie: Movie, position: Int) {
            with(binding) {
                val rank = position + 1
                movieRank.text = rank.toString()
                voteAverageCard.text = movie.vote_average.toString()
                Glide.with(binding.root)
                    .load(movie.getImageUrl())
                    .error(R.drawable.test)
                    .into(movieImageCard)
                executePendingBindings()
            }
        }
    }
}
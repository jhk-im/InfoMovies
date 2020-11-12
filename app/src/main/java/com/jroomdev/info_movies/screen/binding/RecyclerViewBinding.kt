package com.jroomdev.info_movies.screen.binding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jroomdev.info_movies.data.model.Movie
import com.jroomdev.info_movies.screen.adapter.MovieAdapter
import com.jroomdev.info_movies.screen.main.MainViewModel

@BindingAdapter("adapter")
fun bindAdapter(view: RecyclerView, adapter: RecyclerView.Adapter<*>) {
    view.adapter = adapter
}

@BindingAdapter("paginationMovies")
fun paginationPokemonList(view: RecyclerView, viewModel: MainViewModel?) {
    viewModel?.fetchMovieList(1)
}

@BindingAdapter("movies")
fun setMovies(view: RecyclerView, movies: List<Movie>?) {
    movies?.let {
        (view.adapter as MovieAdapter).addMovieList(movies)
    }
}
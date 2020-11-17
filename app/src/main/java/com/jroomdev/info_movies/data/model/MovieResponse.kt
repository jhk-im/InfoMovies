package com.jroomdev.info_movies.data.model

data class MovieResponse(
  val page: Int,
  val results: List<Movie>
)
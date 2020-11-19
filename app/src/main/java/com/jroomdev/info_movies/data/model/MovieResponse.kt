package com.jroomdev.info_movies.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MovieResponse(
  @field:Json(name = "page") val page: Int,
  @field:Json(name = "results") val results: List<Movie>
)
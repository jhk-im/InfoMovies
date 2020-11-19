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
package com.jroomdev.info_movies.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@Entity
@JsonClass(generateAdapter = true)
data class MovieInfo(
  @field:Json(name = "id") @PrimaryKey val id: Int,
  @field:Json(name = "poster_path") val poster_path: String,
  @field:Json(name = "overview") val overview: String,
  @field:Json(name = "release_date") val release_date: String,
  @field:Json(name = "vote_average") val vote_average: Float,
  @field:Json(name = "popularity") val popularity: Float,
  @field:Json(name = "vote_count") val vote_count: Int,
  @field:Json(name = "runtime") val runtime: Int,
  @field:Json(name = "genres") val genres: List<Genres>
  ){

  fun getRuntimeString(): String = "$runtime"
  fun getVoteCountString(): String = "$vote_count"
  fun getPopularityString(): String = "$popularity"
  fun getVoteAverageString(): String = "$vote_average"
  fun getImageUrl(): String = "https://image.tmdb.org/t/p/w300$poster_path"

  @JsonClass(generateAdapter = true)
  data class Genres(
    @field:Json(name = "id") val id: Int,
    @field:Json(name = "name") val name: String
  )
}
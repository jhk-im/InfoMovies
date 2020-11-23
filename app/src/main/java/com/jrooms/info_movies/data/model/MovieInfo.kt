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
package com.jrooms.info_movies.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@Entity
@JsonClass(generateAdapter = true)
data class MovieInfo(
  @field:Json(name = "id") @PrimaryKey val id: Int,
  @field:Json(name = "release_date") val release_date: String,
  @field:Json(name = "backdrop_path") val backdrop_path: String,
  @field:Json(name = "popularity") val popularity: Float,
  @field:Json(name = "vote_count") val vote_count: Int,
  @field:Json(name = "runtime") val runtime: Int,
  @field:Json(name = "revenue") val revenue: Int,
  @field:Json(name = "genres") val genres: List<Genres>
  ){

  fun getRevenueString(): String = "$revenue"
  fun getRuntimeString(): String = "$runtime"
  fun getVoteCountString(): String = "($vote_count)"
  fun getPopularityString(): String = "$popularity"

  fun getGenresString(): String {
    val sb = StringBuilder()
    genres.forEach { genre ->
      if(genres.indexOf(genre) != genres.lastIndex)
      sb.append(genre.name).append(", ")
      else {
        sb.append(genre.name)
      }
    }
    return sb.toString()
  }

  data class Genres(
    val id: Int,
    val name: String
  )

  fun getBackdropUrl(): String = "https://image.tmdb.org/t/p/w400${backdrop_path}_path"
}
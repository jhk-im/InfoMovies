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

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@Entity
@Parcelize
@JsonClass(generateAdapter = true)
data class Movie(
  @field:Json(name = "id") @PrimaryKey val id: Int,
  @field:Json(name = "title") val title: String,
  @field:Json(name = "poster_path") val poster_path: String,
  @field:Json(name = "vote_average") val vote_average: Float,
  @field:Json(name = "overview") val overview: String,
  @field:Json(name = "page") var page: Int?
) : Parcelable {

  fun getVoteAverageString(): String = "$vote_average"
  fun getImageUrl(): String = "https://image.tmdb.org/t/p/w200$poster_path"
}
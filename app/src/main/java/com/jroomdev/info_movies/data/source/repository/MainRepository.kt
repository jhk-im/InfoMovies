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
package com.jroomdev.info_movies.data.source.repository

import android.util.Log
import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.jroomdev.info_movies.data.model.Movie
import com.jroomdev.info_movies.data.model.Result
import com.jroomdev.info_movies.data.source.local.MovieDao
import com.jroomdev.info_movies.data.source.network.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class MainRepository @Inject constructor(
  private val retrofitClient: RetrofitClient,
  private val movieDao: MovieDao
) : Repository {

  @WorkerThread
  suspend fun getMovies(
    page: Int,
    onSuccess: () -> Unit,
    onError: (String) -> Unit
  ) = flow {
    val movies = movieDao.getMovies(page)
    if (movies.isEmpty()) {
      val newMovies = ArrayList<Movie>()
      for (movie in retrofitClient.fetchMovies(page).results) {
        movie.page = page
        newMovies.add(movie)
      }
      movieDao.saveMovies(newMovies)
      emit(newMovies)
      onSuccess()
    } else {
      emit(movies)
      onSuccess()
    }
  }.flowOn(Dispatchers.IO)
}
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
package com.jrooms.info_movies.data.source.repository

import androidx.annotation.WorkerThread
import com.jrooms.info_movies.data.source.local.MovieInfoDao
import com.jrooms.info_movies.data.source.network.RetrofitClient
import com.skydoves.sandwich.message
import com.skydoves.sandwich.onError
import com.skydoves.sandwich.onException
import com.skydoves.sandwich.suspendOnSuccess
import com.skydoves.whatif.whatIfNotNull
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class DetailRepository @Inject constructor(
  private val retrofitClient: RetrofitClient,
  private val movieInfoDao: MovieInfoDao
) : Repository {

  @WorkerThread
  suspend fun getMovieInfo(
    id: Int,
    onSuccess: () -> Unit,
    onError: (String) -> Unit
  ) = flow {
    val movie = movieInfoDao.getMovieInfo(id)
    if (movie == null){
      val response = retrofitClient.getMovieInfo(id)
      response.suspendOnSuccess {
        data.whatIfNotNull { response ->
          movieInfoDao.saveMovieInfo(response)
          emit(response)
          onSuccess
        }
      }
        .onError {
          onError(message())
        }
        .onException {
          onError(message())
        }
    } else {
      emit(movie)
      onSuccess()
    }

  }.flowOn(Dispatchers.IO)
}
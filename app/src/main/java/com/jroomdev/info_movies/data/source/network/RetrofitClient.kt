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
package com.jroomdev.info_movies.data.source.network

import javax.inject.Inject

class RetrofitClient @Inject constructor(
  private val retrofitService: RetrofitService
) {

  suspend fun fetchMovies(
    page: Int
  ) = retrofitService.getMovies(
      page = page.toString(),
      api_key = "e7b63af5659f57f6415baadfc9a3c6c5",
      sort_by = "popularity.desc",
      language = "en"
    )
}
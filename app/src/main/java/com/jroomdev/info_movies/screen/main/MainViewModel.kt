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
package com.jroomdev.info_movies.screen.main

import androidx.annotation.MainThread
import androidx.databinding.ObservableBoolean
import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.jroomdev.info_movies.base.LiveCoroutinesViewModel
import com.jroomdev.info_movies.data.model.Movie
import com.jroomdev.info_movies.data.source.repository.MainRepository

class MainViewModel @ViewModelInject constructor(
  private val mainRepository: MainRepository,
  @Assisted private val savedStateHandle: SavedStateHandle
) : LiveCoroutinesViewModel() {

  private var moviesFetchingLiveData: MutableLiveData<Int> = MutableLiveData(0)
  val movies: LiveData<List<Movie>>

  val isLoading: ObservableBoolean = ObservableBoolean(false)

  private val _toastLiveData: MutableLiveData<String> = MutableLiveData()
  val toastLiveData: LiveData<String> get() = _toastLiveData

  init {
    movies = moviesFetchingLiveData.switchMap {
      launchOnViewModelScope {
        isLoading.set(true)
        this.mainRepository.getMovies(
          page = it,
          onSuccess = { isLoading.set(false) },
          onError = { _toastLiveData.postValue(it) }
        ).asLiveData()
      }
    }
  }

  @MainThread
  fun fetchMovieList(page: Int) {
    moviesFetchingLiveData.value = page
  }
}
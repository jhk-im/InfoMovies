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
package com.jrooms.info_movies.screen.detail

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.*
import com.jrooms.info_movies.base.LiveCoroutinesViewModel
import com.jrooms.info_movies.data.model.MovieInfo
import com.jrooms.info_movies.data.source.repository.DetailRepository
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class DetailViewModel @AssistedInject constructor(
  private val detailRepository: DetailRepository,
  @Assisted private val id: Int
) : LiveCoroutinesViewModel() {

  val movieInfoLiveData: LiveData<MovieInfo?>

  private val _toastLiveData: MutableLiveData<String> = MutableLiveData()
  val toastLiveData: LiveData<String> get() = _toastLiveData

  val isLoading: ObservableBoolean = ObservableBoolean(false)

  init {
    movieInfoLiveData = launchOnViewModelScope {
      isLoading.set(true)
      detailRepository.getMovieInfo(
        id = id,
        onSuccess = { isLoading.set(false) },
        onError = { _toastLiveData.postValue(it) }
      ).asLiveData()
    }
  }

  @AssistedInject.Factory
  interface AssistedFactory {
    fun create(id: Int): DetailViewModel
  }

  companion object {
    fun provideFactory(
      assistedFactory: AssistedFactory,
      id: Int
    ): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
      @Suppress("UNCHECKED_CAST")
      override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return assistedFactory.create(id) as T
      }
    }
  }
}
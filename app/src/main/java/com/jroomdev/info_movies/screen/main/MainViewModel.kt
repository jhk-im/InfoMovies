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

import android.util.Log
import androidx.annotation.MainThread
import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.jroomdev.info_movies.data.source.repository.MainRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainViewModel @ViewModelInject constructor(
    private val mainRepository: MainRepository,
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    init {

        viewModelScope.launch(Dispatchers.IO) { // (1) 코루틴의 launch 빌더 사용
            try {
                mainRepository.getMovies(1).collect {
                    for (movie in it) {
                        Log.e("title","${movie.title}")
                    }
                }
            } catch (e: Throwable) { // (3)
                Log.e("","${e.message}")
            }
        }
    }

    @MainThread
    fun getMovies(page: Int) {
    }
}
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
package com.jroomdev.info_movies.screen.detail

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.annotation.VisibleForTesting
import androidx.databinding.DataBindingUtil
import com.jroomdev.info_movies.R
import com.jroomdev.info_movies.data.model.Movie
import com.jroomdev.info_movies.databinding.ActivityDetailBinding
import com.skydoves.pokedex.extensions.argument
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {

  @Inject
  lateinit var detailViewModelFactory: DetailViewModel.AssistedFactory

  @VisibleForTesting
  val detailViewModel: DetailViewModel by viewModels {
    DetailViewModel.provideFactory(detailViewModelFactory, getMovie.id)
  }

  private val binding: ActivityDetailBinding by lazy {
    DataBindingUtil.setContentView(this, R.layout.activity_detail)
  }

  private val getMovie: Movie by argument(EXTRA_MOVIE)

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_detail)

    binding.apply {
      lifecycleOwner = this@DetailActivity
      movie = getMovie
      viewModel = detailViewModel
    }
  }

  companion object {
    @VisibleForTesting
    const val EXTRA_MOVIE = "EXTRA_MOVIE"

    fun startActivity(context: Context, movie: Movie) {
      if (context is Activity) {
        val intent = Intent(context, DetailActivity::class.java)
        intent.putExtra(EXTRA_MOVIE, movie)
        context.startActivity(intent)
      }
    }
  }
}
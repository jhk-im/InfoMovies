package com.jroomdev.info_movies.data.source.network

import com.jroomdev.info_movies.data.model.MovieListResponse
import retrofit2.Call
import javax.inject.Inject

class RetrofitClient @Inject constructor(
    private val retrofitService: RetrofitService
) {

//    suspend fun getMoviesRetrofit(param: Map<String, String>): Call<MovieListResponse> {
//        return retrofitService.getMovies(param)
//    }

}
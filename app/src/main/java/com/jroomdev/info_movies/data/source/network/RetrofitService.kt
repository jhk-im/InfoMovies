package com.jroomdev.info_movies.data.source.network

import com.jroomdev.info_movies.data.model.Movie
import com.jroomdev.info_movies.data.model.MovieListResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface RetrofitService {

    @GET("discover/movie")
    suspend fun getMovies(@QueryMap par: Map<String, String>): MovieListResponse
}
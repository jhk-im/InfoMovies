package com.jroomdev.info_movies.data.source.network

import retrofit2.http.GET
import retrofit2.http.Header

interface RetrofitService {

    @GET("leagues")
    suspend fun getLeagueList(@Header("Authorization") token: String?)

}
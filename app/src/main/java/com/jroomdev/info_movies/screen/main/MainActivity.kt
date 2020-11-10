package com.jroomdev.info_movies.screen.main

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.jroomdev.info_movies.R
import com.jroomdev.info_movies.data.source.network.HttpRequestInterceptor
import com.jroomdev.info_movies.data.source.network.RetrofitClient
import com.jroomdev.info_movies.data.source.network.RetrofitService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.await
import retrofit2.converter.moshi.MoshiConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()

        val retrofitService = retrofit.create(RetrofitService::class.java)

        val textView = findViewById<TextView>(R.id.test_text)
        val param = mapOf( // (1) GET 요청용 변수를 mapOf()를 사용해 지정
            "page" to "1",
            "api_key" to "API KEY",
            "sort_by" to "popularity.desc",
            "language" to "en"
        )

        GlobalScope.launch(Dispatchers.Main) { // (1) 코루틴의 launch 빌더 사용
            try {
                for (movie in retrofitService.getMovies(param).results) {
                    Log.e("movie","${movie.title}")
                }

            } catch (e: Throwable) { // (3)
                Log.e("","${e.message}")
            }
        }
    }
}
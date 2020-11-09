package com.jroomdev.info_movies.screen.main

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.jroomdev.info_movies.R
import com.jroomdev.info_movies.data.model.Movie
import com.jroomdev.info_movies.data.source.local.AppDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        val textView = findViewById<TextView>(R.id.test_text)

        val db = Room.inMemoryDatabaseBuilder(applicationContext, AppDatabase::class.java)
            .allowMainThreadQueries()
            .build()

        val league = Movie("EPL","epl.url")
        val league2 = Movie("SerieA","seriea.url")
        val league3 = Movie("LaLiga", "laliga.url")
        val leagues = ArrayList<Movie>()
        leagues.add(league)
        leagues.add(league2)
        leagues.add(league3)

        val scope = CoroutineScope(Dispatchers.IO)
        scope.launch {
            CoroutineScope(Dispatchers.IO).launch {
                db.leagueDao().saveLeagueList(leagues)
                textView.text = db.leagueDao().getLeagueList(0).toString()
            }
        }
    }
}
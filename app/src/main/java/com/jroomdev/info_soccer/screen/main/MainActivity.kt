package com.jroomdev.info_soccer.screen.main

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.jroomdev.info_soccer.R
import com.jroomdev.info_soccer.data.model.League
import com.jroomdev.info_soccer.data.source.local.AppDatabase
import com.jroomdev.info_soccer.data.source.local.TypeResponseConverter
import com.squareup.moshi.Moshi
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

        val league = League("EPL","epl.url")
        val league2 = League("SerieA","seriea.url")
        val league3 = League("LaLiga", "laliga.url")
        val leagues = ArrayList<League>()
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
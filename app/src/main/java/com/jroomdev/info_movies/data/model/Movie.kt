package com.jroomdev.info_movies.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.util.*

@Entity(tableName = "movies")
@JsonClass(generateAdapter = true)
data class Movie(
    @field:Json(name = "id") @PrimaryKey val id: String,
    @field:Json(name = "title") val title: String,
    @field:Json(name = "backdrop_path") val backdrop_path: String,
    @field:Json(name = "poster_path") val poster_path: String,
    var page: Int = 0
) {

}
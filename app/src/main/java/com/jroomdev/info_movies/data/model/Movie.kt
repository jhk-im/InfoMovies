package com.jroomdev.info_movies.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "movies")
@Parcelize
@JsonClass(generateAdapter = true)
data class Movie(
    @field:Json(name = "id") @PrimaryKey val id: Int,
    @field:Json(name = "overview") val overview: String,
    @field:Json(name = "release_date") val release_date: String,
    @field:Json(name = "adult") val adult: Boolean,
    @field:Json(name = "vote_count") val vote_count: Int,
    @field:Json(name = "vote_average") val vote_average: Float,
    @field:Json(name = "popularity") val popularity: Int,
    @field:Json(name = "title") val title: String,
    @field:Json(name = "poster_path") val poster_path: String,
    var page: Int = 0
) : Parcelable {

    fun getVoteCountString(): String = "$vote_count"
    fun getVoteAverageString(): String ="$vote_average"
    fun getPopularityString(): String = "$popularity"
    fun getImageUrl(): String = "https://image.tmdb.org/t/p/w200$poster_path"
}
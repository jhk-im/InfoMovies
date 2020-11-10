package com.jroomdev.info_movies.data.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "movies")
@Parcelize
data class Movie(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "poster_path") val poster_path: String,
    @ColumnInfo(name = "popularity")val popularity: Float,
    @ColumnInfo(name = "vote_count") val vote_count: Int,
    @ColumnInfo(name = "vote_average") val vote_average: Float,
    @ColumnInfo(name = "page") val page: Int?
) : Parcelable {

    fun getVoteCountString(): String = "$vote_count"
    fun getVoteAverageString(): String ="$vote_average"
    fun getPopularityString(): String = "$popularity"
    fun getImageUrl(): String = "https://image.tmdb.org/t/p/w200$poster_path"
}
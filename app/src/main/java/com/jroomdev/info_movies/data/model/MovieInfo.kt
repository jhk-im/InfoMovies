package com.jroomdev.info_movies.data.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize
import java.util.*

@Entity
@Parcelize
@JsonClass(generateAdapter = true)
data class MovieInfo(
  @PrimaryKey @ColumnInfo(name = "id") val id: Int,
  @ColumnInfo(name = "poster_path") val poster_path: String,
  @ColumnInfo(name = "overview") val overview: String,
  @ColumnInfo(name = "vote_average") val vote_average: Float,
  @ColumnInfo(name = "popularity") val popularity: Float,
  @ColumnInfo(name = "vote_count") val vote_count: Int,
  @ColumnInfo(name = "runtime") val runtime: Int,
  @ColumnInfo(name = "release_date") val release_date: Date

  ) : Parcelable {

  fun getVoteAverageString(): String = "$vote_average"
  fun getImageUrl(): String = "https://image.tmdb.org/t/p/w300$poster_path"
}
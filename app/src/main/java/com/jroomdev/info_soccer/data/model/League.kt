package com.jroomdev.info_soccer.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.util.*

@Entity(tableName = "leagues")
@JsonClass(generateAdapter = true)
data class League(
    @PrimaryKey @ColumnInfo(name = "id") var id: String = UUID.randomUUID().toString(),
    @field:Json(name = "name") val name: String,
    @field:Json(name = "url") val url: String,
    var page: Int = 0
) {

}
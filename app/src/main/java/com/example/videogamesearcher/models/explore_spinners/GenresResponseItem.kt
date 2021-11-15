package com.example.videogamesearcher.models.explore_spinners

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "genres_list_table")
data class GenresResponseItem(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val name: String

)

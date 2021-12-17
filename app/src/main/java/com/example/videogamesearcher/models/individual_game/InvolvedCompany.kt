package com.example.videogamesearcher.models.individual_game

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity
data class InvolvedCompany(
    @PrimaryKey
    val company: Company?,
    val developer: Boolean?,
    val id: Int?,
    val porting: Boolean?,
    val publisher: Boolean?,
    val supporting: Boolean?
)
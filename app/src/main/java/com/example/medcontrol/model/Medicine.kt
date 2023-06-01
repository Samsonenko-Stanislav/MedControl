package com.example.medcontrol.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity(tableName = "medicines")
data class Medicine(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val name: String,
    val dosage: String,
    val time: String,
    val duration: Int,
    val foodDependency: String,
    val endDate: LocalDate,
    val quantity: Int,
    val isTaken: Boolean
)
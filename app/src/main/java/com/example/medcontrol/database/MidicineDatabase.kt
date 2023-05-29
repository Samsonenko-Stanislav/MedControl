package com.example.medcontrol.database

import MedicineDao
import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.medcontrol.model.Medicine

@Database(entities = [Medicine::class], version = 1)
abstract class MedicineDatabase : RoomDatabase() {
    abstract fun medicineDao(): MedicineDao
}
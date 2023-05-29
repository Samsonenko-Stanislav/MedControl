package com.example.medcontrol.dao

import androidx.room.*
import com.example.medcontrol.model.Medicine

@Dao
interface MedicineDao {
    @Query("SELECT * FROM medicines")
    fun getAllMedicines(): List<Medicine>

    @Insert
    fun addMedicine(medicine: Medicine)

    @Delete
    fun deleteMedicine(medicine: Medicine)
}
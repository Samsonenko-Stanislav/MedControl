package com.example.medcontrol.dao
import androidx.room.*
import com.example.medcontrol.model.Medicine
import kotlinx.coroutines.flow.Flow

@Dao
interface MedicineDao {
    @Query("SELECT * FROM medicines")
    fun getAllMedicines(): Flow<List<Medicine>>

    @Insert
    suspend fun addMedicine(medicine: Medicine)

    @Delete
    suspend fun deleteMedicine(medicine: Medicine)

    @Update
    suspend fun updateMedicine(medicine: Medicine)
}

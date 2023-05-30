package com.example.medcontrol

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.room.Room
import com.example.medcontrol.ViewModel.MedicineViewModelFactory
import com.example.medcontrol.database.MedicineDatabase
import com.example.medcontrol.screens.MyApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val database = Room.databaseBuilder(
                context = this,
                MedicineDatabase::class.java,
                "medicine-db"
            ).build()
            val medicineDao = database.medicineDao()
            val medicineViewModelFactory = MedicineViewModelFactory(medicineDao)

            MyApp(medicineViewModelFactory, medicineDao)
        }
    }
}




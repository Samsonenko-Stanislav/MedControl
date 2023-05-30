package com.example.medcontrol

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.NavHost

import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import com.example.medcontrol.ViewModel.MedicineViewModel
import com.example.medcontrol.ViewModel.MedicineViewModelFactory
import com.example.medcontrol.database.MedicineDatabase
import com.example.medcontrol.screens.AddMedicineScreen
import com.example.medcontrol.screens.MedicineListScreen
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
            val medicineViewModel = ViewModelProvider(this, medicineViewModelFactory)
                .get(MedicineViewModel::class.java)

            MyApp(medicineViewModelFactory, medicineDao)
            val navController = rememberNavController()

            NavHost(navController, startDestination = "medicine_list") {
                composable("medicine_list") {
                    MedicineListScreen(navController = navController, medicineViewModel = medicineViewModel)
                }
                composable("medicine_add") {
                    AddMedicineScreen(navController = navController, medicineViewModel = medicineViewModel)
                }
            }



        }
    }
}

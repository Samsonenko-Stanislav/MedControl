package com.example.medcontrol.screens

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.medcontrol.ViewModel.MedicineViewModel
import com.example.medcontrol.ViewModel.MedicineViewModelFactory
import com.example.medcontrol.dao.MedicineDao

@Composable
fun MyApp(
    medicineViewModelFactory: MedicineViewModelFactory,
    medicineDao: MedicineDao
) {
    val navController = rememberNavController()
    val viewModel: MedicineViewModel = viewModel(factory = medicineViewModelFactory)
    NavHost(navController = navController, startDestination = "medicineList") {
        composable("medicineList") {
            MedicineListScreen(medicineViewModel = viewModel, navController = navController)
        }
        composable("addMedicine") {
            AddMedicineScreen(medicineViewModel = viewModel, navController = navController)

        }
    }
}

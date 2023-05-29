package com.example.medcontrol

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import com.example.medcontrol.ViewModel.MedicineViewModel
import com.example.medcontrol.ViewModel.MedicineViewModelFactory
import com.example.medcontrol.dao.MedicineDao
import com.example.medcontrol.database.MedicineDatabase
import com.example.medcontrol.screens.AddMedicineScreen
import com.example.medcontrol.screens.MedicineListScreen
import com.example.medcontrol.ui.theme.MyApplicationTheme

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

@Composable
fun MyApp(
    medicineViewModelFactory: MedicineViewModelFactory,
    medicineDao: MedicineDao
) {
    val viewModel: MedicineViewModel = viewModel(factory = medicineViewModelFactory)
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "medicineList") {
        composable("medicineList") {
            MedicineListScreen(medicineViewModel = viewModel)
        }
        composable("addMedicine") {
            AddMedicineScreen(medicineViewModel = viewModel)
        }
    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        // TODO: Implement the preview
    }
}

package com.example.medcontrol

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.room.Room
import com.example.medcontrol.database.MedicineDatabase
import com.example.medcontrol.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    private lateinit var medicineDatabase: MedicineDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        medicineDatabase = Room.databaseBuilder(
            applicationContext,
            MedicineDatabase::class.java,
            "medicine-db"
        ).build()

        setContent {
            MyApplicationTheme {
                val medicineViewModel: MedicineViewModel = viewModel(
                    factory = MedicineViewModelFactory(medicineDatabase.medicineDao())
                )
                MyApp(medicineViewModel)
            }
        }
    }
}

@Composable
fun MyApp(
    medicineViewModel: MedicineViewModel
) {
    // TODO: Implement the navigation between screens
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        // TODO: Implement the preview
    }
}

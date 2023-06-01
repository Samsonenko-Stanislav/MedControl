package com.example.medcontrol.screens

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.padding
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Save
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.medcontrol.ViewModel.MedicineViewModel
import com.example.medcontrol.model.Medicine
import java.time.LocalDate


@RequiresApi(Build.VERSION_CODES.O)
@SuppressLint("RememberReturnType")
@Composable
fun EditMedicineScreen(
    medicine: Medicine,
    medicineViewModel: MedicineViewModel = viewModel(),
    navController: NavController
) {
    val name = remember { mutableStateOf(medicine.name) }
    val dosage = remember { mutableStateOf(medicine.dosage) }
    val time = remember { mutableStateOf(medicine.time) }
    val duration = remember { mutableStateOf(medicine.duration) }
    val selectedFoodDependency = remember { mutableStateOf(medicine.foodDependency) }
    // ...
    val endDate = remember {
        val today = LocalDate.now()
        today.plusDays(duration.value.toLong())
    }
        Text("End Date: $endDate", modifier = Modifier.padding(16.dp))


    FloatingActionButton(
        onClick = {
            val updatedMedicine = Medicine(
                id = medicine.id,
                name = name.value,
                dosage = dosage.value,
                time = time.value,
                duration = duration.value,
                foodDependency = selectedFoodDependency.value
                endDate = endDate.value
            )

            // Обновление лекарства в базе данных
            medicineViewModel.updateMedicine(updatedMedicine)

            // Обновление списка лекарств
            medicineViewModel.getAllMedicines()

            // Вернуться на предыдущий экран
            navController.popBackStack()
        }
    ) {
        Icon(Icons.Filled.Save, contentDescription = "Save")
    }
}

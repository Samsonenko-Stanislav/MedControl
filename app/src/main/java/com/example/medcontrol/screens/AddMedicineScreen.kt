package com.example.medcontrol.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
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

@Composable
fun AddMedicineScreen(
    medicineViewModel: MedicineViewModel = viewModel()
) {
    val name = remember { mutableStateOf("") }
    val dosage = remember { mutableStateOf("") }
    val time = remember { mutableStateOf("") }
    val duration = remember { mutableStateOf(0) }
    val foodDependency = remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Add Medicine") },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            // Вернуться на предыдущий экран
                            // Необходимо реализовать навигацию
                        }
                    ) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    val medicine = Medicine(
                        name = name.value,
                        dosage = dosage.value,
                        time = time.value,
                        duration = duration.value,
                        foodDependency = foodDependency.value
                    )
                    medicineViewModel.addMedicine(medicine)
                    // Вернуться на предыдущий экран
                    // Необходимо реализовать навигацию
                }
            ) {
                Icon(Icons.Filled.Save, contentDescription = "Save")
            }
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Top
        ) {
            OutlinedTextField(
                value = name.value,
                onValueChange = { name.value = it },
                label = { Text(text = "Name") },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = dosage.value,
                onValueChange = { dosage.value = it },
                label = { Text(text = "Dosage") },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = time.value,
                onValueChange = { time.value = it },
                label = { Text(text = "Time") },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = duration.value.toString(),
                onValueChange = { duration.value = it.toIntOrNull() ?: 0 },
                label = { Text(text = "Duration") },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = foodDependency.value,
                onValueChange = { foodDependency.value = it },
                label = { Text(text = "Food Dependency") },
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

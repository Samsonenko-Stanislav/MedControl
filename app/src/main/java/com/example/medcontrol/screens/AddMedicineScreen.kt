package com.example.medcontrol.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Save
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.medcontrol.ViewModel.MedicineViewModel
import com.example.medcontrol.createNotification
import com.example.medcontrol.model.FoodDependency
import com.example.medcontrol.model.Medicine
import java.time.LocalDate

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun AddMedicineScreen(
    medicineViewModel: MedicineViewModel = viewModel(),
    navController: NavController
) {
    val name = remember { mutableStateOf("") }
    val dosage = remember { mutableStateOf("") }
    val time = remember { mutableStateOf("") }
    val duration = remember { mutableStateOf(0) }
    val foodDependency = remember { mutableStateOf("") }
    val foodDependencyOptions = FoodDependency.values().toList()
    val selectedFoodDependency = remember { mutableStateOf(FoodDependency.BEFORE) }
    val expanded = remember { mutableStateOf(false) }
    val context = LocalContext.current
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Add Medicine") },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            navController.popBackStack()
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
                        foodDependency = foodDependency.value,
                    )
                    // Уведомление
                    createNotification(
                        context,
                        medicine.name,
                        medicine.time
                    )

                    medicineViewModel.addMedicine(medicine)
                    navController.popBackStack()

                }
            ) {
                Icon(Icons.Filled.Save, contentDescription = "Save")
            }
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .padding(horizontal = 16.dp), // Используем contentPadding здесь
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
                modifier = Modifier.fillMaxWidth(),
                readOnly = true,
                trailingIcon = {
                    Icon(
                        Icons.Filled.ArrowDropDown,
                        contentDescription = "Toggle Food Dependency Dropdown",
                        modifier = Modifier.clickable { expanded.value = true }
                    )
                }
            )
            DropdownMenu(
                expanded = expanded.value,
                onDismissRequest = { expanded.value = false }
            ) {
                foodDependencyOptions.forEach { option ->
                    DropdownMenuItem(
                        onClick = {
                            selectedFoodDependency.value = option
                            foodDependency.value = option.value
                            expanded.value = false
                        }
                    ) {
                        Text(text = option.value)
                    }
                }
            }
        }
    }
}


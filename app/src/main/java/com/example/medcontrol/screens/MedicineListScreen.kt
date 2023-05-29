package com.example.medcontrol.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.medcontrol.ViewModel.MedicineViewModel
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.livedata.observeAsState


@Composable
fun MedicineListScreen(
    medicineViewModel: MedicineViewModel = viewModel()
) {
    val medicines = medicineViewModel.allMedicines.observeAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Medicine Tracker") }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    // Navigate to the medicine addition screen
                    // Navigation implementation is required
                }
            ) {
                Icon(Icons.Filled.Add, contentDescription = "Add Medicine")
            }
        }
    ) {
        if (medicines.value.isNullOrEmpty()) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "No medicines added.",
                    style = MaterialTheme.typography.subtitle1
                )
            }
        } else {
            // Display the list of medicines
            LazyColumn {
                items(medicines.value?.size ?: 0) { index ->
                    val medicine = medicines.value?.get(index)
                    if (medicine != null) {
                        MedicineListItem(medicine)
                    }
                }
            }
        }
    }
}

package com.example.medcontrol.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.medcontrol.model.Medicine

@Composable
fun MedicineListItem(medicine: Medicine) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = 4.dp
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = medicine.name, style = MaterialTheme.typography.h6)
            Text(text = "Dosage: ${medicine.dosage}")
            Text(text = "Time: ${medicine.time}")
            Text(text = "Duration: ${medicine.duration} days")
            Text(text = "Food Dependency: ${medicine.foodDependency}")
        }
    }
}
package com.example.medcontrol.screens

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Checkbox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.medcontrol.model.Medicine

@Composable
fun MedicineItem(
    medicine: Medicine,
    onMedicineTaken: (Boolean) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // ...

        Checkbox(
            checked = medicine.isTaken,
            onCheckedChange = { isChecked ->
                onMedicineTaken(isChecked)
            }
        )
    }
}
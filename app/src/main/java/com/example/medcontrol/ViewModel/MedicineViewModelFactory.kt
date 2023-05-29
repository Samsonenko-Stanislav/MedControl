package com.example.medcontrol.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.medcontrol.dao.MedicineDao

class MedicineViewModelFactory(private val medicineDao: MedicineDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
        if (modelClass.isAssignableFrom(MedicineViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MedicineViewModel(medicineDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
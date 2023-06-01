package com.example.medcontrol.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.medcontrol.dao.MedicineDao
import com.example.medcontrol.model.Medicine
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MedicineViewModel(private val medicineDao: MedicineDao) : ViewModel() {
    val allMedicines: LiveData<List<Medicine>> = medicineDao.getAllMedicines().asLiveData()

    fun addMedicine(medicine: Medicine) {
        viewModelScope.launch(Dispatchers.IO) {
            medicineDao.addMedicine(medicine)
        }
    }

    fun deleteMedicine(medicine: Medicine) {
        viewModelScope.launch(Dispatchers.IO) {
            medicineDao.deleteMedicine(medicine)
        }


        }

    fun updateMedicine(medicine: Medicine) {
        viewModelScope.launch(Dispatchers.IO) {
            medicineDao.updateMedicine(medicine)
        }
    }

    fun getAllMedicines() {
        viewModelScope.launch(Dispatchers.IO){
            medicineDao.getAllMedicines()
        }
    }
}

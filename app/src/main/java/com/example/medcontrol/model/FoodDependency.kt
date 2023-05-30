package com.example.medcontrol.model

enum class FoodDependency(val value: String) {
    BEFORE("Before food"),
    DURING("During food"),
    AFTER("After food"),
    INDEPENDENT("Independent of food")
}
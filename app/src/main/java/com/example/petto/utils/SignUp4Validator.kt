package com.example.petto.utils

object SignUp4Validator {
    fun isFormValid(
        petType: String,
        breed: String,
        weight: String,
        height: String,
        color: String
    ): Boolean {
        return petType.isNotBlank()
                && breed.isNotBlank()
                && weight.isNotBlank() && weight.toDoubleOrNull() != null
                && height.isNotBlank() && height.toDoubleOrNull() != null
                && color.isNotBlank()
    }
}

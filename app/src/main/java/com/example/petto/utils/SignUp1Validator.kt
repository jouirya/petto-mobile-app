package com.example.petto.utils



object SignUp1Validator {

    fun isNameValid(name: String): Boolean {
        return name.trim().isNotEmpty()
    }

    fun isAgeValid(age: String): Boolean {
        return age.trim().toIntOrNull()?.let { it in 1..99 } == true
    }

    fun isGenderSelected(gender: String): Boolean {
        return gender.trim().isNotEmpty()
    }

    fun isCountryValid(country: String): Boolean {
        return country.trim().isNotEmpty()
    }

    fun isCityValid(city: String): Boolean {
        return city.trim().isNotEmpty()
    }

    fun isFormValid(name: String, age: String, gender: String, country: String, city: String): Boolean {
        return isNameValid(name) &&
                isAgeValid(age) &&
                isGenderSelected(gender) &&
                isCountryValid(country) &&
                isCityValid(city)
    }
}

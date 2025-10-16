package com.example.petto

import com.example.petto.utils.SignUp4Validator
import org.junit.Assert.*
import org.junit.Test

class SignUp4ValidatorTest {

    @Test
    fun validInputs_returnsTrue() {
        val result = SignUp4Validator.isFormValid(
            petType = "Dog",
            breed = "Labrador",
            weight = "12.5",
            height = "45.0",
            color = "Golden"
        )
        assertTrue(result)
    }

    @Test
    fun emptyPetType_returnsFalse() {
        val result = SignUp4Validator.isFormValid(
            petType = "",
            breed = "Husky",
            weight = "10",
            height = "40",
            color = "White"
        )
        assertFalse(result)
    }

    @Test
    fun nonNumericWeight_returnsFalse() {
        val result = SignUp4Validator.isFormValid(
            petType = "Cat",
            breed = "Siamese",
            weight = "abc",
            height = "25",
            color = "Cream"
        )
        assertFalse(result)
    }

    @Test
    fun emptyFields_returnsFalse() {
        val result = SignUp4Validator.isFormValid("", "", "", "", "")
        assertFalse(result)
    }
}

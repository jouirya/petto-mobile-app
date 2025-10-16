package com.example.petto

import com.example.petto.utils.SignUp1Validator
import org.junit.Assert.*
import org.junit.Test

class SignUp1ValidatorTest {

    @Test
    fun validInputs_returnsTrue() {
        val result = SignUp1Validator.isFormValid(
            name = "Alice",
            age = "25",
            gender = "Female",
            country = "Egypt",
            city = "Cairo"
        )
        assertTrue(result)
    }

    @Test
    fun emptyName_returnsFalse() {
        val result = SignUp1Validator.isFormValid(
            name = "",
            age = "25",
            gender = "Female",
            country = "Egypt",
            city = "Cairo"
        )
        assertFalse(result)
    }

    @Test
    fun nonNumericAge_returnsFalse() {
        val result = SignUp1Validator.isFormValid(
            name = "Alice",
            age = "twenty",
            gender = "Female",
            country = "Egypt",
            city = "Cairo"
        )
        assertFalse(result)
    }

    @Test
    fun emptyGender_returnsFalse() {
        val result = SignUp1Validator.isFormValid(
            name = "Alice",
            age = "25",
            gender = "",
            country = "Egypt",
            city = "Cairo"
        )
        assertFalse(result)
    }

    @Test
    fun ageOutOfRange_returnsFalse() {
        val result = SignUp1Validator.isFormValid(
            name = "Alice",
            age = "120",
            gender = "Female",
            country = "Egypt",
            city = "Cairo"
        )
        assertFalse(result)
    }

    @Test
    fun nameWithOnlySpaces_returnsFalse() {
        val result = SignUp1Validator.isFormValid(
            name = "   ",
            age = "25",
            gender = "Female",
            country = "Egypt",
            city = "Cairo"
        )
        assertFalse(result)
    }
}

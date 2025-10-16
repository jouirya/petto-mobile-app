package com.example.petto

import com.example.petto.utils.SignUp2Validator
import org.junit.Assert.*
import org.junit.Test

class SignUp2ValidatorTest {

    @Test
    fun validInputs_returnsTrue() {
        val result = SignUp2Validator.isFormValid(
            email = "test@example.com",
            password = "password123",
            confirmPassword = "password123"
        )
        assertTrue(result)
    }

    @Test
    fun emptyEmail_returnsFalse() {
        val result = SignUp2Validator.isFormValid(
            email = "",
            password = "password123",
            confirmPassword = "password123"
        )
        assertFalse(result)
    }

    @Test
    fun invalidEmail_returnsFalse() {
        val result = SignUp2Validator.isFormValid(
            email = "invalid-email",
            password = "password123",
            confirmPassword = "password123"
        )
        assertFalse(result)
    }

    @Test
    fun shortPassword_returnsFalse() {
        val result = SignUp2Validator.isFormValid(
            email = "test@example.com",
            password = "123",
            confirmPassword = "123"
        )
        assertFalse(result)
    }

    @Test
    fun mismatchedPasswords_returnsFalse() {
        val result = SignUp2Validator.isFormValid(
            email = "test@example.com",
            password = "password123",
            confirmPassword = "different123"
        )
        assertFalse(result)
    }
}

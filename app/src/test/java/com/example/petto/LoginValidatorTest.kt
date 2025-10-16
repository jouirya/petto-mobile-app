package com.example.petto
import com.example.petto.utils.LoginValidator
import org.junit.Assert.assertTrue
import org.junit.Assert.assertFalse
import org.junit.Test

// LoginValidatorTest.kt
class LoginValidatorTest {

    @Test
    fun validEmailAndPassword_returnsTrue() {
        assertTrue(LoginValidator.isEmailValid("sama@example.com"))
        assertTrue(LoginValidator.isPasswordValid("123456"))
    }

    @Test
    fun emptyEmail_returnsFalse() {
        assertFalse(LoginValidator.isEmailValid(""))
    }

    @Test
    fun malformedEmail_returnsFalse() {
        assertFalse(LoginValidator.isEmailValid("user@com"))
    }

    @Test
    fun emptyPassword_returnsFalse() {
        assertFalse(LoginValidator.isPasswordValid(""))
    }
}

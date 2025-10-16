package com.example.petto.utils

object SignUp2Validator {

    private val EMAIL_REGEX = Regex("^[A-Za-z](.*)([@]{1})(.{1,})(\\.)(.{1,})")

    fun isFormValid(email: String, password: String, confirmPassword: String): Boolean {
        if (email.isEmpty()) return false
        if (!EMAIL_REGEX.matches(email)) return false
        if (password.isEmpty() || password.length < 6) return false
        if (confirmPassword.isEmpty()) return false
        if (password != confirmPassword) return false
        return true
    }
}

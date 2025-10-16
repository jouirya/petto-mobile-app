package com.example.petto.utils


object LoginValidator {

    // Enhanced pattern to match emails like "user@domain.com"
    private val emailRegex = Regex("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")

    fun isEmailValid(email: String): Boolean {
        return email.isNotEmpty() && emailRegex.matches(email)
    }

    fun isPasswordValid(password: String): Boolean {
        return password.isNotEmpty()
    }
}


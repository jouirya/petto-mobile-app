package com.example.petto

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import com.example.petto.ui.SignUp.SignUp2
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import kotlin.jvm.java

@RunWith(AndroidJUnit4::class)
class SignUp2ActivityTest {

    @get:Rule
    val rule = ActivityScenarioRule(SignUp2::class.java)

    @Test
    fun showErrors_whenFieldsAreEmpty() {
        onView(withId(R.id.btnNext)).perform(click())

        onView(withId(R.id.etEmail)).check(matches(hasErrorText("Email is required")))
        onView(withId(R.id.etPassword)).check(matches(hasErrorText("Password is required")))
        onView(withId(R.id.etConfirmPassword)).check(matches(hasErrorText("Confirm your password")))
    }
}

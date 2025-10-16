package com.example.petto

import android.view.View
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.BoundedMatcher
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.petto.ui.SignUp.SignUp4
import com.google.android.material.textfield.TextInputLayout
import org.hamcrest.Description
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class SignUp4ActivityTest {

    @get:Rule
    val rule = ActivityScenarioRule(SignUp4::class.java)

    @Test
    fun showError_whenFieldsAreEmpty() {
        onView(withId(R.id.btnDone)).perform(click())

        onView(withId(R.id.spinnerType)).check(matches(withTextInputLayoutError("Pet type is required")))
        onView(withId(R.id.BreedTitle)).check(matches(withTextInputLayoutError("Breed is required")))
    }

    private fun withTextInputLayoutError(expectedError: String) =
        object : BoundedMatcher<View, TextInputLayout>(TextInputLayout::class.java) {
            override fun describeTo(description: Description) {
                description.appendText("with error: $expectedError")
            }

            override fun matchesSafely(view: TextInputLayout): Boolean {
                return expectedError == view.error?.toString()
            }
        }
}

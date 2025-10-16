package com.example.petto


import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.matcher.RootMatchers.isPlatformPopup
import androidx.test.espresso.matcher.ViewMatchers.*
import com.example.petto.ui.SignUp.SignUp1
import org.hamcrest.Matchers.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class SignUp1ActivityTest {

    @get:Rule
    val rule = ActivityScenarioRule(SignUp1::class.java)


    @Test
    fun proceed_whenAllFieldsAreValid() {
        onView(withId(R.id.etFirstName)).perform(typeText("Sara"), closeSoftKeyboard())
        onView(withId(R.id.etLastName)).perform(typeText("Ali"), closeSoftKeyboard())
        onView(withId(R.id.etAge)).perform(typeText("25"), closeSoftKeyboard())

        // Wait for spinners to load if needed (use IdlingResource in real apps)
        onView(withId(R.id.spinnerCity)).perform(click())
        onView(withText(startsWith("Cairo"))).inRoot(isPlatformPopup()).perform(click())

        onView(withId(R.id.spinnerarea)).perform(click())
        onView(withText(containsString("Nasr City"))).inRoot(isPlatformPopup()).perform(click())

        onView(withId(R.id.spinnerGender)).perform(click())
        onView(withText("Female")).inRoot(isPlatformPopup()).perform(click())

        onView(withId(R.id.btnNext)).perform(click())
        // You can assert intent or next screen behavior here if needed
    }
}








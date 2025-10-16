package com.example.petto


import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import com.example.petto.ui.Login.Login
import com.example.petto.ui.SignUp.SignUp1
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class LoginActivityTest {

    @get:Rule
    val rule = ActivityScenarioRule(Login::class.java)

    @Test

    fun emptyEmailPassword_doesNotLogin() {
        onView(withId(R.id.btnLogin)).perform(click())

        Thread.sleep(2000)

        // Assert that we're still on LoginActivity by checking a visible view
        onView(withId(R.id.btnLogin)).check(matches(isDisplayed()))
    }


    @Test
    fun clickingSignUp_opensSignUpActivity() {
        Intents.init()
        onView(withId(R.id.tvSignUp)).perform(click())
        Intents.intended(hasComponent(SignUp1::class.java.name))
        Intents.release()
    }
}

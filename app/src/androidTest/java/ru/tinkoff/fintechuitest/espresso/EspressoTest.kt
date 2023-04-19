package ru.tinkoff.fintechuitest.espresso

import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import ru.tinkoff.fintechuitest.MainActivity
import ru.tinkoff.fintechuitest.R
import ru.tinkoff.fintechuitest.espresso.screens.EspressoFirstScreen
import ru.tinkoff.fintechuitest.espresso.screens.EspressoLoginScreen

@RunWith(AndroidJUnit4::class)
class EspressoTest {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)


    @Test
    fun fragmentNavigationTest() {
        val firstScreen = EspressoFirstScreen()
        val loginScreen = EspressoLoginScreen()
        firstScreen.clickFirstButton()
        loginScreen.clickPreviousButton()
        firstScreen.checkScreenTitle("First Fragment")
    }


    @Test
    fun checkFabNotification(){
        val firstScreen = EspressoFirstScreen()
        with(firstScreen){
            clickFab()
            checkTextOnSnackBar("Replace with your own action")
        }
    }

    @Test
    fun myClassMethod_ReturnsTrue() {
        val firstScreen = EspressoFirstScreen()
        val loginScreen = EspressoLoginScreen()

        val loginValue = "Tinkoff"
        val passwordValue = "Fintech"

        firstScreen.clickFirstButton()
        with (loginScreen) {
            typeTextToLoginFiled(loginValue)
            typeTextToPasswordFiled(passwordValue)
            clickSubmitButton()
            checkTextOnSnackBar("You enter login = $loginValue password = $passwordValue")
        }
    }


    @Test
    fun checkHintColor(){
        val firstScreen = EspressoFirstScreen()

        firstScreen.clickFirstButton()
        with (EspressoLoginScreen()) {
            clickSubmitButton()
            checkLoginHintColor(R.color.error_hint)
        }
    }

}

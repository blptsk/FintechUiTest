package ru.tinkoff.fintechuitest.espresso.espresso_advanced

import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import ru.tinkoff.fintechuitest.MainActivity
import ru.tinkoff.fintechuitest.R
import ru.tinkoff.fintechuitest.espresso.screens.EspressoFirstScreen
import ru.tinkoff.fintechuitest.espresso.espresso_advanced.screens.EspressoFirstScreenAdvanced
import ru.tinkoff.fintechuitest.espresso.espresso_advanced.screens.EspressoLoginScreenAdvanced

@RunWith(AndroidJUnit4::class)
class EspressoAdvancedTest {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)


    @Test
    fun fragmentNavigationTest() {
        // что это за вызовы такие - написано в EspressoFirstScreenAdvanced

        EspressoFirstScreenAdvanced { clickFirstButton() }
        EspressoLoginScreenAdvanced { clickPreviousButton() }
        EspressoFirstScreenAdvanced { checkScreenTitle("First Fragment") }
    }


    @Test
    fun checkFabNotification(){
        EspressoFirstScreenAdvanced {
            clickFab()
            checkTextOnSnackBar("Replace with your own action")
        }
    }

    @Test
    fun myClassMethod_ReturnsTrue() {
        val loginValue = "Tinkoff"
        val passwordValue = "Fintech"

        EspressoFirstScreenAdvanced {clickFirstButton() }
        EspressoLoginScreenAdvanced {
            typeTextToLoginFiled(loginValue)
            typeTextToPasswordFiled(passwordValue)
            clickSubmitButton()
            checkTextOnSnackBar("You enter login = $loginValue password = $passwordValue")
        }
    }


    @Test
    fun checkHintColor(){

        EspressoFirstScreenAdvanced { clickFirstButton() }
        EspressoLoginScreenAdvanced {
            clickSubmitButton()
            checkLoginHintColor(R.color.error_hint)
        }
    }

}

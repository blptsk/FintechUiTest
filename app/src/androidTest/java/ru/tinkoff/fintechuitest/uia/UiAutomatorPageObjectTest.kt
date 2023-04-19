package ru.tinkoff.fintechuitest.uia

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Rule
import org.junit.Test
import ru.tinkoff.fintechuitest.MainActivity
import ru.tinkoff.fintechuitest.uia.screens.FirstPage
import ru.tinkoff.fintechuitest.uia.screens.LoginPage
import ru.tinkoff.fintechuitest.R

class UiAutomatorPageObjectTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun enterLoginPasswordTest() {
        val loginValue = "Tinkoff"
        val passwordValue = "Fintech"

        val firstPage = FirstPage()
        val loginPage = LoginPage()

        with(firstPage) {
            pressNextButton()
        }
        with( loginPage ){
            enterLogin(loginValue)
            enterPassword(passwordValue)
            pressSubmitButton()
            checkTextOnSnackBar("You enter login = $loginValue password = $passwordValue")
        }
    }


    @Test
    fun checkSwitchingTextTest(){
        val firstText = InstrumentationRegistry.getInstrumentation().targetContext.getString(R.string.first_text)
        val secondText =  InstrumentationRegistry.getInstrumentation().targetContext.getString(R.string.second_text)

        val firstPage = FirstPage()
        with(firstPage) {
            checkTextOnScreen(firstText)
            pressChangeButton()
            checkTextOnScreen(secondText)
        }
    }

}
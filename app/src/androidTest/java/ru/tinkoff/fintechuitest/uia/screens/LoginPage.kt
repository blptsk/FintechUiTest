package ru.tinkoff.fintechuitest.uia.screens

import androidx.test.uiautomator.By
import androidx.test.uiautomator.Until
import junit.framework.Assert.assertTrue

class LoginPage: BasePage() {

    private val loginFiledSelector = By.res("ru.tinkoff.fintechuitest:id/edittext_login")
    private val passwordFiledSelector = By.res("ru.tinkoff.fintechuitest:id/edittext_password")
    private val submitButtonSelector = By.res("ru.tinkoff.fintechuitest:id/button_submit")


    fun enterLogin(loginValue: String) {
        device
            .wait(Until.findObject(loginFiledSelector), waitingTimeOut)
            .text = loginValue
    }

    fun enterPassword(passwordValue: String) {
        device
            .wait(Until.findObject(passwordFiledSelector), waitingTimeOut)
            .text = passwordValue
    }

    fun checkTextOnSnackBar(text: String) {
        assertTrue("text = $text not found",
            device.wait(Until.hasObject(By.text(text)), waitingTimeOut))
    }

    fun pressSubmitButton() {
        device
            .wait(Until.findObject(submitButtonSelector), waitingTimeOut)
            .click()
    }

}

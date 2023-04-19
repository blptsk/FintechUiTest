package ru.tinkoff.fintechuitest.uia.screens

import androidx.test.uiautomator.By
import androidx.test.uiautomator.Until
import junit.framework.Assert
import junit.framework.Assert.assertTrue

class FirstPage : BasePage(){

    private val nextButtonSelector = By.res("ru.tinkoff.fintechuitest:id/button_first")
    private val changeButtonSelector = By.res("ru.tinkoff.fintechuitest:id/change_button")

    fun pressNextButton() {
        device
            .wait(Until.findObject(nextButtonSelector), waitingTimeOut)
            .click()
    }

    fun checkTextOnScreen(firstText: String) {
        assertTrue("text = $firstText not found",
            device.wait(Until.hasObject(By.text(firstText)), waitingTimeOut))
    }

    fun pressChangeButton() {
        device
            .wait(Until.findObject(changeButtonSelector), waitingTimeOut)
            .click()
    }

}

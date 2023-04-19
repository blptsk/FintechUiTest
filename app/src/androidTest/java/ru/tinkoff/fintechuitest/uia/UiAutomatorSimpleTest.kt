package ru.tinkoff.fintechuitest.uia

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry.getInstrumentation
import androidx.test.uiautomator.By
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.Until
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import ru.tinkoff.fintechuitest.MainActivity

@RunWith(AndroidJUnit4::class)
class UiAutomatorSimpleTest {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    private val device = UiDevice.getInstance(getInstrumentation())
    private val waitingTimeOut = 2000L

    @Test
    fun fragmentNavigationTest() {
        device
            .wait(Until.findObject(By.text("Next")), waitingTimeOut)
            .click()
        device
            .wait(Until.findObject(By.text("Previous")), waitingTimeOut)
            .click()

        val expectedText = "First Fragment"
        assertTrue(
            "text = $expectedText not found",
            device
                .wait(Until.hasObject(By.text(expectedText)), waitingTimeOut)
        )
    }


    @Test
    fun notificationShowingTest(){
        device
            .wait(Until.findObject(By.res("ru.tinkoff.fintechuitest:id/fab")), waitingTimeOut)
            .click()

        val expectedText = "Replace with your own action"
        assertTrue(
            "text = $expectedText not found",
            device
                .wait(Until.hasObject(By.text(expectedText)), waitingTimeOut)
        )
    }
}
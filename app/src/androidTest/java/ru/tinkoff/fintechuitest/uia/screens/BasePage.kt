package ru.tinkoff.fintechuitest.uia.screens

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.UiDevice

open class BasePage {
    val device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
    val waitingTimeOut = 2000L

}
package ru.tinkoff.fintechuitest.rules

import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test
import ru.tinkoff.fintechuitest.MainActivity

class ActivityScenarioRuleTest {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun myAwesomeTest() {
        // your test implementation
    }
}


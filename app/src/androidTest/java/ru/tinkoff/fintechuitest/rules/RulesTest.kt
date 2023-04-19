package ru.tinkoff.fintechuitest.rules

import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class RulesTest {

    @get:Rule
    val rule = SimpleRule()

    @Before
    fun before() {
        println("before test")
    }

    @After
    fun after() {
        println("after test")
    }

    @Test
    fun useAppContext() {
       println("test")
    }
}
package ru.tinkoff.fintechuitest.rules

import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement

class SimpleRule: TestRule {
    override fun apply(base: Statement, description: Description): Statement {
        return object : Statement() {
            override fun evaluate() {
                println("rule before")
                base.evaluate()
                println("rule after")
            }
        }
    }
}


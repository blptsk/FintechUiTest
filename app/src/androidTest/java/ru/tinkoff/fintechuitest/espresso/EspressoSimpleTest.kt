package ru.tinkoff.fintechuitest.espresso

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.android.material.snackbar.SnackbarContentLayout
import com.google.android.material.textview.MaterialTextView
import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.instanceOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import ru.tinkoff.fintechuitest.MainActivity
import ru.tinkoff.fintechuitest.R

@RunWith(AndroidJUnit4::class)
class EspressoSimpleTest {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun fragmentNavigationTest() {
        onView(withText("Next"))
            .perform(ViewActions.click())
        onView(withText("Previous"))
            .perform(ViewActions.click())
        onView(withText("First Fragment"))
            .check(matches(isDisplayed()))
    }

    @Test
    fun notificationShowingTest(){
        onView(withId(R.id.fab))
            .perform(ViewActions.click())

        onView(
            allOf(
                withParent(instanceOf(SnackbarContentLayout::class.java)),
                instanceOf(MaterialTextView::class.java)
            )
        )
            .check(matches(isDisplayed()))
    }
}

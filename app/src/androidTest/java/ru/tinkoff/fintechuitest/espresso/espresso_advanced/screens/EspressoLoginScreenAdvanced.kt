package ru.tinkoff.fintechuitest.espresso.espresso_advanced.screens

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withParent
import com.google.android.material.snackbar.SnackbarContentLayout
import com.google.android.material.textview.MaterialTextView
import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.instanceOf
import ru.tinkoff.fintechuitest.R
import ru.tinkoff.fintechuitest.espresso.matchers.TextViewHintColorMatcher

class EspressoLoginScreenAdvanced {

    private val buttonPreviousMatcher  = withId(R.id.button_second)
    private val buttonSubmitMatcher  = withId(R.id.button_submit)
    private val editTextLoginFieldMatcher = withId(R.id.edittext_login)
    private val editTextPasswordFieldMatcher = withId(R.id.edittext_password)
    private val snackBarTextViewMatcher = allOf(
        withParent(instanceOf(SnackbarContentLayout::class.java)),
        instanceOf(MaterialTextView::class.java)
    )

    fun clickPreviousButton(){
        onView(buttonPreviousMatcher)
            .perform(click())
    }

    fun clickSubmitButton(){
        onView(buttonSubmitMatcher)
            .perform(click())
    }

    fun typeTextToLoginFiled(text: String) {
        onView(editTextLoginFieldMatcher)
            .perform(typeText(text))
    }
    fun typeTextToPasswordFiled(text: String) {
        onView(editTextPasswordFieldMatcher)
            .perform(typeText(text))
    }

    fun checkTextOnSnackBar(text: String) {
        onView(snackBarTextViewMatcher)
            .check(ViewAssertions.matches(ViewMatchers.withText(text)))
    }

    fun checkLoginHintColor(errorHintId: Int) {
        onView(editTextLoginFieldMatcher)
            .check(ViewAssertions.matches(TextViewHintColorMatcher(errorHintId)))
    }

    companion object {
        // что это такое - написано в EspressoFirstScreenAdvanced
        inline operator fun invoke(crossinline block: EspressoLoginScreenAdvanced.() -> Unit) = EspressoLoginScreenAdvanced().block()
    }
}
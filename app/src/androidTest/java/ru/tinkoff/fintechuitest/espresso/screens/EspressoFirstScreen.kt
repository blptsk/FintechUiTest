package ru.tinkoff.fintechuitest.espresso.screens

import androidx.appcompat.widget.AppCompatTextView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.snackbar.SnackbarContentLayout
import com.google.android.material.textview.MaterialTextView
import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.instanceOf
import ru.tinkoff.fintechuitest.R

class EspressoFirstScreen {
    private val firstButtonMatcher = withId(R.id.button_first)
    private val buttonShowDialog = withId(R.id.dialog_button)
    private val buttonShowToast = withId(R.id.toast_button)
    private val textView = withId(R.id.textview_first)
    private val snackBarTextViewMatcher = allOf(
        ViewMatchers.withParent(instanceOf(SnackbarContentLayout::class.java)),
        instanceOf(MaterialTextView::class.java)
    )
    private val fabMatcher = withId(R.id.fab)
    private val screenTitleMatcher = allOf(
        instanceOf(AppCompatTextView::class.java),
        ViewMatchers.withParent(instanceOf(MaterialToolbar::class.java))
    )

    fun clickFirstButton(){
        onView(firstButtonMatcher)
            .perform(click())
    }

    fun clickDialogButton(){
        onView(buttonShowDialog)
            .perform(click())
    }

    fun clickToastButton(){
        onView(buttonShowToast)
            .perform(click())
    }

    fun checkTextOnSnackBar(text: String) {
        onView(snackBarTextViewMatcher)
            .check(matches(withText(text)))
    }

    fun checkTextOnTextView(text: String) {
        onView(textView)
            .check(matches(withText(text)))
    }

    fun clickFab(){
        onView(fabMatcher)
            .perform(click())
    }

    fun checkScreenTitle(title : String) {
        onView(screenTitleMatcher)
            .check(matches(withText(title)))
    }
}
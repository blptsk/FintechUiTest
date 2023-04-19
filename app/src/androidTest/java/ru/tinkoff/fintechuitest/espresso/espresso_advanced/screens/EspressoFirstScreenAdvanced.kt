package ru.tinkoff.fintechuitest.espresso.espresso_advanced.screens

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

class EspressoFirstScreenAdvanced {
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
    companion object {
        /* invoke - оператор вызова и он эквивалентен вызову функций через скобки
         a() эквивалентно вызову a.invoke()
         в нашем классе мы написали подобный оператор, который принимает лямбду в качестве аргумента, а потом создает экземпляр страницы и вызывает эту лямбду
         это все я написал, чтобы уменьшить количество скобок в теле теста, и, вместо

         val firstScreen = EspressoFirstScreen()
            with(firstScreen) {
              clickToastButton()
              clickDialogButton()
              clickFirstButton()
              checkScreenTitle("")
            }


         можно будет писать так

         EspressoFirstScreen {
              clickToastButton()
              clickDialogButton()
              clickFirstButton()
              checkScreenTitle("")
         }
         Пример можно увидеть в файле EspressoAdvancedTest
        */


        inline operator fun invoke(crossinline block: EspressoFirstScreenAdvanced.() -> Unit) = EspressoFirstScreenAdvanced().block()
    }
}
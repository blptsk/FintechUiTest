package ru.tinkoff.fintechuitest.espresso.matchers

import android.content.res.Resources
import android.os.Build
import android.view.View
import android.widget.TextView
import androidx.annotation.ColorRes
import androidx.test.espresso.matcher.BoundedMatcher
import androidx.test.platform.app.InstrumentationRegistry
import org.hamcrest.Description

class TextViewHintColorMatcher(@ColorRes private val  resId: Int) : BoundedMatcher<View, TextView>(TextView::class.java) {
    private val color = colorRes(resId)

    override fun describeTo(description: Description) {
        description.appendText("textView.currentHintTextColor is ${getHexColor(color)}")
    }

    override fun matchesSafely(textView: TextView): Boolean {
        return textView.currentHintTextColor == color
    }

    @Suppress("MagicNumber")
    private fun getHexColor(color: Int): String {
        return String.format("#%06X", 0xFFFFFF and color)
    }
}


fun colorRes(@ColorRes resId: Int, theme: Resources.Theme? = null): Int {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        InstrumentationRegistry.getInstrumentation().targetContext.resources.getColor(resId, theme)
    } else {
        InstrumentationRegistry.getInstrumentation().targetContext.resources.getColor(resId)
    }
}
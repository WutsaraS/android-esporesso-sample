package com.sourcey.materiallogindemo;
import android.os.SystemClock;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
@LargeTest

public class MainActivityTest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class, true, true);

    @Test
    public void mainActivitySuccess () {
        onView(withId(R.id.link_signup)).perform(scrollTo(), closeSoftKeyboard(), click());
        onView(withId(R.id.input_name)).perform(scrollTo());
        onView(withId(R.id.input_name)).check(matches(isDisplayed()));
        onView(withId(R.id.input_name)).perform(typeText("TestKa"), closeSoftKeyboard());
        onView(withId(R.id.input_address)).perform(scrollTo());
        onView(withId(R.id.input_address)).check(matches(isDisplayed()));
        onView(withId(R.id.input_address)).perform(typeText("123 moo3 @Bangkok"), closeSoftKeyboard());
        onView(withId(R.id.input_email)).perform(scrollTo());
        onView(withId(R.id.input_email)).check(matches(isDisplayed()));
        onView(withId(R.id.input_email)).perform(typeText("test@test.com"), closeSoftKeyboard());
        onView(withId(R.id.input_mobile)).perform(scrollTo());
        onView(withId(R.id.input_mobile)).check(matches(isDisplayed()));
        onView(withId(R.id.input_mobile)).perform(typeText("0123456789"), closeSoftKeyboard());
        onView(withId(R.id.input_password)).perform(scrollTo());
        onView(withId(R.id.input_password)).check(matches(isDisplayed()));
        onView(withId(R.id.input_password)).perform(typeText("a@12345678"), closeSoftKeyboard());
        onView(withId(R.id.input_reEnterPassword)).check(matches(isDisplayed()));
        onView(withId(R.id.input_reEnterPassword)).perform(typeText("a@12345678"), closeSoftKeyboard());
        onView(withId(R.id.btn_signup)).perform(scrollTo(), click());
        SystemClock.sleep(3000);
        onView(withId(R.id.lbl_content)).check(matches(isDisplayed()));
        onView(withId(R.id.lbl_content)).check(matches(withText("Hello world!")));
        onView(withId(R.id.btn_logout)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_logout)).perform(click());
        onView(withId(R.id.input_email)).check(matches(isDisplayed()));
        onView(withId(R.id.input_email)).perform(typeText("test@test.com"), closeSoftKeyboard());
        onView(withId(R.id.input_password)).perform(scrollTo());
        onView(withId(R.id.input_password)).check(matches(isDisplayed()));
        onView(withId(R.id.input_password)).perform(typeText("a@12345678"), closeSoftKeyboard());
        onView(withId(R.id.btn_login)).perform(scrollTo(), click());
        SystemClock.sleep(3000);
        onView(withId(R.id.lbl_content)).check(matches(isDisplayed()));
        onView(withId(R.id.lbl_content)).check(matches(withText("Hello world!")));
        onView(withId(R.id.btn_logout)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_logout)).perform(click());
    }

}

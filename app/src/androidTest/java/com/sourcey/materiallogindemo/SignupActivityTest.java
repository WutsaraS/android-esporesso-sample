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
import static androidx.test.espresso.matcher.ViewMatchers.hasErrorText;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
@LargeTest

public class SignupActivityTest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class, true, true);

    @Test
    public void emptyName () {
        onView(withId(R.id.link_signup)).perform(scrollTo(), closeSoftKeyboard(), click());
        onView(withId(R.id.input_name)).perform(scrollTo());
        onView(withId(R.id.input_name)).check(matches(isDisplayed()));
        onView(withId(R.id.input_name)).perform(closeSoftKeyboard());
        onView(withId(R.id.btn_signup)).perform(click());
        onView(withId(R.id.input_name)).check(matches(hasErrorText("at least 3 characters")));
    }

    @Test
    public void invalidName2characters () {
        onView(withId(R.id.link_signup)).perform(scrollTo(), closeSoftKeyboard(), click());
        onView(withId(R.id.input_name)).perform(scrollTo());
        onView(withId(R.id.input_name)).check(matches(isDisplayed()));
        onView(withId(R.id.input_name)).perform(typeText("ab"), closeSoftKeyboard());
        onView(withId(R.id.btn_signup)).perform(scrollTo()).perform(click());
        onView(withId(R.id.input_name)).check(matches(hasErrorText("at least 3 characters")));
    }

    @Test
    public void invalidName1characters () {
        onView(withId(R.id.link_signup)).perform(scrollTo(), closeSoftKeyboard(), click());
        onView(withId(R.id.input_name)).perform(scrollTo());
        onView(withId(R.id.input_name)).check(matches(isDisplayed()));
        onView(withId(R.id.input_name)).perform(typeText("a"), closeSoftKeyboard());
        onView(withId(R.id.btn_signup)).perform(scrollTo()).perform(click());
        onView(withId(R.id.input_name)).check(matches(hasErrorText("at least 3 characters")));
    }

    @Test
    public void validName () {
        onView(withId(R.id.link_signup)).perform(scrollTo(), closeSoftKeyboard(), click());
        onView(withId(R.id.input_name)).perform(scrollTo());
        onView(withId(R.id.input_name)).check(matches(isDisplayed()));
        onView(withId(R.id.input_name)).perform(typeText("abc"), closeSoftKeyboard());
        onView(withId(R.id.btn_signup)).perform(scrollTo()).perform(click());
    }

    @Test
    public void emptyAddress () {
        onView(withId(R.id.link_signup)).perform(scrollTo(), closeSoftKeyboard(), click());
        onView(withId(R.id.input_address)).perform(scrollTo());
        onView(withId(R.id.input_address)).check(matches(isDisplayed()));
        onView(withId(R.id.input_address)).perform(closeSoftKeyboard());
        onView(withId(R.id.btn_signup)).perform(scrollTo()).perform(click());
        onView(withId(R.id.input_address)).check(matches(hasErrorText("Enter Valid Address")));
    }

    @Test
    public void validAddress () {
        onView(withId(R.id.link_signup)).perform(scrollTo(), closeSoftKeyboard(), click());
        onView(withId(R.id.input_address)).perform(scrollTo());
        onView(withId(R.id.input_address)).check(matches(isDisplayed()));
        onView(withId(R.id.input_address)).perform(typeText("123 moo1 @Bangkok"),closeSoftKeyboard());
        onView(withId(R.id.btn_signup)).perform(scrollTo()).perform(click());

    }

    @Test
    public void emptyEmail () {
        onView(withId(R.id.link_signup)).perform(scrollTo(), closeSoftKeyboard(), click());
        onView(withId(R.id.input_email)).perform(scrollTo());
        onView(withId(R.id.input_email)).check(matches(isDisplayed()));
        onView(withId(R.id.input_email)).perform(click(),closeSoftKeyboard());
        onView(withId(R.id.btn_signup)).perform(scrollTo()).perform(click());
        onView(withId(R.id.input_email)).check(matches(hasErrorText("enter a valid email address")));
    }

    @Test
    public void emailFormatInvalid () {
        onView(withId(R.id.link_signup)).perform(scrollTo(), closeSoftKeyboard(), click());
        onView(withId(R.id.input_email)).perform(scrollTo());
        onView(withId(R.id.input_email)).check(matches(isDisplayed()));
        onView(withId(R.id.input_email)).perform(typeText("TestKa"),closeSoftKeyboard());
        onView(withId(R.id.btn_signup)).perform(scrollTo()).perform(click());
        onView(withId(R.id.input_email)).check(matches(hasErrorText("enter a valid email address")));
    }

    @Test
    public void emailFormatNumericInvalid () {
        onView(withId(R.id.link_signup)).perform(scrollTo(), closeSoftKeyboard(), click());
        onView(withId(R.id.input_email)).perform(scrollTo());
        onView(withId(R.id.input_email)).check(matches(isDisplayed()));
        onView(withId(R.id.input_email)).perform(typeText("123@"),closeSoftKeyboard());
        onView(withId(R.id.btn_signup)).perform(scrollTo()).perform(click());
        onView(withId(R.id.input_email)).check(matches(hasErrorText("enter a valid email address")));
    }

    @Test
    public void validFormatEmail () {
        onView(withId(R.id.link_signup)).perform(scrollTo(), closeSoftKeyboard(), click());
        onView(withId(R.id.input_email)).perform(scrollTo());
        onView(withId(R.id.input_email)).check(matches(isDisplayed()));
        onView(withId(R.id.input_email)).perform(typeText("test@test.com"),closeSoftKeyboard());
        onView(withId(R.id.btn_signup)).perform(scrollTo()).perform(click());
    }

    @Test
    public void mobileEmpty () {
        onView(withId(R.id.link_signup)).perform(scrollTo(), closeSoftKeyboard(), click());
        onView(withId(R.id.input_mobile)).perform(scrollTo());
        onView(withId(R.id.input_mobile)).check(matches(isDisplayed()));
        onView(withId(R.id.input_mobile)).perform(click(),closeSoftKeyboard());
        onView(withId(R.id.btn_signup)).perform(scrollTo()).perform(click());
        onView(withId(R.id.input_mobile)).check(matches(hasErrorText("Enter Valid Mobile Number")));
    }

    @Test
    public void invalidMobileText () {
        onView(withId(R.id.link_signup)).perform(scrollTo(), closeSoftKeyboard(), click());
        onView(withId(R.id.input_mobile)).perform(scrollTo());
        onView(withId(R.id.input_mobile)).check(matches(isDisplayed()));
        onView(withId(R.id.input_mobile)).perform(typeText("abcdefg"),closeSoftKeyboard());
        onView(withId(R.id.btn_signup)).perform(scrollTo()).perform(click());
        onView(withId(R.id.input_mobile)).check(matches(hasErrorText("Enter Valid Mobile Number")));
    }

    @Test
    public void invalidMobileNumber () {
        onView(withId(R.id.link_signup)).perform(scrollTo(), closeSoftKeyboard(), click());
        onView(withId(R.id.input_mobile)).perform(scrollTo());
        onView(withId(R.id.input_mobile)).check(matches(isDisplayed()));
        onView(withId(R.id.input_mobile)).perform(typeText("012345678"),closeSoftKeyboard());
        onView(withId(R.id.btn_signup)).perform(scrollTo()).perform(click());
        onView(withId(R.id.input_mobile)).check(matches(hasErrorText("Enter Valid Mobile Number")));
    }

    @Test
    public void validMobile () {
        onView(withId(R.id.link_signup)).perform(scrollTo(), closeSoftKeyboard(), click());
        onView(withId(R.id.input_mobile)).perform(scrollTo());
        onView(withId(R.id.input_mobile)).check(matches(isDisplayed()));
        onView(withId(R.id.input_mobile)).perform(typeText("0123456789"),closeSoftKeyboard());
        onView(withId(R.id.btn_signup)).perform(scrollTo()).perform(click());
    }

    @Test
    public void passwordEmpty () {
        onView(withId(R.id.link_signup)).perform(scrollTo(), closeSoftKeyboard(), click());
        onView(withId(R.id.input_password)).perform(scrollTo());
        onView(withId(R.id.input_password)).check(matches(isDisplayed()));
        onView(withId(R.id.input_password)).perform(click(),closeSoftKeyboard());
        onView(withId(R.id.btn_signup)).perform(scrollTo()).perform(click());
        onView(withId(R.id.input_password)).check(matches(hasErrorText("between 4 and 10 alphanumeric characters")));
    }

    @Test
    public void passwordLessThanMinimum () {
        onView(withId(R.id.link_signup)).perform(scrollTo(), closeSoftKeyboard(), click());
        onView(withId(R.id.input_password)).perform(scrollTo());
        onView(withId(R.id.input_password)).check(matches(isDisplayed()));
        onView(withId(R.id.input_password)).perform(typeText("a@1"),closeSoftKeyboard());
        onView(withId(R.id.btn_signup)).perform(scrollTo()).perform(click());
        onView(withId(R.id.input_password)).check(matches(hasErrorText("between 4 and 10 alphanumeric characters")));
    }

    @Test
    public void passwordGreaterThanMaximum () {
        onView(withId(R.id.link_signup)).perform(scrollTo(), closeSoftKeyboard(), click());
        onView(withId(R.id.input_password)).perform(scrollTo());
        onView(withId(R.id.input_password)).check(matches(isDisplayed()));
        onView(withId(R.id.input_password)).perform(typeText("a@1234567890"),closeSoftKeyboard());
        onView(withId(R.id.btn_signup)).perform(scrollTo()).perform(click());
        onView(withId(R.id.input_password)).check(matches(hasErrorText("between 4 and 10 alphanumeric characters")));
    }

    @Test
    public void validPassword() {
        onView(withId(R.id.link_signup)).perform(scrollTo(), closeSoftKeyboard(), click());
        onView(withId(R.id.input_password)).perform(scrollTo());
        onView(withId(R.id.input_password)).check(matches(isDisplayed()));
        onView(withId(R.id.input_password)).perform(typeText("a@12345678"),closeSoftKeyboard());
        onView(withId(R.id.btn_signup)).perform(scrollTo()).perform(click());
    }

    @Test
    public void emptyConfirmPassword() {
        onView(withId(R.id.link_signup)).perform(scrollTo(), closeSoftKeyboard(), click());
        onView(withId(R.id.input_reEnterPassword)).perform(scrollTo());
        onView(withId(R.id.input_reEnterPassword)).check(matches(isDisplayed()));
        onView(withId(R.id.input_reEnterPassword)).perform(closeSoftKeyboard());
        onView(withId(R.id.btn_signup)).perform(scrollTo()).perform(click());
        onView(withId(R.id.input_reEnterPassword)).check(matches(hasErrorText("Password Do not match")));
    }

    @Test
    public void confirmPasswordLessThanMinimumCharacters () {
        onView(withId(R.id.link_signup)).perform(scrollTo(), closeSoftKeyboard(), click());
        onView(withId(R.id.input_reEnterPassword)).perform(scrollTo());
        onView(withId(R.id.input_reEnterPassword)).check(matches(isDisplayed()));
        onView(withId(R.id.input_reEnterPassword)).perform(typeText("a@1"),closeSoftKeyboard());
        onView(withId(R.id.btn_signup)).perform(scrollTo()).perform(click());
        onView(withId(R.id.input_reEnterPassword)).check(matches(hasErrorText("Password Do not match")));
    }

    @Test
    public void confirmPasswordLessThanMaximumCharacters () {
        onView(withId(R.id.link_signup)).perform(scrollTo(), closeSoftKeyboard(), click());
        onView(withId(R.id.input_reEnterPassword)).perform(scrollTo());
        onView(withId(R.id.input_reEnterPassword)).check(matches(isDisplayed()));
        onView(withId(R.id.input_reEnterPassword)).perform(typeText("a@1234567890"),closeSoftKeyboard());
        onView(withId(R.id.btn_signup)).perform(scrollTo()).perform(click());
        onView(withId(R.id.input_reEnterPassword)).check(matches(hasErrorText("Password Do not match")));
    }

    @Test
    public void passwordDoNotMatch () {
        onView(withId(R.id.link_signup)).perform(scrollTo(), closeSoftKeyboard(), click());
        onView(withId(R.id.input_password)).perform(scrollTo());
        onView(withId(R.id.input_password)).check(matches(isDisplayed()));
        onView(withId(R.id.input_password)).perform(typeText("a@12345678"),closeSoftKeyboard());
        onView(withId(R.id.input_reEnterPassword)).check(matches(isDisplayed()));
        onView(withId(R.id.input_reEnterPassword)).perform(typeText("ABcdg"),closeSoftKeyboard());
        onView(withId(R.id.btn_signup)).perform(scrollTo()).perform(click());
        onView(withId(R.id.input_reEnterPassword)).check(matches(hasErrorText("Password Do not match")));
    }

    @Test
    public void passwordAndRePasswordMatch () {
        onView(withId(R.id.link_signup)).perform(scrollTo(), closeSoftKeyboard(), click());
        onView(withId(R.id.input_password)).perform(scrollTo());
        onView(withId(R.id.input_password)).check(matches(isDisplayed()));
        onView(withId(R.id.input_password)).perform(typeText("a@12345678"),closeSoftKeyboard());
        onView(withId(R.id.input_reEnterPassword)).check(matches(isDisplayed()));
        onView(withId(R.id.input_reEnterPassword)).perform(typeText("a@12345678"),closeSoftKeyboard());
        onView(withId(R.id.btn_signup)).perform(scrollTo()).perform(click());
    }

    @Test
    public void gotoLoginPage () {
        onView(withId(R.id.link_signup)).perform(scrollTo(), closeSoftKeyboard(), click());
        onView(withId(R.id.link_login)).perform(scrollTo(), closeSoftKeyboard(), click());
        onView(withId(R.id.input_email)).check((matches(isDisplayed())));
        onView(withId(R.id.input_password)).check((matches(isDisplayed())));
        onView(withId(R.id.btn_login)).check(matches(isDisplayed()));
    }

    @Test
    public void singupSuccess () {
        onView(withId(R.id.link_signup)).perform(scrollTo(), closeSoftKeyboard(), click());
        onView(withId(R.id.input_name)).perform(scrollTo(),typeText("TestKa"),closeSoftKeyboard());
        onView(withId(R.id.input_address)).perform(scrollTo(),typeText("123 moo3 @Bangkok"),closeSoftKeyboard());
        onView(withId(R.id.input_email)).perform(scrollTo(),typeText("test@test.com"),closeSoftKeyboard());
        onView(withId(R.id.input_mobile)).perform(scrollTo(),typeText("0123456789"),closeSoftKeyboard());
        onView(withId(R.id.input_password)).perform(scrollTo(),typeText("a@12345678"),closeSoftKeyboard());
        onView(withId(R.id.input_reEnterPassword)).perform(scrollTo(),typeText("a@12345678"),closeSoftKeyboard());
        onView(withId(R.id.btn_signup)).perform(scrollTo()).perform(click());
        SystemClock.sleep(3000);
        onView(withId(R.id.lbl_content)).check(matches(withText("Hello world!")));
        onView(withId(R.id.btn_logout)).check(matches(isDisplayed()));
    }
}


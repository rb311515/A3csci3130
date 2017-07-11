package com.acme.a3csci3130;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static com.acme.a3csci3130.R.layout.activity_create_contact_acitivity;
import static com.acme.a3csci3130.R.layout.activity_detail_view;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.acme.a3csci3130", appContext.getPackageName());
    }

    @Test
    public void createContactTest() throws Exception {
        // Context of the app under test.
        onView(withId(R.id.submitButton)).perform(click());
        onView(anyOf(withId(activity_detail_view), withId(activity_create_contact_acitivity))).check(matches(isDisplayed()));
        //anyOf() method found in example from https://stackoverflow.com/questions/29250506/espresso-how-to-check-if-one-of-the-view-is-displayed
    }

    @Test
    public void detailUpdate() throws Exception {
        onView(withId(R.id.submitButton)).perform(click());
        onView(withId(R.id.updateButton)).perform(click());

        onView(withId(R.id.name)).check(matches(isDisplayed()));
    }

    @Test
    public void detailCreate() throws Exception {
        onView(withId(R.id.submitButton)).perform(click());
        onView(withId(R.id.deleteButton)).perform(click());

        //onView(withId(R.id.name)).check(matches(isEmptyOrNullString()));

    }

}

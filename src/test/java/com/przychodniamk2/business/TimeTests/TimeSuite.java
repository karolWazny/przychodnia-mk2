package com.przychodniamk2.business.TimeTests;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@Suite.SuiteClasses({HourSetterConstraintsTest.class, TimeConstraintsTest.class, TimeSetterConstraintsTest.class, TimeTest.class})
@RunWith(Categories.class)
public class TimeSuite {
}

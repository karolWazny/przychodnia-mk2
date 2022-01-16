package com.przychodniamk2.business.WorkingHoursTests;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@Suite.SuiteClasses({WHoursIsDuringTest.class, WorkingHoursConstraintsTest.class})
@RunWith(Categories.class)
@Categories.ExcludeCategory(SlowTests.class)
@Categories.IncludeCategory(FastTests.class)
public class WorkingHoursFastSuite {
}

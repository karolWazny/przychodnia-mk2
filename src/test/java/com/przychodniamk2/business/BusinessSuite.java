package com.przychodniamk2.business;

import com.przychodniamk2.business.EmployeeTests.EmployeeSuite;
import com.przychodniamk2.business.TimeTests.TimeSuite;
import com.przychodniamk2.business.WorkingHoursTests.WHSuite;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@Suite.SuiteClasses({EmployeeSuite.class, TimeSuite.class, WHSuite.class})
@RunWith(Categories.class)
public class BusinessSuite {
}

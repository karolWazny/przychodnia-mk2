package com.przychodniamk2.unit;

import com.przychodniamk2.unit.business.BusinessSuite;
import com.przychodniamk2.unit.database.DatabaseSuite;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@Suite.SuiteClasses({BusinessSuite.class, DatabaseSuite.class})
@RunWith(Categories.class)
public class AllTests {
}

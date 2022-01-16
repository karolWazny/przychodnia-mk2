package com.przychodniamk2;

import com.przychodniamk2.business.BusinessSuite;
import com.przychodniamk2.database.DatabaseSuite;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@Suite.SuiteClasses({BusinessSuite.class, DatabaseSuite.class})
@RunWith(Categories.class)
public class AllTests {
}

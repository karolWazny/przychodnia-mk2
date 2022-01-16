package com.przychodniamk2.database;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@Suite.SuiteClasses({SpringMySQLDatabaseTest.class, SpringMySQLDatabaseTest2.class, SpringMySQLDatabaseTest3.class})
@RunWith(Categories.class)
public class DatabaseSuite {
}

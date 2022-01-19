package com.przychodniamk2.unit.mockuptests;

import com.przychodniamk2.mockups.MockupContextImpl;
import com.przychodniamk2.systemControl.database.Database;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.context.ApplicationContext;


public class MockupContextTest {
    @Test
    public void getDatabaseTest(){
        ApplicationContext context = new MockupContextImpl();
        Database database = context.getBean("database", Database.class);
        Assertions.assertNotNull(database);
    }
}

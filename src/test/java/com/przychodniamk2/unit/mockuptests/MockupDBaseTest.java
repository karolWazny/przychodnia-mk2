package com.przychodniamk2.unit.mockuptests;


import com.przychodniamk2.business.User;
import com.przychodniamk2.mockups.MockupDatabase;
import com.przychodniamk2.systemControl.database.Database;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Map;

public class MockupDBaseTest {
    @Test
    public void logInIncorrect(){
        Database database = new MockupDatabase();
        User user = database.logIn("username", "incorrectPassword");
        Assertions.assertNull(user);
    }

    @Test
    public void logInCorrect(){
        MockupDatabase database = new MockupDatabase();
        Map<String, String> credentials = database.getCredentials();
        credentials.put("username", "correctPassword");
        User user = database.logIn("username", "incorrectPassword");
        Assertions.assertNull(user);


    }
}

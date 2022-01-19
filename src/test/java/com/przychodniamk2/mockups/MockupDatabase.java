package com.przychodniamk2.mockups;

import com.przychodniamk2.business.Employee;
import com.przychodniamk2.business.User;

import java.util.HashMap;
import java.util.Map;

public class MockupDatabase extends MockupDatabaseBase {
    private Map<String, String> credentials = new HashMap<>();
    private Map<String, Employee> users = new HashMap<>();

    @Override
    public void createUser(User user, String password){
        if(credentials.containsKey(user.getUsername()))
            throw new RuntimeException("User with this login already exists!");
        credentials.put(user.getUsername(), password);
        users.put(user.getUsername(), user.getEmployee());
    }

    @Override
    public User logIn(String user, String password){
        if(credentials.containsKey(user) && credentials.get(user).equals(password))
            return new User(users.get(user), user);
        return null;
    }

    public Map<String, String> getCredentials() {
        return credentials;
    }

    public void setCredentials(Map<String, String> credentials) {
        this.credentials = credentials;
    }

    public Map<String, Employee> getUsers() {
        return users;
    }

    public void setUsers(Map<String, Employee> users) {
        this.users = users;
    }
}

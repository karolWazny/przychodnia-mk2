package com.przychodniamk2.mockups;

import com.przychodniamk2.gui.login.LogInServiceImpl;
import com.przychodniamk2.systemControl.database.Database;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.support.BeanDefinitionValidationException;

public class MockupContextImpl extends MockupContext{
    private Database database = new MockupDatabase();
    private LogInServiceImpl logInService = new LogInServiceImpl();

    public MockupContextImpl(){
        logInService.setDatabase(database);
    }

    @Override
    public <T> T getBean(String s, Class<T> aClass) throws BeansException {
        return (T)getBean(s);
    }

    @Override
    public Object getBean(String s) throws BeansException {
        if(s.equalsIgnoreCase("database"))
            return database;
        if(s.equalsIgnoreCase("logInService"))
            return logInService;
        throw new BeanDefinitionValidationException("No bean with provided name!");
    }

    public Database getDatabase() {
        return database;
    }

    public void setDatabase(Database database) {
        this.database = database;
    }
}

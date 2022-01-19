package com.przychodniamk2.mockups;

import com.przychodniamk2.systemControl.database.Database;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.support.BeanDefinitionValidationException;

public class MockupContextImpl extends MockupContext{
    Database database = new MockupDatabase();

    @Override
    public <T> T getBean(String s, Class<T> aClass) throws BeansException {
        return (T)getBean(s);
    }

    @Override
    public Object getBean(String s) throws BeansException {
        if(s.equalsIgnoreCase("database"))
            return database;
        throw new BeanDefinitionValidationException("No bean with provided name!");
    }
}

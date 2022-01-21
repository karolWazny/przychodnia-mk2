package com.przychodniamk2.acceptance;

import com.przychodniamk2.mockups.MockupContextImpl;
import fit.Fixture;
import org.springframework.context.ApplicationContext;

public class SetUp extends Fixture {
    static ApplicationContext context;

    public SetUp(){
        MockupContextImpl contextImpl = new MockupContextImpl();

        context = contextImpl;
    }

    public ApplicationContext getContext(){
        return context;
    }
}

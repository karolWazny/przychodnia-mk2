package com.przychodniamk2.business.WorkingHoursTests;

import com.przychodniamk2.business.Time;
import com.przychodniamk2.business.WorkingHours;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class WorkingHoursConstraintsTest {
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void constructorConstraints(){
        if(valid){
            WorkingHours workingHours = new WorkingHours(start, end);
            Assertions.assertEquals(start, workingHours.getStart());
            Assertions.assertEquals(end, workingHours.getEnd());
        } else {
            exception.expect(IllegalArgumentException.class);
            WorkingHours workingHours = new WorkingHours(start, end);
        }
    }

    @Parameterized.Parameter(value = 0)
    public Time start;

    @Parameterized.Parameter(value = 1)
    public Time end;

    @Parameterized.Parameter(value = 2)
    public boolean valid;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Object[][] data = Data.data;
        return Arrays.asList(data);
    }
}

package com.przychodniamk2.business.WorkingHoursTests;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(Parameterized.class)
public class WHoursIsDuringTest {

    WHoursData wHoursData = new WHoursData();

    @Parameterized.Parameter
    public int indeks;

    @Parameterized.Parameters
    public static Collection<Object> data(){
        Object[] data1 = new Object[]{0, 1, 2, 3, 4};
        return Arrays.asList(data1);
    }

    @Test
    public void isDuringTest(){
        System.out.println("isDuringTest");
        switch(indeks){
                //Przed pracą
            case 0:
                Assertions.assertFalse(wHoursData.referenceHours.isDuring(wHoursData.times[indeks]));
                break;
                //Godzina rozpoczęcia
            case 1:
                Assertions.assertTrue(wHoursData.referenceHours.isDuring(wHoursData.times[indeks]));
                break;
                //W trakcie
            case 2:
                Assertions.assertTrue(wHoursData.referenceHours.isDuring(wHoursData.times[indeks]));
                break;
                //Zakończenie
            case 3:
                Assertions.assertFalse(wHoursData.referenceHours.isDuring(wHoursData.times[indeks]));
                break;
                //Po pracy
            case 4:
                Assertions.assertFalse(wHoursData.referenceHours.isDuring(wHoursData.times[indeks]));
                break;
        }
    }
}

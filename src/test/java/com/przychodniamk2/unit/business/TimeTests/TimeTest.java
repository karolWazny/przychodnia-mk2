package com.przychodniamk2.unit.business.TimeTests;

import org.junit.jupiter.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

//Potrzebna kategoria testu

@RunWith(Parameterized.class)
public class TimeTest {

    TimeData timeData = new TimeData();

    @Parameterized.Parameter
    public int indeks;

    @Parameterized.Parameters
    public static Collection<Object> data(){
        Object[] data1 = new Object[]{0, 1, 2, 3, 4};
        return Arrays.asList(data1);
    }

    @Test
    public void equalsTest(){
        System.out.println("equals");
        for(int i=indeks; i<5; i++){
            if(indeks == i){
                //Assertions.assertEquals(timeData.times[i], timeData.times[indeks]);
                Assertions.assertTrue(timeData.timesEquals[i].equals(timeData.timesEquals[indeks]));
            }
            else{
                //Assertions.assertNotEquals(timeData.times[i], timeData.times[indeks]);
                Assertions.assertFalse(timeData.timesEquals[i].equals(timeData.timesEquals[indeks]));
            }
        }
    }

    @Test
    public void isBeforeTest(){
        System.out.println("isBefore");
        for(int i=0; i<5; i++){
            //Pierwszy czas jest większy
            //Drugi jest równy
            if(i <= 1){
                Assertions.assertFalse(timeData.timesBefore[i].isBefore(timeData.referenceTime));
            }
            else{
                Assertions.assertTrue(timeData.timesBefore[i].isBefore(timeData.referenceTime));
            }
        }
    }

    @Test
    public void isAfterTest(){
        System.out.println("isAfter");
        for(int i=0; i<5; i++){
            //Pierwszy czas jest większy
            //Drugi jest równy
            if(i == 0){
                Assertions.assertTrue(timeData.timesBefore[i].isAfter(timeData.referenceTime));
            }
            else{
                Assertions.assertFalse(timeData.timesBefore[i].isAfter(timeData.referenceTime));
            }
        }
    }
}

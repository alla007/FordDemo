package com.test.util;


import com.test.util.ConvertingUtility;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {ConvertingUtility.class})
public class ConvertingUtilityTest {
    @Autowired
    private ConvertingUtility convertingUtility;

    @Test
    public void testIntToRoman_zeroFail(){
        //given
        String testStr ="0";
        //when
        String testResult = convertingUtility.intToRoman(testStr);
        //then
        assertEquals(testResult,"Invalid Number");
    }
    @Test
    public void testIntToRoman_successful(){
        //given
          String testStr ="3000";
        //when
        String testResult = convertingUtility.intToRoman(testStr);
        //then
        assertEquals(testResult,"MMM");
    }
    @Test
    public void testIntToRoman__Fail(){
        //given
        String testStr ="103x";
        //when
        String testResult = convertingUtility.intToRoman(testStr);
        //then
        assertEquals(testResult,"Invalid Input");
    }


}

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
    @Test
    public void isInteger_Successful(){
        //given
        String testStr ="103";
        //when
        boolean testResult = convertingUtility.isInteger(testStr);
        //then
        assertEquals(testResult,true);
    }
    @Test
    public void isInteger_Fail(){
        //given
        String testStr ="103X";
        //when
        boolean testResult = convertingUtility.isInteger(testStr);
        //then
        assertEquals(testResult,false);
    }

    @Test
    public void testRomanToInt__Case1(){
        //given
        String testStr ="III";
        //when
        int testResult = convertingUtility.romanToInt(testStr);
        //then
        assertEquals(testResult,3);
    }
    @Test
    public void testRomanToInt__Case2(){
        //given
        String testStr ="LVIII";
        //when
        int testResult = convertingUtility.romanToInt(testStr);
        //then
        assertEquals(testResult,58);
    }
    @Test
    public void testRomanToInt__Case3(){
        //given
        String testStr ="MCMXCIV";
        //when
        int testResult = convertingUtility.romanToInt(testStr);
        //then
        assertEquals(testResult,1994);
    }
    @Test
    public void testRomanToInt__invalidRoman(){
        //given
        String testStr ="MCMXCIVu";
        //when
        int testResult = convertingUtility.romanToInt(testStr);
        //then
        assertEquals(testResult,0);
    }
    @Test
    public void testRomanToInt__invalidRangeRoman(){
        //given
        String testStr ="MCMXCIVXXXXXXXXX";
        //when
        int testResult = convertingUtility.romanToInt(testStr);
        //then
        assertEquals(testResult,0);
    }


}

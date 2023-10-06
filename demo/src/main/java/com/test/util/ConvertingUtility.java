package com.test.util;

import org.springframework.http.server.DelegatingServerHttpResponse;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ConvertingUtility {
    String[] OneUnit = {"","I","II","III","IV","V","VI","VII","VIII","IX","X"};
    String[] tensArray ={"","X","XX","XXX","XL","L","LI","LX","LXX","LXXX","XC"};
    String[] hundredsArray={"","C","CC","CCC","CD","DC","DCC","DCCC","CM"};
    String[] thousandsArray={"","M","MM","MMM","MMM"};


//Convert Integer to Roman
    public String intToRoman(String s){
        if(isInteger(s))
        {
            int i = Integer.valueOf(s);
            if(i==0 || i >3000) {
                return "Invalid Number";
            }

            return thousandsArray[i / 1000] +
                    hundredsArray[(i % 1000) / 100] +
                    tensArray[(i % 100) / 10] +
                    OneUnit[i % 10];
        }
        else {

            return "Invalid Input";
        }
    }
    //Validates if it is an integer
    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch(NumberFormatException e) {
            return false;
        } catch(NullPointerException e) {
            return false;
        }

        return true;
    }
    //Assuming limit is 15 characters String (1,3999)
    public int romanToInt(String s){
        Map<Character,Integer> romanMap = new HashMap<>();
        romanMap.put('I',1);
        romanMap.put('V',5);
        romanMap.put('X',10);
        romanMap.put('L',50);
        romanMap.put('C',100);
        romanMap.put('D',500);
        romanMap.put('M',1000);
        int convertedInt =0;
        //checking limit
        if(s.length()>15)
            return 0;
        for(int i=0;i<s.length();i++){
            //Invalid roman character
            if(!romanMap.containsKey(s.charAt(i)))
            {
                return 0;
            }

            if(i > 0 && romanMap.get(s.charAt(i)) > romanMap.get(s.charAt(i-1))){
                convertedInt += romanMap.get(s.charAt(i)) - 2 * romanMap.get(s.charAt(i-1));
            } else{
                convertedInt += romanMap.get(s.charAt(i));
            }
        }
        return convertedInt;


    }


}

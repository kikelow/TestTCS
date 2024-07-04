package org.testtcs.util;

public class NumberUtil {

     public static int getNumberFromString(String text){
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : text.toCharArray()){
            if (Character.isDigit(c)){
                stringBuilder.append(c);
            }
        }
        return Integer.parseInt(stringBuilder.toString());
    }
}

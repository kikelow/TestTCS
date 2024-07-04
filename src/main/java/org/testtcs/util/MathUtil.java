package org.testtcs.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MathUtil {

    private static List<Integer> numbers;
    private static List<Character> symbols;

    public static String doMathOperations(String text) {

        String newCadena = doMultiply(text);

        numbers = new ArrayList<>();
        symbols = new ArrayList<>();

        Pattern pattern = Pattern.compile("\\d+|[-+]");
        Matcher matcher = pattern.matcher(newCadena);

        int i = 0;
        while (matcher.find()) {
            String match = matcher.group();
            if (Character.isDigit(match.charAt(0))) {
                numbers.add(Integer.parseInt(match));
            } else {
                symbols.add(match.charAt(0));
            }
            i++;
        }

        int total = 0;
        int baseNumber = numbers.get(0);
        for (int j = 0; j < symbols.size(); j++) {
            total = defOps(baseNumber, numbers.get(j + 1), symbols.get(j));
            baseNumber = total;
        }
        return String.valueOf(total);
    }

    private static int defOps(int baseNumber, int nextNumber, char opetator) {
        int retorno = baseNumber;

        switch (opetator) {
            case '+':
                retorno += nextNumber;
                break;
            case '-':
                retorno -= nextNumber;
                break;
            case '*':
                retorno *= nextNumber;
                break;
            default:
                retorno += retorno;
                break;
        }
        return retorno;
    }

    private static String doMultiply(String text) {
        List<String> parts = new ArrayList<>();
        StringBuilder number = new StringBuilder();
        int result = 1;
        boolean multiply = false;

        for (char c : text.toCharArray()) {
            if (Character.isDigit(c)) {
                number.append(c);
            } else {
                if (multiply) {
                    result *= Integer.parseInt(number.toString());
                } else {
                    if (number.length() > 0) {
                        result = Integer.parseInt(number.toString());
                    }
                }
                number.setLength(0);

                if (c == '*') {
                    multiply = true;
                } else {
                    if (multiply) {
                        parts.add(String.valueOf(result));
                        multiply = false;
                    } else if (result != 1) {
                        parts.add(String.valueOf(result));
                        result = 1;
                    }
                    parts.add(String.valueOf(c));
                }
            }
        }

        if (number.length() > 0) {
            if (multiply) {
                result *= Integer.parseInt(number.toString());
                parts.add(String.valueOf(result));
            } else {
                parts.add(number.toString());
            }
        }

        return String.join("", parts);

    }

    public static void main(String[] args) {
        System.out.println(doMathOperations(""));
    }


}

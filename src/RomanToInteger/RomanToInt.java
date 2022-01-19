package RomanToInteger;

import java.util.*;

public class RomanToInt {
    public static int romanToInt(String s){
        int romanNum = 0;
        int prev = Integer.MAX_VALUE;

        for(int i = 0; i < s.length(); i++){
            if(prev >= getNumValue(s.charAt(i))) {
                romanNum += getNumValue(s.charAt(i));
            }
            else{
                romanNum += getNumValue(s.charAt(i)) - 2 * prev;
            }
            prev = getNumValue(s.charAt(i));
        }
        return romanNum;
    }
    public static int getNumValue(char c){
        switch(c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return -1;
        }
    }
    public static void main(String[] args) {
        String romanChars = "MMDCIX";
        int romanNums = 0;

        System.out.println(romanNums = RomanToInt.romanToInt(romanChars));


    }
}

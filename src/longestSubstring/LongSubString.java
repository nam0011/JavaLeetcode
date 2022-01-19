package longestSubstring;

import java.util.*;

public class LongSubString {

    public static int lengthOfLongestSubstring(String s) {
        int start = 0; //start index pointer
        int end = 0; //end index pointer
        int max = 0; //holds max amount of elements not equal

        Set<Character> set = new HashSet<>(); //create a new hash set
        while (end < s.length()) { //while the end pointer is not out of bounds of the char array
            if (!set.contains(s.charAt(end))) { //if the set does not contain the char at the end pointer
                set.add(s.charAt(end)); //add that char to the set
                end++; //increment the end pointer to the next index
                max = Math.max(set.size(), max); //check whether the size of the current set or the last max value are larger set max to the largest value
            } else { //if the set does contain the end index value
                set.remove(s.charAt(start)); //remove the start index value from the set
                start++; //increment the start pointer
            }
        }
        return max; //return the max length value
    }
    public static void main(String[] args) {
        String test = "htguidifcshatggu";

        int largestString = lengthOfLongestSubstring(test);
        System.out.println(largestString);
    }
}

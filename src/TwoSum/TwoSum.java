package TwoSum;

import java.util.*;

public class TwoSum {
    //method to check if two integers within an array add together to produce a target integer
    public static int[] twoSumsInt(int[] nums, int target) {
        Map<Integer, Integer> indexMap = new HashMap(); //create a new hash map with keys and values as integer types
        for (int i = 0; i < nums.length; i++) { //for all indices of given array
            Integer reqNum = (Integer) (target - nums[i]); //calculate the number required to achieve target value

            if (indexMap.containsKey(reqNum)) { //search the map to find the required pair number
                int toReturn[] = {indexMap.get(reqNum), i};
                return toReturn;
            }
            indexMap.put(nums[i], i);
        }
        return null;
    }



    //driver code
    public static void main(String args[]){
        int nums[] = {2,7,11,15};

        int ans[] = twoSumsInt(nums, 9);

        for (int element : ans) {
            System.out.print(element + " ");
        }
        System.out.println();

    } //end of main

}//end of class



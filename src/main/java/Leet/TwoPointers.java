package Leet;

import lombok.extern.slf4j.Slf4j;

import javax.print.attribute.standard.MediaSize;
import java.util.*;

public class TwoPointers {
    public static void main(String[] args) {
//        TwoPointers solution = new TwoPointers();
        twoSum();
    }

    //This not works bcoz it moves forward doesn't maintain the previous data
    static void twoSum1(){
    int[] nums = {11,2,15,7};
//    int[] nums = {6};
        int target = 9;
        int[] returningArr = new int[2];
        if(nums.length == 1 && nums[0] == target){
            System.out.println("Already Match");
            returningArr[0] = 0;
//            return;
        }
        for(int i =0; i<nums.length; i++){
           int slow = nums[i];
           int fast = i < nums.length -1  ? nums[i+1] :  nums[i] ;
           if(slow + fast == target){
               System.out.println("The Match!!");
               System.out.println("--Slow: "+slow+"--Fast: "+fast);
               returningArr[0] = i;
               returningArr[1] = i < nums.length -1  ? i+1 :  i ;
           }
        }
        System.out.println(Arrays.toString(returningArr));
    }

    //Problem 1: https://leetcode.com/problems/two-sum/description/
    static void twoSum() {
        List<Integer> nums = Arrays.asList(11,2,15,7);
        int target = 9;
        List<Integer> result = new ArrayList<>();
        // HashMap to store elements and their indices: {element: index}
        Map<Integer, Integer> numIndices = new HashMap<>();

        // Iterate through the list of numbers
        for (int i = 0; i < nums.size(); i++) {
            int currentNum = nums.get(i);
            int complement = target - currentNum;

            // Check if the complement exists in the map
            if (numIndices.containsKey(complement)) {
                // If it does, return the indices of the complement and the current element
                // The complement's index is the value associated with the complement key
                result = Arrays.asList(numIndices.get(complement), i);
            }

            // If the complement doesn't exist, add the current element and its index to the map
            numIndices.put(currentNum, i);
        }

        // If no solution is found, return an empty list
//        return new ArrayList<>();

        System.out.println("Output Indices: " + result);
    }
}//EC

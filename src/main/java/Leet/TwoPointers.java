package Leet;
import basix.linklists.SingleLinkedListLeet;

import java.util.*;

public class TwoPointers {
    public static void main(String[] args) {
//        TwoPointers solution = new TwoPointers();
//        twoSum();
//        twoSum1();
    }

 //Problem 2: https://leetcode.com/problems/add-two-numbers/description/
    static void addTwoNumberFromList(){
        SingleLinkedListLeet list1 = new SingleLinkedListLeet(2);
        list1.next = new SingleLinkedListLeet(4, new SingleLinkedListLeet(3));
        SingleLinkedListLeet list2 = new SingleLinkedListLeet(5);
        list2.next = new SingleLinkedListLeet(6, new SingleLinkedListLeet(4));

        SingleLinkedListLeet resultNode  = new SingleLinkedListLeet(0);

        int carryInt = 0;
        while(list1 != null || list2 != null || carryInt != 0){
            if(list1 != null && list2 != null){
                int addition = list1.val + list2.val;
                if(addition >=9) carryInt = addition%10;
            }
            list1 = list1.next;
            list2 = list2.next;
        }
    }

    static void twoSum1(){
//    int[] nums = {2,7,11,15};
    int[] nums = {6};
        int target = 6;
        int[] returningArr = new int[2];
        HashMap<Integer, Integer> saveMe = new HashMap();
        for(int i=0; i< nums.length; i++){
            int remaining =  target - nums[i];
            if(saveMe.containsKey(remaining)){
                returningArr[0] = i;
                returningArr[1] = saveMe.get(remaining);
            }else{
                saveMe.put(nums[i],i);
            }
        }
        //This not works bcoz it moves forward doesn't maintain the previous data
//        if(nums.length == 1 && nums[0] == target){
//            System.out.println("Already Match");
//            returningArr[0] = 0;
////            return;
//        }
//        for(int i =0; i<nums.length; i++){
//           int slow = nums[i];
//           int fast = i < nums.length -1  ? nums[i+1] :  nums[i] ;
//           if(slow + fast == target){
//               System.out.println("The Match!!");
//               System.out.println("--Slow: "+slow+"--Fast: "+fast);
//               returningArr[0] = i;
//               returningArr[1] = i < nums.length -1  ? i+1 :  i ;
//           }
//        }
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

package Leet;

import basix.linklists.SingleLinkedListLeet;

import java.security.Signature;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

//https://instabyte.io/p/interview-master-100
public class InterviewMasterSahil {
    public static void main(String[] args) {
//        twoSum1();
//        validDifferentTypeParenthese();
//        System.out.println( validDifferentTypeParentheseGemini("(){}}{"));
//        merge2SortedListsFromGemini();
    }

    //Problem 21: https://leetcode.com/problems/merge-two-sorted-lists/
    static void merge2SortedListsFromGemini(){
        // Create SinglyLinked -- list1 = [1,2,4], list2 = [1,3,4]
        SingleLinkedListLeet list1 = new SingleLinkedListLeet(1);
        list1.next = new SingleLinkedListLeet(2, new SingleLinkedListLeet(4));
        SingleLinkedListLeet list2 = new SingleLinkedListLeet(1);
        list2.next = new SingleLinkedListLeet(3, new SingleLinkedListLeet(4));

        // used for final result
        SingleLinkedListLeet resultNode  = new SingleLinkedListLeet(0);
        SingleLinkedListLeet tail = resultNode;

        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                tail.next= list1;
                list1 = list1.next;
            }else{
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }
        if(list1 != null){
            tail.next = list1;
        }
        if(list2 != null){
            tail.next = list2;
        }

        // Show Results
        SingleLinkedListLeet temp = resultNode;
        while (temp != null){
            System.out.println(temp.val);
            temp = temp.next;
        }

    }

    //Problem 20: https://leetcode.com/problems/valid-parentheses/
    static void validDifferentTypeParenthese(){
//        String ParentheseString = "([])";
        String ParentheseString = "(){}}{";
//        String ParentheseString = "()[]{}";
        Stack<Character> stackwa = new Stack<>();
        HashMap<Character, Character> CharPair = new HashMap<>();
        CharPair.put('(',')');
        CharPair.put('[',']');
        CharPair.put('{','}');

        char[] chararry = ParentheseString.toCharArray();

        for(char ch: chararry){
            if(CharPair.containsKey(ch)){
                stackwa.push(CharPair.get(ch));
            } else if (stackwa.pop() != ch) {
                System.out.println("Falsey");
            }
        }
        System.out.println("tueu");
        System.out.println( chararry.length);
    }
    public static boolean validDifferentTypeParentheseGemini(String s) {
        // Use a Deque (ArrayDeque) as a Stack. Deque operations are generally faster
        // and preferred over the legacy java.util.Stack class.
        Stack<Character> stack = new Stack<>();

        // Iterate through each character in the input string
        for (char c : s.toCharArray()) {

            // 1. Handle Opening Brackets: Push the expected closing bracket onto the stack
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            }

            // 2. Handle Closing Brackets
            else {
                // Check 2a: If the stack is empty, we found a closing bracket
                // without a corresponding opener. Invalid.
                if (stack.isEmpty()) {
                    return false;
                }

                // Check 2b: Pop the expected closing bracket from the top of the stack
                // and compare it to the current character 'c'.
                // If they don't match, the order or type is incorrect. Invalid.
                if (stack.pop() != c) {
                    return false;
                }
            }
        }

        // 3. Final Check: After iterating through the whole string, the stack must be empty.
        // If the stack is not empty, it means there are leftover opening brackets
        // (e.g., "[{" ) that were never closed.
        return stack.isEmpty();
    }

    //Problem 1: https://leetcode.com/problems/two-sum/description/
    static void twoSum1(){
    int[] nums = {2,7,11,15};
//        int[] nums = {6};
        int target = 9;
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
        System.out.println(Arrays.toString(returningArr));
    }

}//EC

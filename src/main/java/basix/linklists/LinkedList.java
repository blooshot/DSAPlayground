package basix.linklists;

import basix.stacks.Stack;

import java.util.HashSet;
import java.util.Set;

public class LinkedList {

    private Node head;
    private Node tail;
    int length;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length++;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void printAll() {
        if (head == null) {
            System.out.println("Head: null");
            System.out.println("Tail: null");
        } else {
            System.out.println("Head: " + head.value);
            System.out.println("Tail: " + tail.value);
        }
        System.out.println("\nLinked List:");
        if (head == null) {
            System.out.println("empty");
        } else {
            printList();
        }
    }

    public void makeEmpty() {
        head = null;
        tail = null;
        length = 0;
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }
    public Node get(int index){
        if(index < 0 || index > length) return null;
        Node temp = head;
        for(int i =0; i < index; i++){
            temp = temp.next;
        }
        return temp;
    }

    public Node findMiddleNode(){
        if(length == 0) return null;
        if(length == 1) return head;
        int middle  = Math.round(length/ 2);
//        if(length % 2 != 0){
//                return  get(middle);
//        }
        return  get(middle);
    }

    public void removeDuplicates() {
        // Your implementation goes here
        Set uniqueValue = new HashSet();
        Node current = head;
        Node pre = null;
        // for(int i =0; i<length; i++){
        //      if(!uniqueValue.add(temp.value)){
        //         pre = temp.next;
        //         temp.next = null;
        //         temp = pre;
        //     }
        //     pre = temp;
        //     temp = temp.next;
        // }

        while(current != null){
            if(uniqueValue.contains(current)){
                pre.next = current.next;
                length--;
            }
            uniqueValue.add(current);
            pre = current;
            current = current.next;
        }

    }

    public static String reverseString(String in){
        Stack myStack = new Stack();
        String reversedString = new String();
//        CharSequence vs = in;.
        for(Character c : in.toCharArray()){
            myStack.push(c);
        }

        while(!myStack.isEmpty()){
            reversedString += myStack.pop();
        }
        return  reversedString;
    }

//   static boolean isBalancedParentheses(String input){
//        Stack myStack = new Stack();
//        for(Character ca : input.toCharArray()){
//            if(myStack.isEmpty()){
//                myStack.push(ca);
//            }else{
//                if(myStack.peek() == '(' && ca == ')'){
//                    myStack.pop();
//                }else{
//                    myStack.push(ca);
//                }
//            }
//        }
//        return myStack.isEmpty();
//    }

    public static Node findMiddle(Node head)
    {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
 /*   public static void main(String[] args) {
//        System.out.println( reverseString("love"));
//        testAndPrint("()", true);
//        testAndPrint("()()", true);
//        testAndPrint("(())", true);
//        testAndPrint("()()()", true);
//        testAndPrint("(()())", true);
//        testAndPrint(")()(", false);
//        testAndPrint(")(", false);
//        testAndPrint("(()", false);
//        testAndPrint("))", false);
//        testAndPrint("(", false);
//        testAndPrint(")", false);
//        LinkedList myLinkedList = new LinkedList(1);
//
//        myLinkedList.append(2);
//        myLinkedList.append(3);
//        myLinkedList.append(1);
//        myLinkedList.append(4);
//        myLinkedList.append(2);
//        myLinkedList.append(5);



//
//        myLinkedList.removeDuplicates();
//
//        myLinkedList.printList();
    }*/

/*    public static void testAndPrint(String testStr, boolean expected) {
        // Run the test and store the result
//        boolean result = isBalancedParentheses(testStr);

        // Print the test string, expected result, and actual result
        System.out.println("Test String: " + testStr);
        System.out.println("EXPECTED: " + expected);
        System.out.println("RESULT: " + result);

        // Check if the test passed or failed
        if (result == expected) {
            System.out.println("STATUS: PASS");
        } else {
            System.out.println("STATUS: FAIL");
        }

        // Print a separator for better readability
        System.out.println("--------------");
    }*/

}//EC




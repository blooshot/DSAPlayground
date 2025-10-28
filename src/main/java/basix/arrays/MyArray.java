package basix.arrays;

import java.util.Arrays;

public class MyArray {

    int [] myarr;
    int filled = 0;

    public MyArray(int arrLen) {
        myarr = new int[arrLen];
    }


    public void insert(int addme){
        if(filled == 0){
           /* myarr[filled] = addme; // myWay
            filled++;*/
            myarr[filled++] = addme; // mosh way

        }else {
            if(filled == myarr.length){
                int [] newArr = new int[filled * 2];

                for (int i = 0; i < filled; i++) {
                    newArr[i] = myarr[i];
                }

                myarr = newArr;
            }
            myarr[filled++] = addme;
          /*  myarr[filled] = addme;
            filled++;*/
        }
    }

    public void removeAt(int position){
       if( myarr.length  >= position){
           for (int i = position; i < filled; i++) {
            myarr[i] = myarr[i + 1];
           }
           filled --;
       }
    }

    public int indexOf(int element){
        int returnedValue = -1;
        for (int i = 0; i < myarr.length ; i++) {

            if(myarr[i] == element){
                returnedValue = i;
            }/*else {
                returnedValue = -1;
            }*/
//            System.out.println( myarr[i]);

        }

        return returnedValue;
    }

    void removeElement(){
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4,1};
        int val= 1;
        int len = 0;
        for(int i =0; i<nums.length; i++){
            if(nums[i] == val){
                if(i == nums.length-1){
                    System.out.println( nums[i]);
                    break;
                }
                nums[i]=nums[i+1];
                len++;
            }
        }
        int[] result = new int[len];
        System.arraycopy(nums, 0, result, 0, len);
//        int i = 0;
//        for (int j = 0; j < nums.length; j++) {
//            if (nums[j] != val) {
//                nums[i] = nums[j];
//                i++;
//            }
//        }

        System.out.println(Arrays.toString(result));
    }

    public void print(){
        System.out.println(Arrays.toString(myarr));
    }

    public static void findMaxMin(){
        int[] myList1 = {5, 3, 8, 1, 6, 9};
       int min = 0;
       int max = 0;
        for (int i = 0; i < myList1.length; i++) {
            if (myList1[i] > max) {
                max = myList1[i];
            }
            if (myList1[i] < min) {
                min = myList1[i];
            }
        }
        System.out.println(max);
        System.out.println(min);
    }

    public static void findLongestString(){
        String[] stringList = {"", "a", "aa", "aaa"};
        String indexOfLargest = stringList[0];
        for(int i=0; i<stringList.length; i++){

            if(i == stringList.length-1){
                if(stringList[i].length() > stringList[i-1].length()){
                    indexOfLargest = stringList[i];
                }
//                System.out.println(stringList[i]);
                break;
            }

            if(stringList[i].length() > stringList[i+1].length()){
                indexOfLargest = stringList[i];
            }

        }
        System.out.println(indexOfLargest);
    }

    public static void main(String[] args) {
//        MyArray.findMaxMin();
        findLongestString();
        String hoi = "hoimos";
        char [] charec = hoi.toCharArray();
        for (int i = 0; i < charec.length; i++) {
            int ascii = charec[i];
            System.out.println(ascii);
        }
    }
}//EC

package practiceSets;

import java.util.Arrays;
import java.util.List;

public class Interview6 {
    public static void main(String[] args) {
//    Interview6 interview6 = new Interview6();
moveAllZeroAtEnd();

    }

    static void checkPalindrom(){

    }

    static int sumOfNUsingRecursion(int n){
        if(0==n) return 0;
        System.out.println(n);
       return n+ sumOfNUsingRecursion(n-1);
    }

    static void moveAllZeroAtEnd(){
        //Optimal  Approach In-place switch using slow-fast pointer
        int[] arr = {1, 0, 2, 3, 2, 0, 0, 4, 5, 1};
        int j = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                arr[j] = arr[i];
                j++;
            }
        }

        for (int i = j; i < arr.length; i++) {
            arr[i] = 0;
        }
        System.out.println(Arrays.toString(arr));


        //BruteForce Approach utilize memory space for divide and merge
        /* List<Integer> aList = Arrays.asList(1, 0, 2, 3, 2, 0, 0, 4, 5, 1);
        List<Integer> numbers = new ArrayList<>();
        List<Integer> zeros = new ArrayList<>();

        for(int i: aList){
            if(i == 0){
                zeros.add(i);
            }else {
                numbers.add(i);
            }
        }
        numbers.addAll(zeros);
        System.out.println(numbers);
        System.out.println(aList);*/
//        System.out.println(aList1);
    }

    void FindMissingNumber(){
        List<Integer> list = List.of(1,3);
        int N = 3;
        for(int i =1;i<N ;i++){
            if(!list.contains(i)){
                System.out.println("MissingNumber: "+i);
            }
        }
    }
}

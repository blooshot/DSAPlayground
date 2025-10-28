package practiceSets;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Interview3 {
    public static void main(String[] args) {

        System.out.println(stringConcatenation("99", "99"));
        List<Integer> numbers = Arrays.asList(1, 3, 241, 2324, 242, 14313432, 45, 4363, 789, 65, 44, 64, 3, 4, 1, 12, 56, 65, 78, 10,98,65,233,242,65,21);

        List<Integer> evenOnes = numbers.stream().filter(x->x%2  == 0).collect(toList());
//        int x = 0;
//        for(int a : oddOnes){
//            x +=a;
//        }
//
//        System.out.println(x);
//        System.out.println(
//                numbers.stream()
//                .collect(groupingBy(x->x, counting()))
//                .values().stream()
//                        .sorted(Comparator.reverseOrder())
//                        .collect(toMap(Map.Entry::getKey,Map.Entry::getValue);
//        ));
//{65=4, 1=2, 3=2, 242=2, 64=1,   98=1, 14313432=1, 4=1, 233=1, 10=1, 4363=1, 12=1, 44=1, 45=1, 78=1, 241=1,  2324=1, 21=1, 789=1, 56=1}

//        Scanner sc = new Scanner(System.in);
//        String s = sc.next();
//        char c = s.toCharArray()[0];

        String s = "I love programming they are playing cricket and good to see you";
        StringBuilder sb = new StringBuilder();
//        for(char c : s.toCharArray()){

//           if(c)  sb.append(String.valueOf(c).toUpperCase());
//           else   sb.append(String.valueOf(c));
//            if(s.indexOf(c) == 0) {
//                sb.append(String.valueOf(c).toUpperCase());
//            }else if(s.charAt(s.indexOf(c) - 1) ==32) {
//                sb.append(String.valueOf(c).toUpperCase());
//            }else sb.append(c);
//        }
//        System.out.println(String.);
//        System.out.println(sb.toString());

//            System.out.println(pow);

//        for(int i = 1; i <= 3; i++) {
//
//            for(int j = 1; j <= 3; j++) {
//                if(i == 2 && j == 2) {
//                    // using continue statement with label
//                        break;
//                }
//                System.out.println(i + " "+ j);
//            }
//        }


}

    static float calculateHDP(int sal, int percentage){
        return (sal * percentage) / 100;
    }

    public static String stringConcatenation(String num1, String num2) {
        // Write your code here.
        int lenNum1 = num1.length()-1;
        int lenNum2 = num2.length()-1;
        StringBuilder result = new StringBuilder();
        int carry=0;

        while(lenNum2 >=0 || lenNum1 >=0 || carry > 0){
            int di1 = (lenNum1>=0) ? num1.charAt(lenNum1) - '0' : 0;
            int di2 = (lenNum2>=0) ? num2.charAt(lenNum2) - '0' : 0;


            int sum = di1 + di2 + carry;
            carry = sum / 10;
            result.append(sum % 10);

              lenNum2--;
              lenNum1--;
        }
        return result.reverse().toString();
    }

}//EC

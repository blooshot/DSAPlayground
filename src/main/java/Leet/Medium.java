package Leet;

import java.util.Arrays;

public class Medium {

    public static void main(String[] args) {
//        System.out.println(reverse(450));
//        System.out.println(LargestElmRecurse(new int[]{8, 10, 5, 7, 9}));

//        System.out.println(  (int)(Math.log10(Math.abs(-321100)) + 1));

//        reverseSentance("a good   example");
        String s = "egg", t = "goo";
        System.out.println(isIsomorphic(s,t));
    }


    // 7. Reverse Integer`
    public static int reverse(int x) {
        long rev = 0;
        while (x != 0) {
            rev = rev * 10 + x % 10;
            if (rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE) {
                return 0;
            }
            x /= 10;
        }
        return (int) rev;
    }

//    Find the Largest element in an array
    public static int LargestElmRecurse(int[] x){
       /* Input: arr[] = {8,10,5,7,9};
        Output: 10*/
     int i = 0;

     int max = x[i];

     if(i >= x.length-1) return max;

     int next = x[i++];
     if(max < next){
            max = next;
     }


        return 1;
    }

    // 151. Reverse Words in a String
    public  static void reverseSentance(String s){
//        String newString = new StringBuffer(a).reverse().toString();
        StringBuilder newString = new StringBuilder();
        String[] parts = s.trim().split(" ");
        for (int i = parts.length - 1; i >= 0; i--) {

            if(parts[i].isEmpty()) continue;
                newString.append(parts[i]);

            if(i!=0) newString.append(" ");

        }
        System.out.println(newString.toString());
    }

    // 205. Isomorphic Strings
    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        // We’ll assume ASCII; if you need full Unicode, use HashMap<Character, Character> instead.
        char[] mapSToT = new char[256];
        char[] mapTToS = new char[256];
        Arrays.fill(mapSToT, (char) 0);
        Arrays.fill(mapTToS, (char) 0);

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if (mapSToT[c1] == 0 && mapTToS[c2] == 0) {
                // Neither character has been mapped yet → establish new bi‐directional mapping
                mapSToT[c1] = c2;
                mapTToS[c2] = c1;
            } else {
                // One or both have been seen before → check for consistency
                if (mapSToT[c1] != c2 || mapTToS[c2] != c1) {
                    return false;
                }
            }
        }
        return true;
    }

}//EC

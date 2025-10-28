package practiceSets;

import java.util.*;

public class StringQuesFast {

    // 1. Reverse a String
    public static String reverseString(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    // 2. Check if a String is a Palindrome
    public static boolean isPalindrome(String s) {
        String clean = s.replaceAll("\\s+", "").toLowerCase();
        return clean.equals(new StringBuilder(clean).reverse().toString());
    }

    // 3. Remove Duplicates from a String
    public static String removeDuplicates(String s) {
        Set<Character> seen = new LinkedHashSet<>();
        for (char c : s.toCharArray()) {
            seen.add(c);
        }
        StringBuilder sb = new StringBuilder();
        for (char c : seen) sb.append(c);
        return sb.toString();
    }

    // 4. Find the First Non-Repeating Character
    public static Character firstNonRepeatingChar(String s) {
        Map<Character, Integer> freq = new LinkedHashMap<>();
        for (char c : s.toCharArray()) freq.put(c, freq.getOrDefault(c, 0) + 1);
        for (char c : s.toCharArray()) if (freq.get(c) == 1) return c;
        return null; // no unique char
    }

    // 5. Count the Occurrences of Each Character
    public static Map<Character, Integer> charOccurrences(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray()) freq.put(c, freq.getOrDefault(c, 0) + 1);
        return freq;
    }

    // 6. Reverse Words in a Sentence
    public static String reverseWords(String sentence) {
        String[] words = sentence.trim().split("\\s+");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }

    // 7. Check if Two Strings are Anagrams
    public static boolean areAnagrams(String s1, String s2) {
        char[] a = s1.replaceAll("\\s+", "").toLowerCase().toCharArray();
        char[] b = s2.replaceAll("\\s+", "").toLowerCase().toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);
        return Arrays.equals(a, b);
    }

    // 8. Find the Longest Substring Without Repeating Characters
    public static String longestUniqueSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int start = 0, maxLen = 0, startIdx = 0;
        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            if (map.containsKey(c)) start = Math.max(map.get(c) + 1, start);
            map.put(c, end);
            if (end - start + 1 > maxLen) {
                maxLen = end - start + 1;
                startIdx = start;
            }
        }
        return s.substring(startIdx, startIdx + maxLen);
    }

    // 9. Convert a String to an Integer (atoi Implementation)
    public static int stringToInt(String s) {
        s = s.trim();
        if (s.isEmpty()) return 0;
        int sign = 1, i = 0;
        long result = 0;
        if (s.charAt(0) == '+' || s.charAt(0) == '-') {
            sign = s.charAt(0) == '-' ? -1 : 1;
            i++;
        }
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            result = result * 10 + (s.charAt(i) - '0');
            if (result * sign > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (result * sign < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            i++;
        }
        return (int) (result * sign);
    }

    // 10. Compress a String (Run-Length Encoding)
    public static String compressString(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (int i = 1; i <= s.length(); i++) {
            if (i < s.length() && s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                sb.append(s.charAt(i - 1));
                if (count > 1) sb.append(count);
                count = 1;
            }
        }
        return sb.toString();
    }

    // 11. Find the Most Frequent Character
    public static Character mostFrequentChar(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray()) freq.put(c, freq.getOrDefault(c, 0) + 1);
        char maxChar = '\0';
        int maxCount = 0;
        for (Map.Entry<Character, Integer> e : freq.entrySet()) {
            if (e.getValue() > maxCount) {
                maxCount = e.getValue();
                maxChar = e.getKey();
            }
        }
        return maxChar;
    }

    // 12. Find All Substrings of a Given String
    public static List<String> allSubstrings(String s) {
        List<String> substrings = new ArrayList<>();
        for (int i = 0; i < s.length(); i++)
            for (int j = i + 1; j <= s.length(); j++)
                substrings.add(s.substring(i, j));
        return substrings;
    }

    // 13. Check if a String is a Rotation of Another String
    public static boolean isRotation(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        String concat = s1 + s1;
        return concat.contains(s2);
    }

    // 14. Remove All White Spaces from a String
    public static String removeWhiteSpaces(String s) {
        return s.replaceAll("\\s+", "");
    }

    // 15. Check if a String is a Valid Shuffle of Two Strings
    public static boolean isValidShuffle(String s, String s1, String s2) {
        if (s.length() != s1.length() + s2.length()) return false;
        int i = 0, j = 0, k = 0;
        while (k < s.length()) {
            if (i < s1.length() && s.charAt(k) == s1.charAt(i)) i++;
            else if (j < s2.length() && s.charAt(k) == s2.charAt(j)) j++;
            else return false;
            k++;
        }
        return i == s1.length() && j == s2.length();
    }

    // 16. Convert a String to Title Case
    public static String toTitleCase(String s) {
        String[] words = s.toLowerCase().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            if (word.length() > 0)
                sb.append(Character.toUpperCase(word.charAt(0))).append(word.substring(1)).append(" ");
        }
        return sb.toString().trim();
    }

    // 17. Find the Longest Common Prefix
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (!strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }

    // 18. Convert a String to a Character Array
    public static char[] toCharArray(String s) {
        return s.toCharArray();
    }

    // 19. Replace Spaces with %20 (URL Encoding)
    public static String urlEncodeSpaces(String s) {
        return s.replace(" ", "%20");
    }

    // 20. Convert a Sentence into an Acronym
    public static String toAcronym(String s) {
        StringBuilder sb = new StringBuilder();
        for (String word : s.split("\\s+")) {
            if (!word.isEmpty()) sb.append(Character.toUpperCase(word.charAt(0)));
        }
        return sb.toString();
    }

    // 21. Check if a String Contains Only Digits
    public static boolean containsOnlyDigits(String s) {
        return s.matches("\\d+");
    }

    // 22. Find the Number of Words in a String
    public static int countWords(String s) {
        if (s.trim().isEmpty()) return 0;
        return s.trim().split("\\s+").length;
    }

    // 23. Remove a Given Character from a String
    public static String removeChar(String s, char ch) {
        return s.replace(String.valueOf(ch), "");
    }

    // 24. Find the Shortest Word in a String
    public static String shortestWord(String s) {
        String[] words = s.trim().split("\\s+");
        String shortest = words[0];
        for (String word : words) {
            if (word.length() < shortest.length()) shortest = word;
        }
        return shortest;
    }

    // 25. Find the Longest Palindromic Substring
    public static String longestPalindromicSubstring(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    // Main method for quick testing
    public static void main(String[] args) {
        System.out.println("Reverse 'hello': " + reverseString("hello"));
        System.out.println("Is 'racecar' palindrome? " + isPalindrome("racecar"));
        System.out.println("Remove duplicates from 'banana': " + removeDuplicates("banana"));
        System.out.println("First non-repeating char in 'swiss': " + firstNonRepeatingChar("swiss"));
        System.out.println("Char occurrences in 'hello': " + charOccurrences("hello"));
        System.out.println("Reverse words in 'hello world': " + reverseWords("hello world"));
        System.out.println("Are 'listen' and 'silent' anagrams? " + areAnagrams("listen", "silent"));
        System.out.println("Longest substring without repeating chars in 'abcabcbb': " + longestUniqueSubstring("abcabcbb"));
        System.out.println("String to int '  -42abc': " + stringToInt("  -42abc"));
        System.out.println("Compress 'aaabbc': " + compressString("aaabbc"));
        System.out.println("Most frequent char in 'hello': " + mostFrequentChar("hello"));
        System.out.println("Is 'waterbottle' rotation of 'erbottlewat'? " + isRotation("waterbottle", "erbottlewat"));
        System.out.println("Remove whitespaces from ' a b c ': '" + removeWhiteSpaces(" a b c ") + "'");
        System.out.println("Valid shuffle of 'abc' and 'def' in 'adbcef'? " + isValidShuffle("adbcef", "abc", "def"));
        System.out.println("Title case 'hello world': " + toTitleCase("hello world"));
        System.out.println("Longest common prefix of ['flower','flow','flight']: " + longestCommonPrefix(new String[]{"flower","flow","flight"}));
        System.out.println("Char array of 'abc': " + Arrays.toString(toCharArray("abc")));
        System.out.println("URL encode spaces in 'Mr John Smith': " + urlEncodeSpaces("Mr John Smith"));
        System.out.println("Acronym of 'Portable Network Graphics': " + toAcronym("Portable Network Graphics"));
        System.out.println("Contains only digits '12345'? " + containsOnlyDigits("12345"));
        System.out.println("Count words in 'hello world  ': " + countWords("hello world  "));
        System.out.println("Remove char 'a' from 'banana': " + removeChar("banana", 'a'));
        System.out.println("Shortest word in 'I love programming': " + shortestWord("I love programming"));
        System.out.println("Longest palindromic substring in 'babad': " + longestPalindromicSubstring("babad"));
    }
}


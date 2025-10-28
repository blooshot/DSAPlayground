package practiceSets;

import java.util.*;

import static java.util.stream.Collectors.*;

public class Interview4 {
    public static void main(String[] args) {
        //(a+b)
        //
        //
        //
        System.out.println(findRedundantBrackets("(a+c*b)+(c)"));;

}//EM

private  static  void  countFrequecy(){
    List<Integer> numbers = Arrays.asList(1, 3, 241, 2324, 242, 14313432, 45, 4363, 789, 65, 44, 64, 3, 4, 1, 12, 56, 65, 78, 10,98,65,233,242,65,21);
    Map<Integer, Long> sortedMap = numbers.stream()
            .collect(groupingBy(x -> x, counting())) // Step 1: count frequency
            .entrySet().stream()
            .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed()) // Step 2: sort by count desc
            .collect(toMap(
                    Map.Entry::getKey,
                    Map.Entry::getValue,
                    (e1, e2) -> e1,
                    LinkedHashMap::new // Step 3: preserve order
            ));

    System.out.println(sortedMap);

    //        System.out.println(
//                numbers.stream().collect(groupingBy(x->x, counting()))
//                        .entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).collect(toMap(
//                                Map.Entry::getKey,
//                                Map.Entry::getValue,
//                                (e1, e2) -> e1,
//                                LinkedHashMap::new
//                        ))
//        );
//        Map<Integer, Long> originalCounts = numbers.stream()
//                .collect(groupingBy(x -> x, counting()));
//        Map<Integer, Long> sortedCounts = originalCounts.entrySet().stream()
//                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
//                .collect(toMap(
//                        Map.Entry::getKey,
//                        Map.Entry::getValue,
//                        (e1, e2) -> e1, // Merge function for duplicate keys (not expected here)
//                        LiskedHashMap::new // Use LinkedHashMap to preserve insertion order
//                ));
//
//        System.out.println(sortedCounts);

}

private static void  manualAnagram(){
    List<String> ls = Arrays.asList("eat", "tea", "bat", "tab", "ate", "lion");
    HashMap<String,List<String>> mhp = new HashMap<String,List<String>>();
    // sorted as per chars
    for(String word : ls){
        char[] c = word.toCharArray();
        Arrays.sort(c);
        String stringBuilder = new String(c);
        if(!mhp.containsKey(stringBuilder)){
            mhp.put(stringBuilder,new ArrayList<>());
        }
        mhp.get(stringBuilder).add(word);
    }

    System.out.println(mhp.values());
}

private  static  void linkLint(){
    //        BearLL myLinkedList = new BearLL(1);
//        myLinkedList.add(2);
//        myLinkedList.add(3);
//        myLinkedList.add(4);
//        myLinkedList.add(2);
//
//        BearLL.Node temp  = myLinkedList.getHead();
//        System.out.println( myLinkedList.reverseLinkedList(temp));

//        N temp = myLinkedList.getHead();
//        while (temp != null){
//            System.out.println(temp);
//            temp = temp.next;
//        }
}

    public static boolean findRedundantBrackets(String s)
    {
        Stack<Character> myStack = new Stack<>();
        for(Character ca : s.toCharArray()){
            if(ca == '('){
                myStack.push(ca);
            }else if(ca == ')'){
                if(myStack.isEmpty() || myStack.pop() != '('){
                    return false;
                }
            }
        }
        return myStack.isEmpty();
    }
}//EC





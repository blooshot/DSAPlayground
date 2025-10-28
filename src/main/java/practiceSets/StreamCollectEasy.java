package practiceSets;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamCollectEasy {

    public static void main(String[] args) {
        StreamCollectEasy runner = new StreamCollectEasy();
       // runner.filterEvenNumbers();
       // runner.SumOfAllEvenNumber();
//        runner.ConvertToUppercase();
//        runner.StartWithLetterA();
//        runner.SumOfAll();
//        runner.SortingList();
//        runner.RemoveDuplicate();
        runner.average();
    }

    //Filter Even Numbers (Stream API)
    public void filterEvenNumbers() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        //Expected Output: [2, 4, 6, 8, 10]
        System.out.println( numbers.stream()
                .filter(num -> num % 2 == 0)
                .collect(Collectors.toList()));
    }

    // Sum of All even Numbers
    public void SumOfAllEvenNumber(){
        //Expected Output: 12
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        System.out.println(numbers.stream().filter(x-> x % 2 == 0).reduce(Integer::sum));
    }

    //Convert to Uppercase
    public void ConvertToUppercase(){
        //Expected Output: [ALICE, BOB, CHARLIE, DAVID]
        List<String> names = Arrays.asList("alice", "bob", "charlie", "david");
        System.out.println(names.stream().map(String::toUpperCase).collect(Collectors.toList()));
    }

    //Filter a list of strings to keep only those that start with the letter "a".
    public void StartWithLetterA(){
        //Expected Output: ["apple", "apricot"]
        List<String> words = Arrays.asList("apple", "banana", "apricot", "orange");
        System.out.println(words.stream().filter(x -> x.startsWith("a") == true).collect(Collectors.toList()));
    }

    //Sum of Numbers
    public void SumOfAll(){
        //Expected Output: 15
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(numbers.stream().reduce(Integer::sum).get());
    }

    //Sort the list in ascending order using Collections.sort
    public void SortingList(){
        //Expected Output: [1, 3, 5, 7, 9]
        List<Integer> numbers = Arrays.asList(5, 3, 9, 1, 7);
        System.out.println(numbers.stream().sorted((a,b)->a-b).collect(Collectors.toList()));
    }

    //Remove duplicates using a Set
    public void RemoveDuplicate(){
        //[1, 2, 3, 4, 5]
        List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 4, 4, 5);
        Set<Integer> set = numbers.stream().collect(Collectors.toSet()); // <1>
        System.out.println(set);
    }


    public  void average(){
        List<Integer> newlist = List.of(2,5,7,8,9,32);
//    newlist.stream().collect();

        //find average
        System.out.println(newlist.stream().collect(Collectors.summarizingInt(m->m)).getAverage());
//        System.out.println(newlist.averagingInt());
    }

}

package practiceSets;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class StreamCollectMedium {
    public static void main(String[] args) {
        StreamCollectMedium runner = new StreamCollectMedium();
        runner.GroupStringByLength();
        runner.FindAverage();
        runner.SortingPersonByAge();
        runner.FrequencyMapFromList();
        runner.MostFrequentWords();
        runner.FlattingList();
        runner.GroupingPersonByAge();
        runner.SortInDescendingOrder();
        runner.FindDuplicateInList();
        runner.FindFirstNonRepeatingCharacter();
    }

    //Group the strings by their length using Collectors.groupingBy
    public void GroupStringByLength(){
        //Expected Output: {3=[fig], 5=[apple, kiwi], 6=[banana, orange]}
        List<String> words = Arrays.asList("apple", "banana", "kiwi", "orange", "fig");
        System.out.println(words.stream().collect(groupingBy(String::length)));
    }

    // Use a stream to calculate the average of the numbers.
    public void FindAverage(){
        // Expected Output: 30.0
        List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);
        System.out.println(numbers.stream().mapToInt(Integer::intValue).average().getAsDouble());
    }

    // Sort list of Person objects by age usign a comparator
    public void SortingPersonByAge(){
        // Expected Output: [Person(name=Charlie, age=20), Person(name=Alice, age=25), Person(name=Bob, age=30)]
//        List<Person> people = Arrays.asList(new Person("Alice",25),new Person("Bob",30),new Person("Charlie",20));
//        System.out.println(people.stream().sorted((a,b)-> a.age - b.age).collect(toList()));
    }

    //Create a HashMap where the key is the word and the value is its frequency in the list.
    public void FrequencyMapFromList(){
        //Expected Output: {apple=3, banana=2, orange=1}
        List<String> words = Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple");
        Map<String,Long> FreNao = words.stream().collect(
                groupingBy(word -> word, Collectors.counting()
                ));
        System.out.println(FreNao);
    }

    // Find the top 3 most frequent words in a given text.
    public void MostFrequentWords(){
        //Expected Output: [the=3, fox=2, dog=2] (A List<Map.Entry<String, Integer>> representing the top 3)
        String text = "the quick brown fox jumps over the lazy dog the fox and the dog";
        List<String> listOfWords= Arrays.stream(text.split(" ")).toList();
        Map<String,Long> ListOfFrequentWord = listOfWords.stream().collect(
                groupingBy(word-> word,Collectors.counting()
                )).entrySet().stream().filter(word-> word.getValue() > 1).collect(
                        Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue));
        System.out.println(ListOfFrequentWord);

    }

    //Flatten the list of lists into a single list using flatMap.
    public void FlattingList(){
        //[1, 2, 3, 4, 5, 6]
        List<List<Integer>> numbers = Arrays.asList(Arrays.asList(1, 2), Arrays.asList(3, 4), Arrays.asList(5, 6));
        System.out.println(numbers.stream().flatMap(x->x.stream()).toList());
    }

    // Group Person objects by age
    public void GroupingPersonByAge(){
        // Expected Output: {22=[Eve], 25=[Alice, Charlie], 30=[Bob, David]}
//        List<Person> people = Arrays.asList(
//                new Person("Alice",25),
//                new Person("Bob",30),
//                new Person("Eve",22),
//                new Person("David",30),
//                new Person("Charlie",25)
//        );
//        System.out.println(people.stream().collect(groupingBy(Person::getAge,mapping(p -> p.name, toList()))));
    }

    //Sort a List of Integers in Descending Order
    public void SortInDescendingOrder(){
        // Expected Output: [8, 5, 3, 2, 1]
        List<Integer> numbers = Arrays.asList(5, 2, 8, 1, 3);
        System.out.println(numbers.stream().sorted((a,b)->b-a).collect(toList()));
    }

    //Find Duplicate Elements in a List
    public void FindDuplicateInList(){
        // Expected Output: [1, 2, 3]
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 2, 3, 5, 6, 1);
        System.out.println(numbers.stream().collect(groupingBy(num -> num, TreeMap::new, counting())).
                entrySet().stream().filter(x -> x.getValue() > 1).map(Map.Entry::getKey).collect(toList()));
    }

    //Find the First Non-Repeating Character in a String
    public void FindFirstNonRepeatingCharacter() {
        //Expected Output:'w'
        String str = "swiss";
        System.out.println(str.chars().mapToObj(c -> (char) c).collect(
                Collectors.groupingBy(c -> c, Collectors.counting())).entrySet().stream().filter(x -> x.getValue() == 1).findFirst().get().getKey());
    }


}

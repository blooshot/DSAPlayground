package practiceSets;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class StreamCollectHard {
    public static void main(String[] args) {
        StreamCollectHard runner = new StreamCollectHard();
//        runner.GroupEmployeeByDepAndSal();
//        runner.SortStudentByGradeAndAge();
        runner.GroupingAnagram();
//    runner.FindSecondLargestNumber();
//        runner.FindNthHeighestSalaryOfEmployee();
//        runner.SingleSortedList();
//        runner.GroupByFirstLetter();
//        runner.GroupByFrequency();
//        runner.MostExpensiveProductInEachCategory();
//        runner.UniqueAddresses();
//        Employ emp = () -> "Software Engineer";
//        System.out.println(emp.getName());


    }

    // Group employees by department and then by salary range(e.g. 0-6000, 6000-10000)
    public void GroupEmployeeByDepAndSal(){
        //{HR={6000-10000={Charlie=[Employee(name=Charlie, department=HR, salary=7000)]},0-6000={Alice=[Employee(name=Alice, department=HR, salary=5000)]}},
        // IT={6000-10000={David=[Employee(name=David, department=IT, salary=8000)]}, 0-6000={Bob=[Employee(name=Bob, department=IT, salary=6000)]}}}
        List<Employee> employees = Arrays.asList(
                new Employee("Alice","HR",5000),
                new Employee("Bob","IT",6000),
                new Employee("Charlie","HR",7000),
                new Employee("David","IT",8000)
        );


        System.out.println(employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.groupingBy(e -> {
                            if (e.getSalary() <= 6000) return "0-6000";
                            else return "6000-10000";
                        },mapping(Employee::getName, toList())) // mapping is optional, we can remove it
                )));

//        System.out.println(employees.stream().collect(groupingBy(employee ->employee.department)));
//        System.out.println(employees.stream().collect(groupingBy(employee ->employee.salary)));
    }

    // Sort student first by grade in descending order and then by age in ascending order
    public void SortStudentByGradeAndAge(){
        List<Student> students = Arrays.asList(
                new Student("Alice","A",20),
                new Student("Bob","B",22),
                new Student("Charlie","A",19)
        );
    Comparator<Student> comparator = Comparator.comparing(Student::getGrade);
        System.out.println(students.stream().sorted(comparator).collect(toList()));
    }

    // Group the words into list of anagrams
    public void GroupingAnagram(){
//        List<String> words = Arrays.asList("listen","silent","enlist","google","ogogle");
        List<String> words = Arrays.asList("eat","tea","tan","ate","nat","bat");
    HashMap<String,String> mp = new HashMap<>();
    for(String w : words){
        String sortedWord = w.chars().sorted().collect(StringBuilder::new,StringBuilder::appendCodePoint,StringBuilder::append).toString();
        mp.put(w, sortedWord);
    }

      /*  words.forEach(x->{
            String word = x;
            String sortedWord = x.chars().sorted().collect(StringBuilder::new,StringBuilder::appendCodePoint,StringBuilder::append).toString();
            Map<String,List<String>> mymap = new HashMap<>();
            List<String> dups = new ArrayList<>();
            mymap.computeIfAbsent(sortedWord, k -> new ArrayList<>()).add(x);
//            if(mymap.containsValue(sortedWord)){
//                mymap.put(word,sortedWord);
//            }

            System.out.println(mymap);
//            System.out.println(word+" "+sortedWord);
        });*/

//        System.out.println(
//                words.stream().collect(groupingBy(word-> word,
//                mapping(x-> x.chars().sorted().collect(StringBuilder::new,StringBuilder::appendCodePoint,StringBuilder::append).toString(),toList())))
//                        .entrySet().stream().filter(x-> x.getValue().equals(x.getKey())).collect(toMap(Map.Entry::getKey,Map.Entry::getValue ))
//
//        );
//        System.out.println(words.stream().sorted().
//                collect(groupingBy(word -> word.chars().sorted().collect(StringBuilder::new,StringBuilder::appendCodePoint,StringBuilder::append).toString())));

        System.out.println(words.stream().sorted().
                collect(groupingBy(word -> word.chars().sorted()
                        .collect(StringBuilder::new,StringBuilder::appendCodePoint,StringBuilder::append).toString()))
                        .values() // <--- this gives Collection<List<String>>
                        .stream()
                        .collect(Collectors.toList()));

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

    //Find Second Largest Number`
    public void FindSecondLargestNumber() {
        List<Integer> numbers = Arrays.asList(70,10, 20,74 , 30,80, 40, 50);
       /* numbers.sort(( a, b ) -> a - b);
        System.out.println(numbers.get(numbers.size()-2));*/

//        System.out.println();
        Integer result = numbers.stream().sorted().skip(numbers.size()-2).collect(toList()).get(0);
        System.out.println(result);
//        Integer max = Integer.MIN_VALUE;
//        for(Integer i: numbers){
//                if(i> max){
//                    max = i;
//                }
//            System.out.println(i);
//        }
//        System.out.println(numbers.indexOf(max));

    }

    //Find Nth highest salary of employee
    public void FindNthHeighestSalaryOfEmployee(){
        List<Employee> employees = Arrays.asList(
                new Employee("Alice","HR",100000),
                new Employee("Bob","IT",80000),
                new Employee("Charlie","HR",120000),
                new Employee("David","IT",90000),
                new Employee("Eve","IT",110000)
        );
        Integer nth = 1;
        List<Employee> result = employees.stream().sorted((a,b)->a.salary - b.salary).collect(toList());
        Employee employee1= result.stream().skip(result.size()-nth).collect(toList()).get(0);
        System.out.println(employee1);
//        for(Employee employee: result){
//            System.out.println(employee);
//        }
    }

    // Single Sorted List
    public void SingleSortedList(){
        List<List<Integer>> lists = Arrays.asList(Arrays.asList(1, 3, 5), Arrays.asList(2, 4, 6), Arrays.asList(0, 7, 8));
        System.out.println(lists.stream().flatMap(x->x.stream()).sorted().collect(toList()));
    }

    // Group By First Letter
    public void GroupByFirstLetter(){
        List<String> words = Arrays.asList("apple", "banana", "cherry", "avocado", "blueberry");
        System.out.println(words.stream().collect(groupingBy(word -> word.charAt(0), toList())));
    }

    // Group By Frequency
    public void GroupByFrequency(){
        String sentence = "apple banana chedder apple apple orange banana apple chedder";
        List<String> words = Arrays.asList(sentence.split(" "));
//        List<String> words = Arrays.asList("apple", "banana", "apple", "apple", "banana", "apple");
        System.out.println(words.stream().collect(groupingBy(word -> word, Collectors.counting())));
    }

    //  most expensive product in each category
    public void MostExpensiveProductInEachCategory() {
        List<Product> products = Arrays.asList(
                new Product("apple", "Fruits", 100),
                new Product("banana", "Fruits", 200),
                new Product("chedder", "Dairy", 300),
                new Product("apple", "Fruits", 400),
                new Product("apple", "Fruits", 500),
                new Product("banana", "Fruits", 600),
                new Product("apple", "Fruits", 700)
        );
        System.out.println(products.stream().collect(groupingBy(Product::getCategories, maxBy(Comparator.comparingInt(Product::getPrices)))));
    }
    public void  UniqueAddresses() {
        List<Address> addresses = Arrays.asList(
                new Address("123 Main St", "New York", "NY", "10001", "A1"),
                new Address("456 Elm St", "Los Angeles", "CA", "90001", "B2"),
                new Address("789 Oak St", "San Francisco", "CA", "94101", "C3"),
                new Address("123 Main St", "New York", "NY", "10001", "A1"),
                new Address("456 Elm St", "Los Angeles", "CA", "90001", "B2"),
                new Address("789 Oak St", "San Francisco", "CA", "94101", "C3")
        );
        Map<String, Address> uniqueAddresses = new HashMap<>() ;

        for(Address address: addresses){
            String uniqueKey = address.getHouseNo()+ "-"+address.getStreetNo() + "-" + address.getPincode();
            uniqueAddresses.putIfAbsent(uniqueKey, address);
        }
        System.out.println(uniqueAddresses);
    }
}//EC



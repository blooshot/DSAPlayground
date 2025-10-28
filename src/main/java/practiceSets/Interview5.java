package practiceSets;

import java.util.Arrays;

import static java.util.stream.Collectors.toList;

public class Interview5  {

    public static void main(String[] args) {
        String[] str ={"ABC","CAB","ABC","ADE"};
//        Arrays.str
//        List<String> mylist = ;
        System.out.println(Arrays.asList(str).stream().distinct().collect(toList()));
//        str.stream().distinct().collect(toList());

//        emplist.stream().sorted((a,b)-> b.sal- a.sal).skip(empList.size() - 2).get(0);
    }
}// EC  

//public class Person2 {
//
//    private Long id;
//    private String name;
//    private Double sal;
//
//    //constructor
//    public Person2(Long id, String name, Double sal) {
//        this.id = id;
//        this.name = name;
//        this.sal = sal;
//    }
//    //setter & getter method
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public Double getSal() {
//        return sal;
//    }
//
//    public void setSal(Double sal) {
//        this.sal = sal;
//    }
//
//    String toString(){
//
//    }
//
//    public static void main(String[] args) {
//
//        List<Person2> personList = Arrays.asList(
//                new Person2(101L, "Raja", 50000.00),
//                new Person2(102L, "Ram", 400000.00),
//                new Person2(103L, "Kishna", 100000.00)
//        );
//
//        // find the 2nd highest sal of Person using Stream API
////        Comparator.comparing(Person2::getSal ->)
//        System.out.println(  Arrays.toString(personList.stream().
//                sorted((a,b)-> b.sal.intValue()- a.sal.intValue())
//                .skip(personList.size() - 2).collect(toList()))
//    );
//
//
//    }
//
//
//
//}
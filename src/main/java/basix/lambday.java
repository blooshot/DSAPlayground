package basix;

import java.util.*;
import java.util.function.BinaryOperator;

public class lambday {

    private Integer id = 20;
    private String name = "Krishna";
    private Integer age = 25;

    public static void main(String[] args) {
        lambday l = new lambday();
//        System.out.println(l.id);
//        System.out.println(l.name);
//        System.out.println(l.age);
//       l.mySum();

        ArrayList<Emp> empArrayList = new ArrayList<>();
        empArrayList.add(new Emp("k",100));
        empArrayList.add(new Emp("q",300));
        empArrayList.add(new Emp("w",500));

        Map myMap = new HashMap();
        myMap.put("k",100);
        myMap.put("q",300);
        myMap.put("w",500);

       empArrayList.stream().max(Comparator.comparingInt(Emp::getsalary));

//        for(Emp em :empArrayList){
//            System.out.println(em.getsalary());
//        }
        Optional<Emp> sal = empArrayList.stream().max(Comparator.comparingInt(Emp::getsalary));

        System.out.println(sal.get().getname() + sal.get().getsalary());
    }

    private Integer mySum(){
        BinaryOperator<Integer> biFun = (x, y) -> x + y;
        System.out.println(biFun.apply(this.id, this.age));
        return 1;
    }


}
class Emp{
    private String name;
    private Integer salary;

    Emp(String name, Integer salary){
        this.salary = salary;
        this.name = name;
    }

    public String getname(){
        return this.name;
    }
    public Integer getsalary(){
        return this.salary;
    }
}

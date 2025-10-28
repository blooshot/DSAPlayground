package practiceSets;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

public class Inteview {
    public static void main(String[] args) {
        List<Employee2> employees = new ArrayList<>();

        employees.add(new Employee2(101, "Alice", 55000, "HR"));

        employees.add(new Employee2(101, "Alice", 55000, "HR"));

        employees.add(new Employee2(102, "Bob", 60000, "IT"));

        employees.add(new Employee2(103, "Charlie", 48000, "IT"));

        // emp sal  > 3000 which depart.

//        System.out.println(employees.stream().filter(employee2 -> employee2.getSalary() > 30000).collect(groupingBy(employee2 -> employee2.getDepartment(),toList())));
          //  employees.stream().forEach(e-> System.out.println(e.getName()+" | "+ e.hashCode()));
        for (Integer i =0; i< employees.size(); i++){
            if(i >=3) break;
            System.out.println(employees.get(i).equals(employees.get(i+1)));
        }
    }



}

@Data
class Employee2{

    private int id;

    private String name;

    private double salary;

    private String department;

    public Employee2(int id, String name, double salary, String department) {

        this.id = id;

        this.name = name;

        this.salary = salary;

        this.department = department;

    }

    @Override

    public String toString() {

        return "Employee { " +

                "ID=" + id +

                ", Name='" + name + '\'' +

                ", Salary=" + salary +

                ", Department='" + department + '\'' +

                " }";

    }

}































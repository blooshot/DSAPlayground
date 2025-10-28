package practiceSets;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data
////@NoArgsConstructor
//@AllArgsConstructor
//public class Person {
//    String name;
//    int age;
//}

@Data
@NoArgsConstructor
@AllArgsConstructor
class Employee1{
    String name;
    String department;
    int salary;


    // Constructor, getters, toString
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class Student {
    String name;
    String grade;
    int age;

    // Constructor, getters, toString
}


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
class Employee {
    String name;
    String department;
    int salary;


    // Constructor, getters, toString
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class Product{
    String names;
    String categories;
    int prices;
}

@Data
@NoArgsConstructor
class Address{

    Address(String streetNo, String city, String state, String pincode, String HouseNo){
        this.streetNo = streetNo;
        this.city = city;
        this.state = state;
        this.pincode = pincode;
        this.HouseNo = HouseNo;
    }

    String city;
    String state;
    String streetNo;
    String pincode;
    String HouseNo;
}
package com.example.EmployeePayroll.model;

//UC3
import jakarta.persistence.*;
import lombok.*;
import com.example.EmployeePayroll.dto.EmployeeDTO;


@Entity
@Table(name = "employees")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double salary;

    public Employee(EmployeeDTO employeeDTO) {
        this.name = employeeDTO.getName();
        this.salary = employeeDTO.getSalary();
    }
}


//UC2
//import jakarta.persistence.*;
//import jakarta.validation.constraints.Min;
//import jakarta.validation.constraints.NotBlank;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Entity
//@Table(name = "employees")
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//public class Employee {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @NotBlank(message = "Name is mandatory")
//    private String name;
//
//    @Min(value = 1000, message = "Salary must be at least 1000")
//    private double salary;
//}

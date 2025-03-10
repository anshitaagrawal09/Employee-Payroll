//UC10
package com.example.EmployeePayroll.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Min;
import lombok.Data;

@Data  // Generates Getters & Setters
public class EmployeeDTO{

    @NotEmpty(message = "Name cannot be empty")
    @Pattern(regexp = "^[A-Z][a-zA-Z\\s]{2,}$", message = "Name should start with a capital letter and have at least 3 characters")
    private String name;

    @Min(value = 500, message = "Salary must be at least 500")
    private long salary;

    // Constructor, Getters, Setters
}



//package com.example.EmployeePayroll.dto;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
////UC-6 Use Lombok Library to auto generate getters and setters for the DTO
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//public class EmployeeDTO {
//    private String name;
//    private double salary;
//}

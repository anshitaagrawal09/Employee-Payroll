//UC7
package com.example.EmployeePayroll.controller;

//UC9

import com.example.EmployeePayroll.dto.EmployeeDTO;
import com.example.EmployeePayroll.model.Employee;
import com.example.EmployeePayroll.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@RequestMapping("/employeepayrollservice")
@Slf4j  // Lombok Logging
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public List<Employee> getAllEmployees() {
        log.info("Fetching all employees...");
        return employeeService.getAllEmployees();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        log.info("Fetching employee with ID: {}", id);
        Employee employee = employeeService.getEmployeeById(id);
        return ResponseEntity.ok(employee);
    }

//    @PostMapping("/create")
//    public ResponseEntity<Employee> addEmployee(@Valid @RequestBody EmployeeDTO employeeDTO) {
//        log.info("Creating new employee: {}", employeeDTO);
//        Employee employee = employeeService.createEmployee(employeeDTO);
//        return ResponseEntity.ok(employee);
//    }
    //UC10
    //valid curl -X POST -H "Content-Type: application/json" -d '{"name": "Lisa","salary": 2000}' "http://localhost:8080/employeepayrollservice/create" -w "\n"
    //invalid curl -X POST -H "Content-Type: application/json" -d '{"name": "Ma","salary": 3000}' "http://localhost:8080/employeepayrollservice/create" -w "\n"
@PostMapping("/create")
public ResponseEntity<Employee> createEmployee(@Valid @RequestBody EmployeeDTO employeeDTO) {
    Employee employee = employeeService.createEmployee(employeeDTO);
    return new ResponseEntity<>(employee, HttpStatus.CREATED);
}

//    @PutMapping("/update/{id}")
//    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @Valid @RequestBody EmployeeDTO employeeDTO) {
//        log.info("Updating employee with ID: {}", id);
//        Employee updatedEmployee = employeeService.updateEmployee(id, employeeDTO);
//        return ResponseEntity.ok(updatedEmployee);
//    }
@PutMapping("/update/{id}")
public ResponseEntity<Employee> updateEmployee(@PathVariable long id, @Valid @RequestBody EmployeeDTO employeeDTO) {
    Employee updatedEmployee = employeeService.updateEmployee(id, employeeDTO);
    return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
}

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
        log.info("Deleting employee with ID: {}", id);
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok("Employee deleted successfully");
    }
}


//import com.example.EmployeePayroll.dto.EmployeeDTO;
//import com.example.EmployeePayroll.model.Employee;
//import com.example.EmployeePayroll.service.EmployeeService;
//import jakarta.validation.Valid;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@Slf4j //  Enable logging
//@RestController
//@RequestMapping("/employeepayrollservice")
//public class EmployeeController {
//
//    @Autowired
//    private EmployeeService employeeService;
//
//    @GetMapping("/")
//    public List<Employee> getAllEmployees() {
//        log.info("Fetching all employees");
//        return employeeService.getAllEmployees();
//    }
//
//    @GetMapping("/get/{id}")
//    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
//        log.info("Fetching employee with ID: {}", id);
//        Employee employee = employeeService.getEmployeeById(id)
//                .orElseThrow(() -> {
//                    log.error("Employee with ID {} not found", id);
//                    return new RuntimeException("Employee not found");
//                });
//        return ResponseEntity.ok(employee);
//    }
//
//    @PostMapping("/create")
//    public ResponseEntity<Employee> addEmployee(@Valid @RequestBody EmployeeDTO employeeDTO) {
//        log.info("Creating new employee: {}", employeeDTO);
//        Employee employee = employeeService.createEmployee(employeeDTO);
//        return ResponseEntity.ok(employee);
//    }
//
//    @PutMapping("/update/{id}")
//    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @Valid @RequestBody EmployeeDTO employeeDTO) {
//        log.info("Updating employee with ID: {}", id);
//        Employee updatedEmployee = employeeService.updateEmployee(id, employeeDTO);
//        return ResponseEntity.ok(updatedEmployee);
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
//        log.info("Deleting employee with ID: {}", id);
//        employeeService.deleteEmployee(id);
//        return ResponseEntity.ok("Employee deleted successfully");
//    }
//}



//UC6
//package com.example.EmployeePayroll.controller;
//
//import com.example.EmployeePayroll.dto.EmployeeDTO;
//import com.example.EmployeePayroll.model.Employee;
//import com.example.EmployeePayroll.service.EmployeeService;
//import jakarta.validation.Valid;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/employeepayrollservice")
//public class EmployeeController {
//
//    @Autowired
//    private EmployeeService employeeService;
//
//    @GetMapping("/")
//    public List<Employee> getAllEmployees() {
//        return employeeService.getAllEmployees();
//    }
//
//    @GetMapping("/get/{id}")
//    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
//        Employee employee = employeeService.getEmployeeById(id)
//                .orElseThrow(() -> new RuntimeException("Employee not found")); // ✅ Fix: Handle missing employee
//        return ResponseEntity.ok(employee);
//    }
//
//    @PostMapping("/create")
//    public ResponseEntity<Employee> addEmployee(@Valid @RequestBody EmployeeDTO employeeDTO) {
//        Employee employee = employeeService.createEmployee(employeeDTO); // ✅ Fix: Call correct method
//        return ResponseEntity.ok(employee);
//    }
//
//    @PutMapping("/update/{id}")
//    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @Valid @RequestBody EmployeeDTO employeeDTO) {
//        Employee updatedEmployee = employeeService.updateEmployee(id, employeeDTO);
//        return ResponseEntity.ok(updatedEmployee);
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
//        employeeService.deleteEmployee(id);
//        return ResponseEntity.ok("Employee deleted successfully");
//    }
//}



//UC4

//import com.example.EmployeePayroll.dto.EmployeeDTO;
//import com.example.EmployeePayroll.model.Employee;
//import com.example.EmployeePayroll.service.EmployeeService;
//import jakarta.validation.Valid;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/employeepayrollservice")
//public class EmployeeController {
//
//    @Autowired
//    private EmployeeService employeeService;
//
//    // Get all employees
//    @GetMapping("/")
//    public List<Employee> getAllEmployees() {
//        return employeeService.getAllEmployees();
//    }
//
//    // Get employee by ID
//    @GetMapping("/get/{id}")
//    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
//        Optional<Employee> employee = employeeService.getEmployeeById(id);
//        return employee.map(ResponseEntity::ok)
//                .orElseGet(() -> ResponseEntity.notFound().build()); // ✅ Fix: Optional handling
//    }
//
//    // Create new employee
//    @PostMapping("/create")
//    public Employee createEmployee(@Valid @RequestBody EmployeeDTO employeeDTO) { // ✅ Accept EmployeeDTO
//        return employeeService.createEmployee(employeeDTO);
//    }
//
//    // Update employee
//    @PutMapping("/update/{id}")
//    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @Valid @RequestBody EmployeeDTO employeeDTO) { // ✅ Accept EmployeeDTO
//        return ResponseEntity.ok(employeeService.updateEmployee(id, employeeDTO));
//    }
//
//    // Delete employee
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
//        employeeService.deleteEmployee(id);
//        return ResponseEntity.noContent().build();
//    }
//}


//import com.example.EmployeePayroll.model.Employee;
//import com.example.EmployeePayroll.service.EmployeeService;
//import jakarta.validation.Valid;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/employeepayrollservice")
//public class EmployeeController {
//
//    @Autowired
//    private EmployeeService employeeService;
//
//    // Get all employees
//    @GetMapping("/")
//    public List<Employee> getAllEmployees() {
//        return employeeService.getAllEmployees();
//    }
//
//    @GetMapping("/get/{id}")
//    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
//        Employee employee = employeeService.getEmployeeById(id)
//                .orElseThrow(() -> new RuntimeException("Employee not found"));
//        return ResponseEntity.ok(employee);  // ✅ Fix: Directly returning ResponseEntity
//    }
//
//
//    // Create new employee
//    @PostMapping("/create")
//    public Employee createEmployee(@Valid @RequestBody Employee employee) {
//        return employeeService.createEmployee(employee);
//    }
//
//    // Update employee
//    @PutMapping("/update/{id}")
//    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @Valid @RequestBody Employee employee) {
//        return ResponseEntity.ok(employeeService.updateEmployee(id, employee));
//    }
//
//    // Delete employee
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
//        employeeService.deleteEmployee(id);
//        return ResponseEntity.noContent().build();
//    }
//}

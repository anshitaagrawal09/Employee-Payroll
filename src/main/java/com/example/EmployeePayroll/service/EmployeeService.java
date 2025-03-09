//UC7
package com.example.EmployeePayroll.service;

//UC9

import com.example.EmployeePayroll.dto.EmployeeDTO;
import com.example.EmployeePayroll.model.Employee;
import com.example.EmployeePayroll.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee createEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setName(employeeDTO.getName());
        employee.setSalary(employeeDTO.getSalary());
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public Employee updateEmployee(Long id, EmployeeDTO employeeDTO) {
        Employee employee = employeeRepository.findById(id).orElse(null);
        if (employee != null) {
            employee.setName(employeeDTO.getName());
            employee.setSalary(employeeDTO.getSalary());
            return employeeRepository.save(employee);
        }
        return null;
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}

//import com.example.EmployeePayroll.dto.EmployeeDTO;
//import com.example.EmployeePayroll.model.Employee;
//import com.example.EmployeePayroll.repository.EmployeeRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class EmployeeService {
//
//    @Autowired
//    private EmployeeRepository employeeRepository;
//
//    public Employee createEmployee(EmployeeDTO employeeDTO) {
//        Employee employee = new Employee();
//        employee.setName(employeeDTO.getName());
//        employee.setSalary(employeeDTO.getSalary());
//        return employeeRepository.save(employee);
//    }
//
//    public List<Employee> getAllEmployees() {
//        return employeeRepository.findAll();
//    }
//
//    public Optional<Employee> getEmployeeById(Long id) {
//        return employeeRepository.findById(id);
//    }
//}
//import com.example.EmployeePayroll.dto.EmployeeDTO;
//import com.example.EmployeePayroll.model.Employee;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//@Slf4j // ✅ Enable logging
//@Service
//public class EmployeeService {
//
//    private final List<Employee> employeeList = new ArrayList<>();
//    private Long idCounter = 1L; // Simulating database auto-increment
//
//    public List<Employee> getAllEmployees() {
//        log.info("Fetching all employees");
//        return employeeList;
//    }
//
//    public Optional<Employee> getEmployeeById(Long id) {
//        log.info("Searching for employee with ID: {}", id);
//        return employeeList.stream()
//                .filter(emp -> emp.getId().equals(id))
//                .findFirst();
//    }
//
//    public Employee createEmployee(EmployeeDTO employeeDTO) {
//        Employee employee = new Employee(employeeDTO);
//        employee.setId(idCounter++);
//        employeeList.add(employee);
//        log.info("Employee created successfully: {}", employee);
//        return employee;
//    }
//
//    public Employee updateEmployee(Long id, EmployeeDTO employeeDTO) {
//        Employee employee = getEmployeeById(id)
//                .orElseThrow(() -> {
//                    log.error("Employee with ID {} not found", id);
//                    return new RuntimeException("Employee not found");
//                });
//
//        employee.setName(employeeDTO.getName());
//        employee.setSalary(employeeDTO.getSalary());
//        log.info("Employee updated successfully: {}", employee);
//        return employee;
//    }
//
//    public void deleteEmployee(Long id) {
//        Employee employee = getEmployeeById(id)
//                .orElseThrow(() -> {
//                    log.error("Employee with ID {} not found", id);
//                    return new RuntimeException("Employee not found");
//                });
//
//        employeeList.remove(employee);
//        log.info("Employee with ID {} deleted successfully", id);
//    }
//}




//UC5
//package com.example.EmployeePayroll.service;
//
//import com.example.EmployeePayroll.dto.EmployeeDTO;
//import com.example.EmployeePayroll.model.Employee;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class EmployeeService {
//
//    private final List<Employee> employeeList = new ArrayList<>();
//    private Long idCounter = 1L; // Simulating database auto-increment
//
//    // Get all employees
//    public List<Employee> getAllEmployees() {
//        return employeeList;
//    }
//
//    // Get employee by ID (Return Optional)
//    public Optional<Employee> getEmployeeById(Long id) {
//        return employeeList.stream()
//                .filter(emp -> emp.getId().equals(id))
//                .findFirst();
//    }
//
//    // Add a new employee
//    public Employee createEmployee(EmployeeDTO employeeDTO) {
//        Employee employee = new Employee(employeeDTO);
//        employee.setId(idCounter++); // Simulating DB ID generation
//        employeeList.add(employee);
//        return employee;
//    }
//
//    // Update employee details
//    public Employee updateEmployee(Long id, EmployeeDTO employeeDTO) {
//        Employee employee = getEmployeeById(id)
//                .orElseThrow(() -> new RuntimeException("Employee not found")); // ✅ Fix: Handle missing employees
//
//        employee.setName(employeeDTO.getName());
//        employee.setSalary(employeeDTO.getSalary());
//        return employee;
//    }
//
//    // Delete employee by ID
//    public void deleteEmployee(Long id) {
//        Employee employee = getEmployeeById(id)
//                .orElseThrow(() -> new RuntimeException("Employee not found")); // ✅ Fix: Handle missing employees
//        employeeList.remove(employee);
//    }
//}





//package com.example.EmployeePayroll.service;
//
//
////UC5
//
//
//import com.example.EmployeePayroll.dto.EmployeeDTO;
//import com.example.EmployeePayroll.model.Employee;
//import com.example.EmployeePayroll.service.EmployeeService;
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
//    @GetMapping("/")
//    public List<Employee> getAllEmployees() {
//        return employeeService.getAllEmployees();
//    }
//
//    @GetMapping("/get/{id}")
//    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
//        Optional<Employee> employee = employeeService.getEmployeeById(id);
//        return employee.map(ResponseEntity::ok)
//                .orElseGet(() -> ResponseEntity.notFound().build()); // ✅ Fix: Proper Optional handling
//    }
//
//    @PostMapping("/create")
//    public Employee addEmployee(@RequestBody EmployeeDTO employeeDTO) {
//        return employeeService.createEmployee(employeeDTO);
//    }
//
//    @PutMapping("/update/{id}")
//    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody EmployeeDTO employeeDTO) {
//        return ResponseEntity.ok(employeeService.updateEmployee(id, employeeDTO));
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
//        employeeService.deleteEmployee(id);
//        return ResponseEntity.ok("Employee deleted successfully");
//    }
//}
//
//    // Add a new employee
//    public Employee createEmployee(EmployeeDTO employeeDTO) {
//        Employee employee = new Employee(employeeDTO);
//        employee.setId(idCounter++); // Simulating DB ID generation
//        employeeList.add(employee);
//        return employee;
//    }
//
//    // Update employee details
//    public Employee updateEmployee(Long id, EmployeeDTO employeeDTO) {
//        Employee employee = getEmployeeById(id);
//        employee.setName(employeeDTO.getName());
//        employee.setSalary(employeeDTO.getSalary());
//        return employee;
//    }
//
//    // Delete employee by ID
//    public void deleteEmployee(Long id) {
//        Employee employee = getEmployeeById(id);
//        employeeList.remove(employee);
//    }
//
//
//    // Update employee by ID
////    public Employee updateEmployee(Long id, EmployeeDTO employeeDTO) {
////        Employee employee = getEmployeeById(id)
////                .orElseThrow(() -> new RuntimeException("Employee not found"));
////
////        employee.setName(employeeDTO.getName());
////        employee.setSalary(employeeDTO.getSalary());
////        return employee;
////    }
//
//    // Delete employee by ID
////    public void deleteEmployee(Long id) {
////        employeeList.removeIf(emp -> emp.getId().equals(id));
////    }
//
//
//}
//
//
//
//
////UC2
////import com.example.EmployeePayroll.model.Employee;
////import com.example.EmployeePayroll.repository.EmployeeRepository;
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.stereotype.Service;
////
////import java.util.List;
////import java.util.Optional;
////
////@Service
////public class EmployeeService {
////
////    @Autowired
////    private EmployeeRepository employeeRepository;
////
////    public List<Employee> getAllEmployees() {
////        return employeeRepository.findAll();
////    }
////
////    public Optional<Employee> getEmployeeById(Long id) {
////        return employeeRepository.findById(id);
////    }
////
////    public Employee createEmployee(Employee employee) {
////        return employeeRepository.save(employee);
////    }
////
////    public Employee updateEmployee(Long id, Employee employeeDetails) {
////        Employee employee = employeeRepository.findById(id)
////                .orElseThrow(() -> new RuntimeException("Employee not found"));
////        employee.setName(employeeDetails.getName());
////        employee.setSalary(employeeDetails.getSalary());
////        return employeeRepository.save(employee);
////    }
////
////    public void deleteEmployee(Long id) {
////        employeeRepository.deleteById(id);
////    }
////}
//

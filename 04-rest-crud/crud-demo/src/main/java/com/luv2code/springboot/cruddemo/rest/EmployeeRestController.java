package com.luv2code.springboot.cruddemo.rest;

import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // quick and dirty: inject employee dao
//    private EmployeeDAO employeeDAO;
//
//    @Autowired
//    public EmployeeRestController(EmployeeDAO employeeDAO) {
//        this.employeeDAO = employeeDAO;
//    }

    // expose "/employees" and return a list of employees
    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    // expose "/employees/{id}" and return a list of employees
    @GetMapping("/employees/{id}")
    public Optional<Employee> findById(@PathVariable int id) {
        Optional<Employee> theEmployee = employeeService.findById(id);
        if (theEmployee.isEmpty())
            throw new RuntimeException("Employee id not found -" + id);
        return theEmployee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestParam Employee theEmployee) {
        theEmployee.setId(0);
        return employeeService.save(theEmployee);
    }

    // add mapping for PUT /employees - update existing employee
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee) {
        return employeeService.save(theEmployee);
    }

    // add mapping for DELETE /employees/{id}
    @DeleteMapping("/employees/{id}")
    public String deleteById(@PathVariable int id) {
        Optional<Employee> tempEmp = employeeService.findById(id);
        if (tempEmp.isEmpty())
            throw new RuntimeException("Employee id is not found -" + id);
        employeeService.deleteById(id);
        return "Deleted employee id - " + id;
    }
}

package com.example.demo.resource;

import com.example.demo.model.EmployeeDataModel;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class Employee {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/get/{id}")
    public EmployeeDataModel getEmployee(@PathVariable String id) throws Exception {
        return employeeService.getEmployee(id);
    }

    @PostMapping("/create/{name}/{age}")
    public String createEmployee(@PathVariable String name, @PathVariable String age) {
        return employeeService.createEmployee(name, age);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEmployee(@PathVariable String id) throws Exception {
        employeeService.deleteEmployee(id);
    }

    @PutMapping("/update/{id}/{name}/{age}")
    public EmployeeDataModel updateEmployee(@PathVariable String id , @PathVariable String name,
                                            @PathVariable String age) throws Exception {
        return  employeeService.updateEmployee(id, name, age);
    }
}

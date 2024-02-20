package com.example.demo.service;

import com.example.demo.model.EmployeeDataModel;
import com.example.demo.repoistory.EmployeeDataRepo;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class EmployeeService {

    @Autowired
    public EmployeeDataRepo employeeDataRepo;

    public String createEmployee(final String employeeName, final String employeeAge) {
        String randomId = UUID.randomUUID().toString();
        EmployeeDataModel employeeDataModel =  employeeDataRepo.createEmployee(randomId, employeeName, employeeAge);
        return employeeDataModel.getId();
    }

    public EmployeeDataModel getEmployee(final String id) throws BadRequestException {
        EmployeeDataModel employeeDataModel = employeeDataRepo.getEmployeeById(id);

        if(employeeDataModel == null) {
            throw new BadRequestException("Invalid User");
        }

        return employeeDataModel;
    }

    public void deleteEmployee(final String id) throws BadRequestException {
        EmployeeDataModel employeeDataModel = getEmployee(id);
        employeeDataRepo.deleteEmployee(id);
    }

    public EmployeeDataModel updateEmployee(final String id, final String employeeName, final String employeeAge)
            throws BadRequestException {
        EmployeeDataModel employeeDataModel = employeeDataRepo.getEmployeeById(id);
        return employeeDataRepo.updateEmployee(id, employeeName, employeeAge);
    }
}

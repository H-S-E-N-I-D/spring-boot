package com.shdinesh.springcrud.controller;

import com.shdinesh.springcrud.db2.entity.Employee;
import com.shdinesh.springcrud.db2.repo.EmployeeRepository;
import com.shdinesh.springcrud.util.EmployeeUtil;
import com.shdinesh.springcrud.vo.EmployeeRequestVo;
import com.shdinesh.springcrud.vo.EmployeeResponseVo;
import com.shdinesh.springcrud.vo.EmployeeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/employees")
    public ResponseEntity<EmployeeResponseVo> getEmployees() {
        List<Employee> employees = employeeRepository.findAll();

        List<EmployeeVo> employeeVos = new ArrayList<>();
        employees.forEach(employee -> {
            EmployeeVo employeeVo = EmployeeUtil.convetToEmployeeVo(employee);
            employeeVos.add(employeeVo);
        });
        EmployeeResponseVo employeeResponseVo = new EmployeeResponseVo();
        employeeResponseVo.setEmployees(employeeVos);
        return new ResponseEntity(employeeResponseVo, HttpStatus.OK);
    }

    @PostMapping("/employees")
    public ResponseEntity<EmployeeResponseVo> createEmployee(@RequestBody EmployeeRequestVo employeeRequest) throws ParseException {
        EmployeeResponseVo employeeResponseVo = new EmployeeResponseVo();

        Employee employee = new Employee();
        employee = EmployeeUtil.convertToEmployeeDto(employee, employeeRequest);
        employee = employeeRepository.save(employee);
        employeeResponseVo.setEmployee(
                EmployeeUtil.convetToEmployeeVo(employee)
        );
        return new ResponseEntity(employeeResponseVo, HttpStatus.CREATED);

    }
}

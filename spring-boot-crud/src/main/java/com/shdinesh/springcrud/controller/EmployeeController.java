package com.shdinesh.springcrud.controller;

import com.shdinesh.springcrud.exception.EmployeeNotFoundException;
import com.shdinesh.springcrud.model.Employee;
import com.shdinesh.springcrud.repo.EmployeeRepository;
import com.shdinesh.springcrud.util.EmployeeUtil;
import com.shdinesh.springcrud.vo.EmployeeRequestVo;
import com.shdinesh.springcrud.vo.EmployeeResponseVo;
import com.shdinesh.springcrud.vo.EmployeeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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


    @GetMapping("/employees/{id}")
    public ResponseEntity<EmployeeResponseVo> findEmployee(@PathVariable("id") Integer employeeId) {
        Optional<Employee> employeeOpt = employeeRepository.findById(employeeId);
        EmployeeResponseVo employeeResponseVo = new EmployeeResponseVo();

        if (!employeeOpt.isPresent()) {
            throw new EmployeeNotFoundException("id: " + employeeId);
        }
        Employee employee = employeeOpt.get();
        EmployeeVo employeeVo = EmployeeUtil.convetToEmployeeVo(employee);

        employeeResponseVo.setEmployee(employeeVo);
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


    @PutMapping("/employees/{id}")
    public ResponseEntity<EmployeeResponseVo> updateEmployee(@PathVariable("id") Integer employeeId, @RequestBody EmployeeRequestVo employeeRequest) throws ParseException {
        Optional<Employee> employeeOpt = employeeRepository.findById(employeeId);
        EmployeeResponseVo employeeResponseVo = new EmployeeResponseVo();
        /*if (employeeOpt.isPresent()) {
            Employee employee = employeeOpt.get();
            employee = EmployeeUtil.convertToEmployeeDto(employee, employeeRequest);
            employee = employeeRepository.save(employee);
            employeeResponseVo.setEmployee(
                    EmployeeUtil.convetToEmployeeVo(employee)
            );
            return new ResponseEntity(employeeResponseVo, HttpStatus.OK);

        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);

        }*/

        if (!employeeOpt.isPresent()) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);

        }
        Employee employee = employeeOpt.get();
        employee = EmployeeUtil.convertToEmployeeDto(employee, employeeRequest);
        employee = employeeRepository.save(employee);
        employeeResponseVo.setEmployee(
                EmployeeUtil.convetToEmployeeVo(employee)
        );
        return new ResponseEntity(employeeResponseVo, HttpStatus.OK);


    }


    @DeleteMapping("/employees/{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable("id") Integer employeeId) {
        Optional<Employee> employeeOpt = employeeRepository.findById(employeeId);
        if (!employeeOpt.isPresent()) {
            throw new EmployeeNotFoundException("id: " + employeeId);
        }
        employeeRepository.delete(employeeOpt.get());
        return new ResponseEntity(HttpStatus.NO_CONTENT);// Status 204

    }
}

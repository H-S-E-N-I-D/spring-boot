package com.shdinesh.springcrud.util;

import com.shdinesh.springcrud.db2.entity.Employee;
import com.shdinesh.springcrud.vo.EmployeeRequestVo;
import com.shdinesh.springcrud.vo.EmployeeVo;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class EmployeeUtil {

    public static EmployeeVo convetToEmployeeVo(Employee employee) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return new EmployeeVo(
                String.valueOf(employee.getId()),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getSalary(),
                sdf.format(employee.getJoinedDate()),
                employee.getActive()
        );
    }

    public static Employee convertToEmployeeDto(Employee employee, EmployeeRequestVo employeeRequest) throws ParseException {
        employee.setFirstName(employeeRequest.getFirstName());
        employee.setLastName(employeeRequest.getLastName());
        employee.setEmail(employeeRequest.getEmail());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        employee.setSalary(employeeRequest.getSalary());
        employee.setActive(employeeRequest.getActive());
        employee.setJoinedDate(sdf.parse(employeeRequest.getJoinedDate()));
        return employee;
    }
}

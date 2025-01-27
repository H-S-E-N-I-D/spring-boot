package com.shdinesh.springcrud.vo;

import java.util.List;

public class EmployeeResponseVo {

    private EmployeeVo employee;

    private List<EmployeeVo> employees;


    public EmployeeVo getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeVo employee) {
        this.employee = employee;
    }

    public List<EmployeeVo> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeVo> employees) {
        this.employees = employees;
    }
}

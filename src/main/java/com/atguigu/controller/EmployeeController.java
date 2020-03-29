package com.atguigu.controller;

import com.atguigu.dao.DepartmentDao;
import com.atguigu.dao.EmployeeDao;
import com.atguigu.entities.Department;
import com.atguigu.entities.Employee;
import com.sun.org.glassfish.gmbal.ParameterNames;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Map;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private DepartmentDao departmentDao;

    @GetMapping("/emps")
    public String list(Map<String, Object> map) {
        Collection<Employee> employees = employeeDao.getAll();
        map.put("emps", employees);
        return "emp/list";
    }

    @GetMapping("/emp")
    public String toAddEmp(Model model) {
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);
        return "emp/add";
    }

    @PostMapping("/emp")
    public String addEmp(Employee employee) {

        System.out.println(employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @GetMapping("/emp/{id}")
    public String updateEmp(@PathVariable("id") Integer id, Model model){
        Employee employee = employeeDao.get(id);
        Department department = employee.getDepartment();
        model.addAttribute("depts", department);
        model.addAttribute("emp", employee);
        return "emp/add";
    }
}

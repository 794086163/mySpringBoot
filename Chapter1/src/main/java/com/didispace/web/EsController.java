package com.didispace.web;

import com.didispace.es.entity.Employee;
import com.didispace.es.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by v-yangxu on 2019/7/15.
 */
@RestController
@RequestMapping("/es/")
public class EsController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("list")
    public List<Employee> list() {
        Employee user=new Employee();
        user.setId(11);
        user.setName("张三");
        user.setAge(11);
        employeeService.save(user);
        Iterable<Employee> iterable=employeeService.findAll();
        List<Employee> list=new ArrayList<>();
        iterable.forEach(employee -> {list.add(employee);});
        return list;
    }
}

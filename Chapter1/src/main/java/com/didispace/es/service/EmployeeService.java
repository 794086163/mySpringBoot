package com.didispace.es.service;

import com.didispace.es.entity.Employee;

/**
 * Created by v-yangxu on 2019/7/15.
 */
public interface EmployeeService {

    void save(Employee user);
    Iterable<Employee> findAll();
}

package com.didispace.es.service.impl;

import com.didispace.es.dao.EmployeeRespository;
import com.didispace.es.entity.Employee;
import com.didispace.es.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by v-yangxu on 2019/7/15.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRespository empRespository;

    @Override
    public void save(Employee employee) {
        empRespository.save(employee);
    }

    @Override
    public Iterable<Employee> findAll() {
        return empRespository.findAll();
    }
}

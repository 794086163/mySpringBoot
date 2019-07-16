package com.didispace.es.dao;

import com.didispace.es.entity.Employee;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

/**
 * Created by v-yangxu on 2019/7/15.
 */
@Component
public interface EmployeeRespository extends ElasticsearchRepository<Employee,Long>{

}

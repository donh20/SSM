package com.atguigu.ssm.service.impl;

import com.atguigu.ssm.service.EmployeeService;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private SqlSessionFactory sqlSessionFactory;
    
}

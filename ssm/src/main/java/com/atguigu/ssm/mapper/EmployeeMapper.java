package com.atguigu.ssm.mapper;


import com.atguigu.ssm.pojo.Employee;

import java.util.List;

public interface EmployeeMapper {

    /**
     * 查询所有的员工信息
     * @return
     */
    List<Employee> getAllEmployee();

    /**
     * 根据id删除员工*
     * @param id
     */
    void deleteEmployeeById(Integer id);

}

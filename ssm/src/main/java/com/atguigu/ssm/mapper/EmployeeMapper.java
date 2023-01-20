package com.atguigu.ssm.mapper;


import com.atguigu.ssm.pojo.Employee;
import org.apache.ibatis.annotations.Param;

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

    /**
     * 根据id获取员工信息*
     * @param id
     * @return
     */
    Employee getEmployeeById(Integer id);

    /**
     * 更新员工信息*
     * @param employee
     */
    void saveEmployee(@Param("employee") Employee employee);
}

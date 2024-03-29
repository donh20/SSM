package com.atguigu.ssm.service;

import com.atguigu.ssm.pojo.Employee;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface EmployeeService {
    /**
     * 查询所有的员工信息
     * @return
     */
    List<Employee> getAllEmployee();

    /**
     * 获取员工的分页信息
     * @param pageNum
     * @return
     */
    PageInfo<Employee> getEmployeePage(Integer pageNum);

    /**
     * 删除员工信息*
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
    void saveEmployee(Employee employee);
}

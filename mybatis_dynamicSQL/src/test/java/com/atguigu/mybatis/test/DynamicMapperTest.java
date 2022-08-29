package com.atguigu.mybatis.test;

import com.atguigu.mybatis.mapper.DynamicSQLMapper;
import com.atguigu.mybatis.pojo.Emp;
import com.atguigu.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class DynamicMapperTest {
    @Test
    public void testGetEmpByCondition(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
//        Emp emp1 = new Emp(null, "张三", 30, "男");
//        Emp emp2 = new Emp(null, "张三", 23, "男");
//        Emp emp3 = new Emp(null, "张三", 33, "男");
//        Emp emp4 = new Emp(null, "张三", 38, "男");
//        List<Emp> emps = Arrays.asList(emp1, emp2, emp3, emp4);
        Emp emp = new Emp(null, "张三", 30, "男");
        List<Emp> emps = mapper.getEmpByCondition(emp);
        emps.forEach(System.out::println);
    }

    @Test
    public void testGetEmpByChoose(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Emp emp = new Emp(null, "张三", 30, "男");
        List<Emp> emps = mapper.getEmpByChoose(emp);
        emps.forEach(System.out::println);

    }
}

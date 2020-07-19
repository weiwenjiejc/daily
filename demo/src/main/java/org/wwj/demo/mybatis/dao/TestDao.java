package org.wwj.demo.mybatis.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @Mapper
 * 1. 把接口交给spring容器管理
 * 2. 不用写mapper映射文件（xml)
 * 3. 为接口生成一个实现类
 * 注意事项
 * 1. 类方法有多个参数时，需要使用@Param修饰，单个参数时不需要
 */
@Mapper

public interface TestDao {

    @Select("select version()")
    String getVersion();
}

package edu.hue.springcloud.config;

import org.checkerframework.checker.units.qual.C;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author 47552
 * @date 2021/08/15
 */
@Configuration
@MapperScan({"edu.hue.springcloud.dao"})
public class MyBatisConfig {

}

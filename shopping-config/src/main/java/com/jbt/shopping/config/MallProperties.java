package com.jbt.shopping.config;

import com.destinyboy.jbt.config.mybatisplus.MybatisPlusProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = MallProperties.MYBATIS_PLUS_PREFIX)
public class MallProperties extends MybatisPlusProperties {
    public static final String MYBATIS_PLUS_PREFIX = "mybatis-plus-shopping-mall";
}

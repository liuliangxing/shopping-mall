package com.jbt.shopping.config;

import com.atomikos.jdbc.AtomikosDataSourceBean;
import com.destinyboy.jbt.config.mybatisplus.MybatisPlusConfiguration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableConfigurationProperties(value = {MallProperties.class})
@MapperScan(basePackages = "com.jbt.shopping.persistent.mappers.mall",sqlSessionFactoryRef="mallSqlSessionFactory",sqlSessionTemplateRef="mallSqlSessionTemplate")
public class MallConfig {
    Logger logger = LoggerFactory.getLogger(MallConfig.class);

    @Autowired
    private MybatisPlusConfiguration mybatisPlusConfiguration;
    @Autowired
    private MallProperties mallProperties;

    @Bean("shoppingMallProperties")
    @ConfigurationProperties(prefix="shopping-mall.datasource")
    public Properties getOAXaProperties(){
        return new Properties();
    }

    /**
     *
     * @author Destiny
     * @Description: 获取数据库
     * @time:2017年9月19日 下午6:59:06
     *
     * @param xaProperties
     * @return
     */
    @Bean(value="mallDataSource",initMethod = "init", destroyMethod = "close") // 声明其为Bean实例
    @ConfigurationProperties(prefix = "jta-shopping-mall.jta.atomikos.datasource")
    @Primary // 在同样的DataSource中，首先使用被标注的DataSource
    public DataSource dataSource(@Qualifier("shoppingMallProperties") Properties xaProperties) {
        AtomikosDataSourceBean atomikosDataSourceBean = new AtomikosDataSourceBean();
        logger.info("-------------------- DataSource init ------------------------");
        atomikosDataSourceBean.setUniqueResourceName("shopping_mall_datasource");
        atomikosDataSourceBean.setXaProperties(xaProperties);
        return atomikosDataSourceBean;
    }

    /**
     *
     * @author Destiny
     * @Description: 获取 SqlSessionFactory
     * @time:2017年9月19日 下午7:00:27
     *
     * @param dataSource
     * @return
     * @throws Exception
     */
    @Bean(name = "mallSqlSessionFactory")
    @Primary
    public SqlSessionFactory getSqlSessionFactory(@Qualifier("mallDataSource") DataSource dataSource)
            throws Exception {
        return mybatisPlusConfiguration.sqlSessionFactory(dataSource,mallProperties);
    }

    /**
     *
     * @author Destiny
     * @Description: 获取SqlSessionTemplate
     * @time:2017年9月19日 下午7:01:19
     *
     * @param sqlSessionFactory
     * @return
     * @throws Exception
     */
    @Bean(name = "mallSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate getSqlSessionTemplate(
            @Qualifier("mallSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}

package com.jbt.shopping.persistent.generator;

import com.destinyboy.jbt.utils.generator.GeneratorCodeProperties;
import com.destinyboy.jbt.utils.generator.GeneratorCodeUtil;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * ClassName: MybatisGenerator <br/>
 * Description: Mybatis生成DAO MODEL MAPPER<br/>
 * Date: 2017年6月7日 下午4:52:53 <br/>
 * <hr/>
 * Modification History:(修改类时添加大概记录) <br/>
 * DATE           AUTHOR          VERSION          DISCRIPTION 				 <br/>
 * ------------------------------------------------------------------------- <br/>
 * 2017年6月7日        Destiny         1.0              初始创建<br/>
 *
 */
public class MybatisGeneratorEntity {

	public static void main(String[] args) throws Exception{
		GeneratorCodeProperties codeProperties = new GeneratorCodeProperties();
		Map<String,String> tableMap = new HashMap<>();
		tableMap.put("role",null);
		codeProperties.setJdbcDBName("jbt_shopping_mall")                                           // 数据库名
				.setConnectionIP("127.0.0.1")                                          // 连接IP地址
				.setConnectionPort("3306")                                             // 数据库端口
//				.setGenertorAll(Boolean.TRUE)                                          // 是否生成全部表
				.setTableMap(tableMap)                                                 // 表的Map key: 表名 value: 实体类名 (可以为NULL)
				.setPassword("1qaz2wsx")                                               // 数据库密码
				.setEntityPackage("com.jbt.shopping.persistent.entity.mall")                    // 生成实体类的包名
				.setMapperPackage("com.jbt.shopping.persistent.mappers.mall")                   // 生成Mapper 接口的 包名
				.setCache(Boolean.TRUE)                                                // 是否缓存
				.setMapperPluginServicePackage("com.jbt.shopping.base.service")                      // 要生成 基础服务的包名
				.setMapperPluginModuleName("shopping-base-service");                      // 要生成 基础服务的 模块名

		InputStream resourceAsStream = MybatisGeneratorEntity.class.getResourceAsStream("/generatorConfig.xml");
		GeneratorCodeUtil.generatorEntity(codeProperties,resourceAsStream);

	}
}

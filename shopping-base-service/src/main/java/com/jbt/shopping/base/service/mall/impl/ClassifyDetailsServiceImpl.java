package com.jbt.shopping.base.service.mall.impl;

import com.jbt.shopping.persistent.entity.mall.ClassifyDetails;
import com.jbt.shopping.persistent.mappers.mall.ClassifyDetailsMapper;
import com.jbt.shopping.base.service.mall.ClassifyDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 
 * ClassName:  ClassifyDetailsServiceImpl<br/>
 * Description: ClassifyDetailsServiceImpl Service Impl <br/>
 * Date: 2018-03-01 <br/>
 * <hr/>
 * Modification History: <br/>
 * DATE           AUTHOR          VERSION          DISCRIPTION 				 <br/>
 * ------------------------------------------------------------------------- <br/>
 * 2018-03-01        Destiny       1.0              INIT-CREATE<br/>
 *
 */
@Service
public class ClassifyDetailsServiceImpl extends  com.destinyboy.jbt.config.redis.RedisServiceImpl <ClassifyDetailsMapper, ClassifyDetails> implements ClassifyDetailsService {

	@Autowired
	private  ClassifyDetailsMapper classifyDetailsMapper;
	
	public ClassifyDetailsMapper getClassifyDetailsMapper(){
		return classifyDetailsMapper;
	}
}

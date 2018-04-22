package com.jbt.shopping.base.service.mall.impl;

import com.jbt.shopping.persistent.entity.mall.MyCollection;
import com.jbt.shopping.persistent.mappers.mall.MyCollectionMapper;
import com.jbt.shopping.base.service.mall.MyCollectionService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 
 * ClassName:  MyCollectionServiceImpl<br/>
 * Description: MyCollectionServiceImpl Service Impl <br/>
 * Date: 2018-03-21 <br/>
 * <hr/>
 * Modification History: <br/>
 * DATE           AUTHOR          VERSION          DISCRIPTION 				 <br/>
 * ------------------------------------------------------------------------- <br/>
 * 2018-03-21        Destiny       1.0              INIT-CREATE<br/>
 *
 */
@Service
public class MyCollectionServiceImpl extends  com.destinyboy.jbt.config.redis.RedisServiceImpl <MyCollectionMapper, MyCollection> implements MyCollectionService {

	@Autowired
	private  MyCollectionMapper myCollectionMapper;
	
	public MyCollectionMapper getMyCollectionMapper(){
		return myCollectionMapper;
	}
}

package com.jbt.shopping.base.service.mall.impl;

import com.jbt.shopping.persistent.entity.mall.Supplier;
import com.jbt.shopping.persistent.mappers.mall.SupplierMapper;
import com.jbt.shopping.base.service.mall.SupplierService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 
 * ClassName:  SupplierServiceImpl<br/>
 * Description: SupplierServiceImpl Service Impl <br/>
 * Date: 2018-03-01 <br/>
 * <hr/>
 * Modification History: <br/>
 * DATE           AUTHOR          VERSION          DISCRIPTION 				 <br/>
 * ------------------------------------------------------------------------- <br/>
 * 2018-03-01        Destiny       1.0              INIT-CREATE<br/>
 *
 */
@Service
public class SupplierServiceImpl extends  com.destinyboy.jbt.config.redis.RedisServiceImpl <SupplierMapper, Supplier> implements SupplierService {

	@Autowired
	private  SupplierMapper supplierMapper;
	
	public SupplierMapper getSupplierMapper(){
		return supplierMapper;
	}
}

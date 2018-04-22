package com.jbt.shopping.biz.service.platform.supplier.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.destinyboy.jbt.utils.code.CodeUtil;
import com.jbt.shopping.biz.domain.platform.supplier.query.PlatformSupplierServiceQuery;
import com.jbt.shopping.biz.service.platform.supplier.PlatformSupplierService;
import com.jbt.shopping.base.service.FacadeService;
import com.jbt.shopping.common.constants.Constants;
import com.jbt.shopping.persistent.entity.mall.Supplier;
import com.xiaoleilu.hutool.util.BeanUtil;
import org.springframework.stereotype.Service;

/**
 * 
 * ClassName:  PlatformSupplierServiceImpl<br/>
 * Description: PlatformSupplierServiceImpl Service Impl <br/>
 * Date: 2018-03-06 <br/>
 * <hr/>
 * Modification History: <br/>
 * DATE           AUTHOR          VERSION          DISCRIPTION 				 <br/>
 * ------------------------------------------------------------------------- <br/>
 * 2018-03-06        Destiny       1.0              INIT-CREATE<br/>
 *
 */
@Service
public class PlatformSupplierServiceImpl extends FacadeService implements PlatformSupplierService {

    public void getSupplierList () {
        Wrapper<Supplier> entityWapper = new EntityWrapper<>();
        entityWapper.eq("enabled", Constants.GLOBAL_ENABLE_NORMAL);
        CodeUtil.handlerDBCodeOptional(this.getSupplierService():: selectList, entityWapper);
    }

    /**
     * 编辑供货商
     * @param query
     */
    public void editSupplier(PlatformSupplierServiceQuery query) {
        Supplier entity = new Supplier();
        BeanUtil.copyProperties(query, entity);
        CodeUtil.handlerDBCodeOptional(this.getSupplierService():: updateById, entity);
    }

    /**
     * 删除供货商
     * @param query
     */
    public void deleteSupplier (PlatformSupplierServiceQuery query) {
        Supplier entity = new Supplier();
        entity.setId(query.getId());
        entity.setEnabled(Constants.GLOBAL_ENABLE_DISABLE);
        CodeUtil.handlerDBCodeBasic(this.getSupplierService():: updateById, entity);
    }
}

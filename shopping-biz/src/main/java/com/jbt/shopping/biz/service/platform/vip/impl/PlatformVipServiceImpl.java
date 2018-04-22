package com.jbt.shopping.biz.service.platform.vip.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.destinyboy.jbt.utils.code.CodeUtil;
import com.jbt.shopping.biz.domain.platform.vip.query.PlatformVipServiceQuery;
import com.jbt.shopping.biz.service.platform.vip.PlatformVipService;
import com.jbt.shopping.base.service.FacadeService;
import com.jbt.shopping.common.constants.Constants;
import com.jbt.shopping.persistent.entity.mall.Vip;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 
 * ClassName:  PlatformVipServiceImpl<br/>
 * Description: PlatformVipServiceImpl Service Impl <br/>
 * Date: 2018-03-02 <br/>
 * <hr/>
 * Modification History: <br/>
 * DATE           AUTHOR          VERSION          DISCRIPTION 				 <br/>
 * ------------------------------------------------------------------------- <br/>
 * 2018-03-02        Destiny       1.0              INIT-CREATE<br/>
 *
 */
@Service
public class PlatformVipServiceImpl extends FacadeService implements PlatformVipService {
    /**
     * 获取Vip列表
     * @return
     */
    public List<Vip> getVipList () throws Exception{
        List<Vip> vips = CodeUtil.handlerDBCodeOptional(this.getVipService()::selectList, new EntityWrapper<>()).get();
        return vips;
    }

    /**
     * 编辑Vip列表
     * @param query
     */
    public void editVip (PlatformVipServiceQuery query)throws Exception {
        Vip entity = new Vip();
        entity.setId(query.getId());
        CodeUtil.handlerDBCodeBasic(this.getVipService()::updateById, entity);
    }

    /**
     * 保存Vip列表
     * @param query
     */
    public void saveVip (PlatformVipServiceQuery query)throws Exception {
        Vip entity = new Vip();
        BeanUtils.copyProperties(query, entity);
        CodeUtil.handlerDBCodeBasic(this.getVipService()::insert, entity);
    }

    /**
     * 删除Vip
     * @param query
     */
    public void deleteVip (PlatformVipServiceQuery query) throws Exception{
        Vip entity = new Vip();
        entity.setId(query.getId());
        entity.setEnabled(Constants.GLOBAL_ENABLE_DISABLE);
        CodeUtil.handlerDBCodeBasic(this.getVipService()::updateById, entity);
    }
}

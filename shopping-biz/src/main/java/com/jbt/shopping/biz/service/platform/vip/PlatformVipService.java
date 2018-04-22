package com.jbt.shopping.biz.service.platform.vip;

import com.jbt.shopping.biz.domain.platform.vip.query.PlatformVipServiceQuery;
import com.jbt.shopping.persistent.entity.mall.Vip;

import java.util.List;

/**
 * 
 * ClassName:  PlatformVipService<br/>
 * Description: PlatformVipService Service <br/>
 * Date: 2018-03-02 <br/>
 * <hr/>
 * Modification History: <br/>
 * DATE           AUTHOR          VERSION          DISCRIPTION 				 <br/>
 * ------------------------------------------------------------------------- <br/>
 * 2018-03-02        Destiny       1.0              INIT-CREATE<br/>
 *
 */
public interface PlatformVipService{
    /**
     * 获取Vip列表
     * @return
     */
    public List<Vip> getVipList () throws Exception;

    /**
     * 编辑Vip列表
     * @param query
     */
    public void editVip (PlatformVipServiceQuery query)throws Exception;

    /**
     * 保存Vip列表
     * @param query
     */
    public void saveVip (PlatformVipServiceQuery query)throws Exception;

    /**
     * 删除Vip
     * @param query
     */
    public void deleteVip (PlatformVipServiceQuery query) throws Exception;
}

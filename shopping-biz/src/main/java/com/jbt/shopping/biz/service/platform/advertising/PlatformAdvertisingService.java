package com.jbt.shopping.biz.service.platform.advertising;

import com.jbt.shopping.biz.domain.platform.advertising.query.PlatformAdvertisingServiceQuery;
import com.jbt.shopping.persistent.entity.mall.AdvertisingPosition;

import java.util.List;

/**
 * 
 * ClassName:  PlatformAdvertisingService<br/>
 * Description: PlatformAdvertisingService Service <br/>
 * Date: 2018-03-01 <br/>
 * <hr/>
 * Modification History: <br/>
 * DATE           AUTHOR          VERSION          DISCRIPTION 				 <br/>
 * ------------------------------------------------------------------------- <br/>
 * 2018-03-01        Destiny       1.0              INIT-CREATE<br/>
 *
 */
public interface PlatformAdvertisingService{

    /**
     * 查询广告位
     * @param query
     * @return
     */
    public List<AdvertisingPosition> getAdList (PlatformAdvertisingServiceQuery query) throws Exception;

    /**
     * 启用、禁用 广告位
     * @param query
     */
    public void enabledAd (PlatformAdvertisingServiceQuery query) throws Exception;

    /**
     * 获取广告位
     * @param query
     * @return
     */
    public AdvertisingPosition getAdInfo (PlatformAdvertisingServiceQuery query) throws Exception;

    /**
     * 保存广告位
     * @param query
     */
    public void saveAdInfo (PlatformAdvertisingServiceQuery query) throws Exception;

    /**
     * 编辑广告位
     * @param query
     */
    public void editAdInfo (PlatformAdvertisingServiceQuery query) throws Exception;

    /**
     * 排序广告位
     */
    public void sortAd (PlatformAdvertisingServiceQuery query) throws Exception;
}

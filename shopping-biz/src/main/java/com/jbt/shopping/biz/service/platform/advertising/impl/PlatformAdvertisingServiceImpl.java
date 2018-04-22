package com.jbt.shopping.biz.service.platform.advertising.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.destinyboy.jbt.utils.code.CodeUtil;
import com.jbt.shopping.biz.domain.platform.advertising.query.PlatformAdvertisingServiceQuery;
import com.jbt.shopping.biz.service.platform.advertising.PlatformAdvertisingService;
import com.jbt.shopping.base.service.FacadeService;
import com.jbt.shopping.common.constants.Constants;
import com.jbt.shopping.common.exceptions.BusinessCodeConfig;
import com.jbt.shopping.common.exceptions.BusinessException;
import com.jbt.shopping.persistent.entity.mall.AdvertisingPosition;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 
 * ClassName:  PlatformAdvertisingServiceImpl<br/>
 * Description: PlatformAdvertisingServiceImpl Service Impl <br/>
 * Date: 2018-03-01 <br/>
 * <hr/>
 * Modification History: <br/>
 * DATE           AUTHOR          VERSION          DISCRIPTION 				 <br/>
 * ------------------------------------------------------------------------- <br/>
 * 2018-03-01        Destiny       1.0              INIT-CREATE<br/>
 *
 */
@Service
public class PlatformAdvertisingServiceImpl extends FacadeService implements PlatformAdvertisingService {
    /**
     * 查询广告位
     * @param query
     * @return
     */
    public List<AdvertisingPosition> getAdList (PlatformAdvertisingServiceQuery query) throws Exception{
        AdvertisingPosition advertisingPosition = new AdvertisingPosition();
        advertisingPosition.setEnabled(Constants.GLOBAL_ENABLE_NORMAL);
        EntityWrapper<AdvertisingPosition> getListWrapper = new EntityWrapper<>(advertisingPosition);
        getListWrapper.eq(query.getEnabled() != null,"enabled", query.getEnabled());
        getListWrapper.like(query.getName() != null,"name", query.getName());
        getListWrapper.eq(query.getType() != null,"type", query.getType());
        getListWrapper.eq(query.getPosition() != null,"position", query.getPosition());
        getListWrapper.and(query.getStartTime() != null,"create_time >= {0}", query.getStartTime());
        getListWrapper.and(query.getEndTime() != null,"create_time <= {0}", query.getEndTime());

        // 查询所有广告位
        List<AdvertisingPosition> advertisingPositions = CodeUtil.handlerDBCodeOptional(this.getAdvertisingPositionService()::selectList, getListWrapper).get();
        return advertisingPositions;
    }

    /**
     * 启用、禁用 广告位
     * @param query
     */
    public void enabledAd (PlatformAdvertisingServiceQuery query) throws Exception{
        AdvertisingPosition entity = new AdvertisingPosition();
        entity.setId(query.getId());
        entity.setEnabled(query.getEnabled());
        CodeUtil.handlerDBCodeOptional(this.getAdvertisingPositionService()::updateById,entity);
    }

    /**
     * 获取广告位
     * @param query
     * @return
     */
    public AdvertisingPosition getAdInfo (PlatformAdvertisingServiceQuery query) throws Exception{
        AdvertisingPosition advertisingPosition = new AdvertisingPosition();
        advertisingPosition.setId(query.getId());
        // 根据ID 获取广告位
        advertisingPosition = CodeUtil.handlerDBCodeOptional(this.getAdvertisingPositionService()::selectOne, new EntityWrapper<>())//
                .orElseThrow(() -> new BusinessException(BusinessCodeConfig.BE_ERROR_1005));
        return advertisingPosition;
    }

    /**
     * 保存广告位
     * @param query
     */
    public void saveAdInfo (PlatformAdvertisingServiceQuery query) throws Exception{
        AdvertisingPosition advertisingPosition = new AdvertisingPosition();
        BeanUtils.copyProperties(query, advertisingPosition);
        CodeUtil.handlerDBCodeBasic(this.getAdvertisingPositionService():: insert, advertisingPosition);
    }

    /**
     * 编辑广告位
     * @param query
     */
    public void editAdInfo (PlatformAdvertisingServiceQuery query) throws Exception{
        AdvertisingPosition advertisingPosition = new AdvertisingPosition();
        BeanUtils.copyProperties(query, advertisingPosition);
        CodeUtil.handlerDBCodeBasic(this.getAdvertisingPositionService()::updateById, advertisingPosition);
    }

    /**
     * 排序广告位
     */
    public void sortAd (PlatformAdvertisingServiceQuery query) throws Exception{
        Map<Integer, Integer> sortIds = query.getSortIds();
        List<AdvertisingPosition> advertisingPositions = new ArrayList<>();
        for (Map.Entry<Integer,Integer> entry :sortIds.entrySet()) {
            AdvertisingPosition advertisingPosition = new AdvertisingPosition();
            advertisingPosition.setId(entry.getKey());
            advertisingPosition.setSort(entry.getValue());
            advertisingPositions.add(advertisingPosition);
        }
        CodeUtil.handlerDBCodeBasic(this.getAdvertisingPositionService():: updateBatchById, advertisingPositions);
    }



}

package com.jbt.shopping.biz.service.platform.collection.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.destinyboy.jbt.utils.code.CodeUtil;
import com.jbt.shopping.base.service.FacadeService;
import com.jbt.shopping.biz.domain.platform.collection.query.PlatformCollectionServiceQuery;
import com.jbt.shopping.biz.domain.platform.collection.vo.GetCollectionListVo;
import com.jbt.shopping.biz.service.platform.collection.PlatformCollectionService;
import com.jbt.shopping.common.constants.Constants;
import com.jbt.shopping.persistent.entity.mall.Goods;
import com.jbt.shopping.persistent.entity.mall.MyCollection;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 
 * ClassName:  PlatformCollectionServiceImpl<br/>
 * Description: PlatformCollectionServiceImpl Service Impl <br/>
 * Date: 2018-03-11 <br/>
 * <hr/>
 * Modification History: <br/>
 * DATE           AUTHOR          VERSION          DISCRIPTION 				 <br/>
 * ------------------------------------------------------------------------- <br/>
 * 2018-03-11        Destiny       1.0              INIT-CREATE<br/>
 *
 */
@Service
public class PlatformCollectionServiceImpl extends FacadeService implements PlatformCollectionService {

    /**
     * 查询用户的所有收藏
     * @param query
     * @return
     */
    public List<GetCollectionListVo> getCollectionList (PlatformCollectionServiceQuery query) throws Exception {
        // 查询收藏列表
        MyCollection collection = new MyCollection();
        collection.setUserId(query.getUserId());
        collection.setEnabled(Constants.GLOBAL_ENABLE_NORMAL);
        List<MyCollection> collections = CodeUtil.handlerDBCodeOptional(this.getMyCollectionService()::selectList, new EntityWrapper<>(collection)).get();
        if (collections == null || collections.isEmpty()) {
            return Collections.emptyList();
        }
        // 获取收藏商品ID
        List<Integer> goodsIds = collections.stream().map(MyCollection::getGoodsId).collect(Collectors.toList());
        List<Goods> goodsList = CodeUtil.handlerDBCodeOptional(this.getGoodsService()::selectBatchIds, goodsIds).get();
        if (goodsList == null || goodsList.isEmpty()) {
            return Collections.emptyList();
        }
        Map<Integer, List<Goods>> goodsMap = goodsList.stream().collect(Collectors.groupingBy(Goods::getId));
        List<GetCollectionListVo> collectionList = new ArrayList<>();
        for(MyCollection coll: collections) {
            GetCollectionListVo vo = new GetCollectionListVo();
            vo.setGoodsId(coll.getGoodsId());
            Goods goodsTemp = goodsMap.get(coll.getGoodsId()).get(0);
            vo.setGoodsNum(goodsTemp.getGoodsNum());
            vo.setGoodsName(goodsTemp.getGoodsName());
            vo.setMaxPrice(goodsTemp.getMaxPrice());
            vo.setMinPrice(goodsTemp.getMinPrice());
            vo.setThumbnailPicture(goodsTemp.getThumbnailPicture());
            collectionList.add(vo);
        }
        return collectionList;
    }

    /**
     * 添加收藏
     * @param query
     */
    public void addCollection (PlatformCollectionServiceQuery query) throws Exception{
        MyCollection entity = new MyCollection();
        BeanUtils.copyProperties(query, entity);
        // 添加收藏
        CodeUtil.handlerDBCodeBasic(this.getMyCollectionService():: insert, entity);
    }

    /**
     * 删除收藏
     * @param query
     */
    public void removeCollection (PlatformCollectionServiceQuery query)throws Exception {
        MyCollection entity = new MyCollection();
        entity.setId(query.getId());
        entity.setEnabled(Constants.GLOBAL_ENABLE_DISABLE);
        CodeUtil.handlerDBCodeBasic(this.getMyCollectionService():: updateById, entity);
    }
}

package com.jbt.shopping.biz.service.platform.collection;

import com.jbt.shopping.biz.domain.platform.collection.query.PlatformCollectionServiceQuery;
import com.jbt.shopping.biz.domain.platform.collection.vo.GetCollectionListVo;

import java.util.List;

/**
 * 
 * ClassName:  PlatformCollectionService<br/>
 * Description: PlatformCollectionService Service <br/>
 * Date: 2018-03-11 <br/>
 * <hr/>
 * Modification History: <br/>
 * DATE           AUTHOR          VERSION          DISCRIPTION 				 <br/>
 * ------------------------------------------------------------------------- <br/>
 * 2018-03-11        Destiny       1.0              INIT-CREATE<br/>
 *
 */
public interface PlatformCollectionService{

    /**
     * 查询用户的所有收藏
     * @param query
     * @return
     */
    public List<GetCollectionListVo> getCollectionList (PlatformCollectionServiceQuery query) throws Exception;

    /**
     * 添加收藏
     * @param query
     */
    public void addCollection (PlatformCollectionServiceQuery query) throws Exception;

    /**
     * 删除收藏
     * @param query
     */
    public void removeCollection (PlatformCollectionServiceQuery query)throws Exception;



}

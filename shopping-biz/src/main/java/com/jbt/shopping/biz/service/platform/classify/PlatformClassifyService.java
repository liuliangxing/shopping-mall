package com.jbt.shopping.biz.service.platform.classify;

import com.jbt.shopping.biz.domain.platform.classify.query.PlatformClassifyServiceQuery;
import com.jbt.shopping.biz.domain.platform.classify.vo.GetGoodsClassifyListVo;
import com.jbt.shopping.persistent.entity.mall.GoodsClassify;

import java.util.List;

/**
 * 
 * ClassName:  PlatformClassifyService<br/>
 * Description: PlatformClassifyService Service <br/>
 * Date: 2018-03-02 <br/>
 * <hr/>
 * Modification History: <br/>
 * DATE           AUTHOR          VERSION          DISCRIPTION 				 <br/>
 * ------------------------------------------------------------------------- <br/>
 * 2018-03-02        Destiny       1.0              INIT-CREATE<br/>
 *
 */
public interface PlatformClassifyService{
    /**
     * 查询类别列表
     * @return
     */
    public List<GetGoodsClassifyListVo> getGoodsClassifyList () throws Exception;

    /**
     * 保存类目
     * @param query
     */
    public void saveGoodsClassify (PlatformClassifyServiceQuery query) throws Exception;

    /**
     * 编辑类目
     * @param query
     */
    public void editGoodsClassify (PlatformClassifyServiceQuery query) throws Exception;

    /**
     * 删除类目
     * @param query
     */
    public void deleteGoodsClassify (PlatformClassifyServiceQuery query) throws Exception;

    /**
     *  排序列表
     */
    public void sortGoodsClassify (PlatformClassifyServiceQuery query) throws Exception;

    /**
     * 获取子节点
     * @param query
     */
    public List<GoodsClassify> getChildList (PlatformClassifyServiceQuery query) throws Exception;
}

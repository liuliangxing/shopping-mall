package com.jbt.shopping.biz.service.platform.classify.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.destinyboy.jbt.utils.code.CodeUtil;
import com.jbt.shopping.biz.domain.platform.classify.query.PlatformClassifyServiceQuery;
import com.jbt.shopping.biz.domain.platform.classify.vo.GetGoodsClassifyListVo;
import com.jbt.shopping.biz.service.platform.classify.PlatformClassifyService;
import com.jbt.shopping.base.service.FacadeService;
import com.jbt.shopping.common.constants.Constants;
import com.jbt.shopping.persistent.entity.mall.GoodsClassify;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 
 * ClassName:  PlatformClassifyServiceImpl<br/>
 * Description: PlatformClassifyServiceImpl Service Impl <br/>
 * Date: 2018-03-02 <br/>
 * <hr/>
 * Modification History: <br/>
 * DATE           AUTHOR          VERSION          DISCRIPTION 				 <br/>
 * ------------------------------------------------------------------------- <br/>
 * 2018-03-02        Destiny       1.0              INIT-CREATE<br/>
 *
 */
@Service
public class PlatformClassifyServiceImpl extends FacadeService implements PlatformClassifyService {

    /**
     * 查询类别列表
     * @return
     */
    public List<GetGoodsClassifyListVo> getGoodsClassifyList () throws Exception{
        GoodsClassify goodsClassify = new GoodsClassify();
        goodsClassify.setEnabled(Constants.GLOBAL_ENABLE_NORMAL);
        List<GoodsClassify> goodsClassifies = CodeUtil.handlerDBCodeOptional(this.getGoodsClassifyService()::selectList, new EntityWrapper<>(goodsClassify)).get();
        List<GetGoodsClassifyListVo> vos = new ArrayList<>();
        this.recursionGoodsClassifyList(goodsClassifies, 0, vos);
        return vos;

    }

    private void recursionGoodsClassifyList (List<GoodsClassify> goodsClassifies, int pid, List<GetGoodsClassifyListVo> vos) {
        for (GoodsClassify classify:goodsClassifies) {
            if (classify.getPid().equals(pid)) {
                GetGoodsClassifyListVo vo = new GetGoodsClassifyListVo();
                vo.setId(classify.getId());
                vo.setClassifyName(classify.getClassifyName());
                vo.setClassifyPng(classify.getClassifyPng());
                vo.setSeq(vo.getSeq());
                vos.add(vo);
                this.recursionGoodsClassifyList(goodsClassifies, vo.getId(), vo.getChildClassifyList());
            }
        }
    }

    /**
     * 保存类目
     * @param query
     */
    public void saveGoodsClassify (PlatformClassifyServiceQuery query) throws Exception{
        GoodsClassify entity = new GoodsClassify();
        BeanUtils.copyProperties(query, entity);
        CodeUtil.handlerDBCodeBasic(this.getGoodsClassifyService():: insert, entity);
    }


    /**
     * 编辑类目
     * @param query
     */
    public void editGoodsClassify (PlatformClassifyServiceQuery query) throws Exception{
        GoodsClassify entity = new GoodsClassify();
        BeanUtils.copyProperties(query, entity);
        CodeUtil.handlerDBCodeBasic(this.getGoodsClassifyService():: updateById, entity);
    }

    /**
     * 删除类目
     * @param query
     */
    public void deleteGoodsClassify (PlatformClassifyServiceQuery query) throws Exception{
        GoodsClassify entity = new GoodsClassify();
        entity.setEnabled(Constants.GLOBAL_ENABLE_NORMAL);
        List<GoodsClassify> goodsClassifies = CodeUtil.handlerDBCodeOptional(this.getGoodsClassifyService()::selectList, new EntityWrapper<>()).get();

        List<GoodsClassify> list = new ArrayList<GoodsClassify>();
        GoodsClassify goodsClassify = new GoodsClassify();
        goodsClassify.setId(query.getId());
        goodsClassify.setEnabled(Constants.GLOBAL_ENABLE_DISABLE);
        list.add(goodsClassify);
        recursionGoodsClassifyId(goodsClassifies, query.getId(), list);

        CodeUtil.handlerDBCodeBasic(this.getGoodsClassifyService():: updateBatchById, list);
    }

    private void recursionGoodsClassifyId (List<GoodsClassify> goodsClassifies, int id, List<GoodsClassify> list) {
        for (GoodsClassify classify:goodsClassifies) {
            if (classify.getPid().equals(id)) {
                GoodsClassify goodsClassify = new GoodsClassify();
                goodsClassify.setEnabled(Constants.GLOBAL_ENABLE_DISABLE);
                goodsClassify.setId(classify.getId());
                list.add(goodsClassify);
                this.recursionGoodsClassifyId(goodsClassifies, classify.getId(), list);
            }
        }
    }

    /**
     * 获取子节点
     * @param query
     */
    public List<GoodsClassify> getChildList (PlatformClassifyServiceQuery query) throws Exception{
        GoodsClassify entity = new GoodsClassify();
        entity.setEnabled(Constants.GLOBAL_ENABLE_NORMAL);
        List<GoodsClassify> goodsClassifies = CodeUtil.handlerDBCodeOptional(this.getGoodsClassifyService()::selectList, new EntityWrapper<>()).get();

        GoodsClassify goodsClassify = CodeUtil.handlerDBCodeOptional(this.getGoodsClassifyService()::selectById, query.getId()).get();

        List<GoodsClassify> goodsClassifyList = new ArrayList<>();
        goodsClassifyList.add(goodsClassify);
        ecursionGoodsClassifyChild(goodsClassifies, query.getId(), goodsClassifyList);

        return goodsClassifyList;
    }

    private void ecursionGoodsClassifyChild (List<GoodsClassify> goodsClassifies, int id, List<GoodsClassify> list) {
        for (GoodsClassify classify:goodsClassifies) {
            if (classify.getPid().equals(id)) {
                list.add(classify);
                this.recursionGoodsClassifyId(goodsClassifies, classify.getId(), list);
            }
        }
    }

    /**
     *  排序列表
     */
    public void sortGoodsClassify (PlatformClassifyServiceQuery query) throws Exception {
        Map<Integer, Integer> sortIds = query.getSortMap();
        List<GoodsClassify> goodsClassifies = new ArrayList<>();
        for (Map.Entry<Integer,Integer> entry :sortIds.entrySet()) {
            GoodsClassify goodsClassify = new GoodsClassify();
            goodsClassify.setId(entry.getKey());
            goodsClassify.setSeq(entry.getValue());
            goodsClassifies.add(goodsClassify);
        }
        CodeUtil.handlerDBCodeBasic(this.getGoodsClassifyService():: updateBatchById, goodsClassifies);
    }
}

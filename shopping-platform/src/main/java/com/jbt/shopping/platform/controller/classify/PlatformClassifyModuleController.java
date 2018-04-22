package com.jbt.shopping.platform.controller.classify;

import com.jbt.shopping.biz.groups.platform.classify.GetChildListGroup; 
import com.jbt.shopping.biz.domain.platform.classify.query.PlatformClassifyServiceQuery; 
import com.jbt.shopping.biz.groups.platform.classify.DeleteGoodsClassifyGroup; 
import com.jbt.shopping.biz.groups.platform.classify.EditGoodsClassifyGroup; 
import com.jbt.shopping.biz.groups.platform.classify.SaveGoodsClassifyGroup; 
import com.jbt.shopping.biz.groups.platform.classify.SortGoodsClassifyGroup; 
import com.jbt.shopping.biz.service.platform.classify.PlatformClassifyService;
import java.util.Map;
import com.destinyboy.jbt.result.JsonResult;
import com.destinyboy.jbt.utils.result.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
/**
 * 
 * ClassName:  PlatformClassifyModuleController<br/>
 * Description: PlatformClassifyModuleController Controller <br/>
 * Date: 2018-03-02 <br/>
 * <hr/>
 * Modification History: <br/>
 * DATE           AUTHOR          VERSION          DISCRIPTION 				 <br/>
 * ------------------------------------------------------------------------- <br/>
 * 2018-03-02        Destiny       1.0              INIT-CREATE<br/>
 *
 */
@RestController
@RequestMapping("platformClassifyModule")
public class PlatformClassifyModuleController {

    @Autowired
    private PlatformClassifyService platformClassifyService;

    /**
     * 查询类别列表
     * @return
     */
   @RequestMapping(value=("getGoodsClassifyList.do"), method = RequestMethod.POST) 
   public JsonResult<Map<String, Object>> getGoodsClassifyList() throws Exception { 
       return ResultUtil.success(platformClassifyService.getGoodsClassifyList()); 
   }

    /**
     * 保存类目
     * @param query
     */
   @RequestMapping(value=("saveGoodsClassify.do"), method = RequestMethod.POST) 
   public JsonResult<Map<String, Object>> saveGoodsClassify(@Validated(value={SaveGoodsClassifyGroup.class}) @RequestBody PlatformClassifyServiceQuery query) throws Exception { 
       platformClassifyService.saveGoodsClassify(query); 
       return ResultUtil.success(); 
   }

    /**
     * 编辑类目
     * @param query
     */
   @RequestMapping(value=("editGoodsClassify.do"), method = RequestMethod.POST) 
   public JsonResult<Map<String, Object>> editGoodsClassify(@Validated(value={EditGoodsClassifyGroup.class}) @RequestBody PlatformClassifyServiceQuery query) throws Exception { 
       platformClassifyService.editGoodsClassify(query); 
       return ResultUtil.success(); 
   }

    /**
     * 删除类目
     * @param query
     */
   @RequestMapping(value=("deleteGoodsClassify.do"), method = RequestMethod.POST) 
   public JsonResult<Map<String, Object>> deleteGoodsClassify(@Validated(value={DeleteGoodsClassifyGroup.class}) @RequestBody PlatformClassifyServiceQuery query) throws Exception { 
       platformClassifyService.deleteGoodsClassify(query); 
       return ResultUtil.success(); 
   }

    /**
     *  排序列表
     */
   @RequestMapping(value=("sortGoodsClassify.do"), method = RequestMethod.POST) 
   public JsonResult<Map<String, Object>> sortGoodsClassify(@Validated(value={SortGoodsClassifyGroup.class}) @RequestBody PlatformClassifyServiceQuery query) throws Exception { 
       platformClassifyService.sortGoodsClassify(query); 
       return ResultUtil.success(); 
   }

    /**
     * 获取子节点
     * @param query
     */
   @RequestMapping(value=("getChildList.do"), method = RequestMethod.POST) 
   public JsonResult<Map<String, Object>> getChildList(@Validated(value={GetChildListGroup.class}) @RequestBody PlatformClassifyServiceQuery query) throws Exception { 
       return ResultUtil.success(platformClassifyService.getChildList(query)); 
   }
}

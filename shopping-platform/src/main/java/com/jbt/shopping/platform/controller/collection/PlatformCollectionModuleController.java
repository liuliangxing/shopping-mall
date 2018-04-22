package com.jbt.shopping.platform.controller.collection;

import com.jbt.shopping.biz.domain.platform.collection.query.PlatformCollectionServiceQuery; 
import com.jbt.shopping.biz.groups.platform.collection.RemoveCollectionGroup; 
import com.jbt.shopping.biz.groups.platform.collection.GetCollectionListGroup; 
import com.jbt.shopping.biz.groups.platform.collection.AddCollectionGroup; 
import com.jbt.shopping.biz.service.platform.collection.PlatformCollectionService;
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
 * ClassName:  PlatformCollectionModuleController<br/>
 * Description: PlatformCollectionModuleController Controller <br/>
 * Date: 2018-03-11 <br/>
 * <hr/>
 * Modification History: <br/>
 * DATE           AUTHOR          VERSION          DISCRIPTION 				 <br/>
 * ------------------------------------------------------------------------- <br/>
 * 2018-03-11        Destiny       1.0              INIT-CREATE<br/>
 *
 */
@RestController
@RequestMapping("platformCollectionModule")
public class PlatformCollectionModuleController {

    @Autowired
    private PlatformCollectionService platformCollectionService;

    /**
     * 查询用户的所有收藏
     * @param query
     * @return
     */
   @RequestMapping(value=("getCollectionList.do"), method = RequestMethod.POST) 
   public JsonResult<Map<String, Object>> getCollectionList(@Validated(value={GetCollectionListGroup.class}) @RequestBody PlatformCollectionServiceQuery query) throws Exception { 
       return ResultUtil.success(platformCollectionService.getCollectionList(query)); 
   }

    /**
     * 添加收藏
     * @param query
     */
   @RequestMapping(value=("addCollection.do"), method = RequestMethod.POST) 
   public JsonResult<Map<String, Object>> addCollection(@Validated(value={AddCollectionGroup.class}) @RequestBody PlatformCollectionServiceQuery query) throws Exception { 
       platformCollectionService.addCollection(query); 
       return ResultUtil.success(); 
   }

    /**
     * 删除收藏
     * @param query
     */
   @RequestMapping(value=("removeCollection.do"), method = RequestMethod.POST) 
   public JsonResult<Map<String, Object>> removeCollection(@Validated(value={RemoveCollectionGroup.class}) @RequestBody PlatformCollectionServiceQuery query) throws Exception { 
       platformCollectionService.removeCollection(query); 
       return ResultUtil.success(); 
   }
}

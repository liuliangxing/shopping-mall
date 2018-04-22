package com.jbt.shopping.platform.controller.advertising;

import com.jbt.shopping.biz.domain.platform.advertising.query.PlatformAdvertisingServiceQuery; 
import com.jbt.shopping.biz.groups.platform.advertising.SortAdGroup; 
import com.jbt.shopping.biz.groups.platform.advertising.EditAdInfoGroup; 
import com.jbt.shopping.biz.groups.platform.advertising.GetAdListGroup; 
import com.jbt.shopping.biz.groups.platform.advertising.GetAdInfoGroup; 
import com.jbt.shopping.biz.groups.platform.advertising.SaveAdInfoGroup; 
import com.jbt.shopping.biz.groups.platform.advertising.EnabledAdGroup; 
import com.jbt.shopping.biz.service.platform.advertising.PlatformAdvertisingService;
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
 * ClassName:  PlatformAdvertisingModuleController<br/>
 * Description: PlatformAdvertisingModuleController Controller <br/>
 * Date: 2018-03-01 <br/>
 * <hr/>
 * Modification History: <br/>
 * DATE           AUTHOR          VERSION          DISCRIPTION 				 <br/>
 * ------------------------------------------------------------------------- <br/>
 * 2018-03-01        Destiny       1.0              INIT-CREATE<br/>
 *
 */
@RestController
@RequestMapping("platformAdvertisingModule")
public class PlatformAdvertisingModuleController {

    @Autowired
    private PlatformAdvertisingService platformAdvertisingService;

    /**
     * 查询广告位
     * @param query
     * @return
     */
   @RequestMapping(value=("getAdList.do"), method = RequestMethod.POST) 
   public JsonResult<Map<String, Object>> getAdList(@Validated(value={GetAdListGroup.class}) @RequestBody PlatformAdvertisingServiceQuery query) throws Exception { 
       return ResultUtil.success(platformAdvertisingService.getAdList(query)); 
   }

    /**
     * 启用、禁用 广告位
     * @param query
     */
   @RequestMapping(value=("enabledAd.do"), method = RequestMethod.POST) 
   public JsonResult<Map<String, Object>> enabledAd(@Validated(value={EnabledAdGroup.class}) @RequestBody PlatformAdvertisingServiceQuery query) throws Exception { 
       platformAdvertisingService.enabledAd(query); 
       return ResultUtil.success(); 
   }

    /**
     * 获取广告位
     * @param query
     * @return
     */
   @RequestMapping(value=("getAdInfo.do"), method = RequestMethod.POST) 
   public JsonResult<Map<String, Object>> getAdInfo(@Validated(value={GetAdInfoGroup.class}) @RequestBody PlatformAdvertisingServiceQuery query) throws Exception { 
       return ResultUtil.success(platformAdvertisingService.getAdInfo(query)); 
   }

    /**
     * 保存广告位
     * @param query
     */
   @RequestMapping(value=("saveAdInfo.do"), method = RequestMethod.POST) 
   public JsonResult<Map<String, Object>> saveAdInfo(@Validated(value={SaveAdInfoGroup.class}) @RequestBody PlatformAdvertisingServiceQuery query) throws Exception { 
       platformAdvertisingService.saveAdInfo(query); 
       return ResultUtil.success(); 
   }

    /**
     * 编辑广告位
     * @param query
     */
   @RequestMapping(value=("editAdInfo.do"), method = RequestMethod.POST) 
   public JsonResult<Map<String, Object>> editAdInfo(@Validated(value={EditAdInfoGroup.class}) @RequestBody PlatformAdvertisingServiceQuery query) throws Exception { 
       platformAdvertisingService.editAdInfo(query); 
       return ResultUtil.success(); 
   }

    /**
     * 排序广告位
     */
   @RequestMapping(value=("sortAd.do"), method = RequestMethod.POST) 
   public JsonResult<Map<String, Object>> sortAd(@Validated(value={SortAdGroup.class}) @RequestBody PlatformAdvertisingServiceQuery query) throws Exception { 
       platformAdvertisingService.sortAd(query); 
       return ResultUtil.success(); 
   }
}

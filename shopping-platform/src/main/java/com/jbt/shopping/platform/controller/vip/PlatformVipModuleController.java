package com.jbt.shopping.platform.controller.vip;

import com.jbt.shopping.biz.domain.platform.vip.query.PlatformVipServiceQuery; 
import com.jbt.shopping.biz.groups.platform.vip.SaveVipGroup; 
import com.jbt.shopping.biz.groups.platform.vip.EditVipGroup; 
import com.jbt.shopping.biz.groups.platform.vip.DeleteVipGroup; 
import com.jbt.shopping.biz.service.platform.vip.PlatformVipService;
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
 * ClassName:  PlatformVipModuleController<br/>
 * Description: PlatformVipModuleController Controller <br/>
 * Date: 2018-03-02 <br/>
 * <hr/>
 * Modification History: <br/>
 * DATE           AUTHOR          VERSION          DISCRIPTION 				 <br/>
 * ------------------------------------------------------------------------- <br/>
 * 2018-03-02        Destiny       1.0              INIT-CREATE<br/>
 *
 */
@RestController
@RequestMapping("platformVipModule")
public class PlatformVipModuleController {

    @Autowired
    private PlatformVipService platformVipService;

    /**
     * 获取Vip列表
     * @return
     */
   @RequestMapping(value=("getVipList.do"), method = RequestMethod.POST) 
   public JsonResult<Map<String, Object>> getVipList() throws Exception { 
       return ResultUtil.success(platformVipService.getVipList()); 
   }

    /**
     * 编辑Vip列表
     * @param query
     */
   @RequestMapping(value=("editVip.do"), method = RequestMethod.POST) 
   public JsonResult<Map<String, Object>> editVip(@Validated(value={EditVipGroup.class}) @RequestBody PlatformVipServiceQuery query) throws Exception { 
       platformVipService.editVip(query); 
       return ResultUtil.success(); 
   }

    /**
     * 保存Vip列表
     * @param query
     */
   @RequestMapping(value=("saveVip.do"), method = RequestMethod.POST) 
   public JsonResult<Map<String, Object>> saveVip(@Validated(value={SaveVipGroup.class}) @RequestBody PlatformVipServiceQuery query) throws Exception { 
       platformVipService.saveVip(query); 
       return ResultUtil.success(); 
   }

    /**
     * 删除Vip
     * @param query
     */
   @RequestMapping(value=("deleteVip.do"), method = RequestMethod.POST) 
   public JsonResult<Map<String, Object>> deleteVip(@Validated(value={DeleteVipGroup.class}) @RequestBody PlatformVipServiceQuery query) throws Exception { 
       platformVipService.deleteVip(query); 
       return ResultUtil.success(); 
   }
}

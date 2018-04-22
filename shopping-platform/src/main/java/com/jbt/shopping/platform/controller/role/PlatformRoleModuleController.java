package com.jbt.shopping.platform.controller.role;

import com.jbt.shopping.biz.domain.platform.role.query.PlatformRoleServiceQuery; 
import com.jbt.shopping.biz.groups.platform.role.EditRoleGroup; 
import com.jbt.shopping.biz.groups.platform.role.AddRoleGroup; 
import com.jbt.shopping.biz.groups.platform.role.GetRoleByUserIdGroup; 
import com.jbt.shopping.biz.groups.platform.role.GetRoleListGroup; 
import com.jbt.shopping.biz.service.platform.role.PlatformRoleService;
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
 * ClassName:  PlatformRoleModuleController<br/>
 * Description: PlatformRoleModuleController Controller <br/>
 * Date: 2018-03-29 <br/>
 * <hr/>
 * Modification History: <br/>
 * DATE           AUTHOR          VERSION          DISCRIPTION 				 <br/>
 * ------------------------------------------------------------------------- <br/>
 * 2018-03-29        Destiny       1.0              INIT-CREATE<br/>
 *
 */
@RestController
@RequestMapping("platformRoleModule")
public class PlatformRoleModuleController {

    @Autowired
    private PlatformRoleService platformRoleService;

    /**
     * 查询所有角色
     * @param query
     */
   @RequestMapping(value=("getRoleList.do"), method = RequestMethod.POST) 
   public JsonResult<Map<String, Object>> getRoleList(@Validated(value={GetRoleListGroup.class}) @RequestBody PlatformRoleServiceQuery query) throws Exception { 
       return ResultUtil.success(platformRoleService.getRoleList(query)); 
   }

    /**
     * 插入角色
     * @param query
     */
   @RequestMapping(value=("addRole.do"), method = RequestMethod.POST) 
   public JsonResult<Map<String, Object>> addRole(@Validated(value={AddRoleGroup.class}) @RequestBody PlatformRoleServiceQuery query) throws Exception { 
       platformRoleService.addRole(query); 
       return ResultUtil.success(); 
   }

    /**
     * 编辑角色
     * @param query
     */
   @RequestMapping(value=("editRole.do"), method = RequestMethod.POST) 
   public JsonResult<Map<String, Object>> editRole(@Validated(value={EditRoleGroup.class}) @RequestBody PlatformRoleServiceQuery query) throws Exception { 
       platformRoleService.editRole(query); 
       return ResultUtil.success(); 
   }

    /**
     * 根据UserId 获取角色
     * @param query
     * @return
     */
   @RequestMapping(value=("getRoleByUserId.do"), method = RequestMethod.POST) 
   public JsonResult<Map<String, Object>> getRoleByUserId(@Validated(value={GetRoleByUserIdGroup.class}) @RequestBody PlatformRoleServiceQuery query) throws Exception { 
       return ResultUtil.success(platformRoleService.getRoleByUserId(query)); 
   }
}

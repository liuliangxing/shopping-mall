package com.jbt.shopping.platform.controller.authorities;

import com.jbt.shopping.biz.groups.platform.authorities.GetAuthoritiesAllByRoleGroup; 
import com.jbt.shopping.biz.groups.platform.authorities.GrantAuthoritiesByUserIdGroup; 
import com.jbt.shopping.biz.groups.platform.authorities.GetAuthoritiesListByUserIdGroup; 
import com.jbt.shopping.biz.groups.platform.authorities.GetAuthoritiesByTypeGroup; 
import com.jbt.shopping.biz.groups.platform.authorities.AddAuthoritiesGroup; 
import com.jbt.shopping.biz.groups.platform.authorities.EditAuthoritiesGroup; 
import com.jbt.shopping.biz.groups.platform.authorities.DelAuthoritiesGroup; 
import com.destinyboy.jbt.result.JsonResult;
import com.destinyboy.jbt.utils.code.CodeUtil;
import com.destinyboy.jbt.utils.jwt.JwtUtil;
import com.destinyboy.jbt.utils.result.ResultUtil;
import com.jbt.shopping.biz.domain.platform.authorities.query.PlatformAuthoritiesServiceQuery;
import com.jbt.shopping.biz.groups.platform.authorities.GetAuthoritiesListGroup;
import com.jbt.shopping.biz.service.platform.authorities.PlatformAuthoritiesService;
import com.jbt.shopping.common.constants.Constants;
import com.jbt.shopping.common.exceptions.BusinessCodeConfig;
import com.jbt.shopping.common.exceptions.BusinessException;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
/**
 * 
 * ClassName:  PlatformAuthoritiesModuleController<br/>
 * Description: PlatformAuthoritiesModuleController Controller <br/>
 * Date: 2018-03-22 <br/>
 * <hr/>
 * Modification History: <br/>
 * DATE           AUTHOR          VERSION          DISCRIPTION 				 <br/>
 * ------------------------------------------------------------------------- <br/>
 * 2018-03-22        Destiny       1.0              INIT-CREATE<br/>
 *
 */
@RestController
@RequestMapping("platformAuthoritiesModule")
public class PlatformAuthoritiesModuleController {

    @Autowired
    private PlatformAuthoritiesService platformAuthoritiesService;

    /**
     * 获取权限列表
     * @param query
     * @return
     */
   @RequestMapping(value=("getAuthoritiesList.do"), method = RequestMethod.POST) 
   public JsonResult<Map<String, Object>> getAuthoritiesList(@Validated(value={GetAuthoritiesListGroup.class}) @RequestBody PlatformAuthoritiesServiceQuery query) throws Exception {
       Claims claims = JwtUtil.parserToken(query.getToken(), Constants.JWT_SECRET_KEY);
       CodeUtil.throwException(claims == null, new BusinessException(BusinessCodeConfig.BE_ERROR_1008));
       CodeUtil.throwException(!claims.containsKey("userId"), new BusinessException(BusinessCodeConfig.BE_ERROR_1008));
       Integer userId = claims.get("userId", Integer.class);
       query.setUserId(userId);
       return ResultUtil.success(platformAuthoritiesService.getAuthoritiesList(query));
   }

    /**
     * 添加权限
     * @param query
     */
   @RequestMapping(value=("addAuthorities.do"), method = RequestMethod.POST) 
   public JsonResult<Map<String, Object>> addAuthorities(@Validated(value={AddAuthoritiesGroup.class}) @RequestBody PlatformAuthoritiesServiceQuery query) throws Exception { 
       platformAuthoritiesService.addAuthorities(query); 
       return ResultUtil.success(); 
   }

    /**
     * 删除权限
     * @param query
     */
   @RequestMapping(value=("delAuthorities.do"), method = RequestMethod.POST) 
   public JsonResult<Map<String, Object>> delAuthorities(@Validated(value={DelAuthoritiesGroup.class}) @RequestBody PlatformAuthoritiesServiceQuery query) throws Exception { 
       platformAuthoritiesService.delAuthorities(query); 
       return ResultUtil.success(); 
   }

    /**
     * 获取所有权限
     * @return
     */
   @RequestMapping(value=("getAuthoritiesAll.do"), method = RequestMethod.POST) 
   public JsonResult<Map<String, Object>> getAuthoritiesAll() throws Exception { 
       return ResultUtil.success(platformAuthoritiesService.getAuthoritiesAll()); 
   }

    /**
     * 编辑权限
     * @param query
     */
   @RequestMapping(value=("editAuthorities.do"), method = RequestMethod.POST) 
   public JsonResult<Map<String, Object>> editAuthorities(@Validated(value={EditAuthoritiesGroup.class}) @RequestBody PlatformAuthoritiesServiceQuery query) throws Exception { 
       platformAuthoritiesService.editAuthorities(query); 
       return ResultUtil.success(); 
   }

    /**
     * 根据权限类型查询列表
     * @param query
     * @return
     */
   @RequestMapping(value=("getAuthoritiesByType.do"), method = RequestMethod.POST) 
   public JsonResult<Map<String, Object>> getAuthoritiesByType(@Validated(value={GetAuthoritiesByTypeGroup.class}) @RequestBody PlatformAuthoritiesServiceQuery query) throws Exception { 
       return ResultUtil.success(platformAuthoritiesService.getAuthoritiesByType(query)); 
   }

    /**
     * 根据用户ID 获取权限列表ID
     * @param query
     * @return
     */
   @RequestMapping(value=("getAuthoritiesListByUserId.do"), method = RequestMethod.POST) 
   public JsonResult<Map<String, Object>> getAuthoritiesListByUserId(@Validated(value={GetAuthoritiesListByUserIdGroup.class}) @RequestBody PlatformAuthoritiesServiceQuery query) throws Exception { 
       return ResultUtil.success(platformAuthoritiesService.getAuthoritiesListByUserId(query)); 
   }

    /**
     * 根据用户ID 授权
     * @param query
     */
   @RequestMapping(value=("grantAuthoritiesByUserId.do"), method = RequestMethod.POST) 
   public JsonResult<Map<String, Object>> grantAuthoritiesByUserId(@Validated(value={GrantAuthoritiesByUserIdGroup.class}) @RequestBody PlatformAuthoritiesServiceQuery query) throws Exception { 
       platformAuthoritiesService.grantAuthoritiesByUserId(query); 
       return ResultUtil.success(); 
   }

    /**
     * 获取 带有 用户角色权限ID 的权限列表 集合
     * @param query
     * @return
     */
   @RequestMapping(value=("getAuthoritiesAllByRole.do"), method = RequestMethod.POST) 
   public JsonResult<Map<String, Object>> getAuthoritiesAllByRole(@Validated(value={GetAuthoritiesAllByRoleGroup.class}) @RequestBody PlatformAuthoritiesServiceQuery query) throws Exception { 
       return ResultUtil.success(platformAuthoritiesService.getAuthoritiesAllByRole(query)); 
   }
}

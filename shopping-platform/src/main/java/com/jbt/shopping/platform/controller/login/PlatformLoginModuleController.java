package com.jbt.shopping.platform.controller.login;

import com.jbt.shopping.biz.groups.platform.login.EditUserGroup; 
import com.jbt.shopping.biz.groups.platform.login.GetUserListGroup; 
import com.jbt.shopping.biz.groups.platform.login.SetAuthoritiesGroup; 
import com.jbt.shopping.biz.groups.platform.login.DelUserGroup; 
import com.jbt.shopping.biz.groups.platform.login.GetAuthoritiesGroup; 
import com.jbt.shopping.biz.groups.platform.login.RetrievePasswordGroup; 
import com.destinyboy.jbt.utils.jwt.JwtUtil;
import com.jbt.shopping.biz.domain.platform.login.query.PlatformLoginServiceQuery;
import com.jbt.shopping.biz.groups.platform.login.RegisterGroup; 
import com.jbt.shopping.biz.groups.platform.login.LoginGroup; 
import com.jbt.shopping.biz.service.platform.login.PlatformLoginService;

import java.util.HashMap;
import java.util.Map;
import com.destinyboy.jbt.result.JsonResult;
import com.destinyboy.jbt.utils.result.ResultUtil;
import com.jbt.shopping.common.constants.Constants;
import com.jbt.shopping.persistent.entity.mall.PlatformUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
/**
 * 
 * ClassName:  PlatformLoginModuleController<br/>
 * Description: PlatformLoginModuleController Controller <br/>
 * Date: 2018-03-01 <br/>
 * <hr/>
 * Modification History: <br/>
 * DATE           AUTHOR          VERSION          DISCRIPTION 				 <br/>
 * ------------------------------------------------------------------------- <br/>
 * 2018-03-01        Destiny       1.0              INIT-CREATE<br/>
 *
 */
@RestController
@RequestMapping("platformLoginModule")
public class PlatformLoginModuleController {

    @Autowired
    private PlatformLoginService platformLoginService;

    /**
     * 用户登录
     * @param query
     * @return
     */
   @RequestMapping(value=("login.do"), method = RequestMethod.POST) 
   public JsonResult<Map<String, Object>> login(@Validated(value={LoginGroup.class}) @RequestBody PlatformLoginServiceQuery query) throws Exception {
       PlatformUser platformUser = platformLoginService.login(query);
       Map<String, Object> claimMap = new HashMap<>();
       claimMap.put("userId", platformUser.getId());
       String accessToken = JwtUtil.addAuthentication(claimMap, query.getUsername(), Constants.JWT_EXP_TIME, Constants.JWT_SECRET_KEY);
       return ResultUtil.success(accessToken);
   }

    /**
     * 注册用户
     * @param query
     */
   @RequestMapping(value=("register.do"), method = RequestMethod.POST) 
   public JsonResult<Map<String, Object>> register(@Validated(value={RegisterGroup.class}) @RequestBody PlatformLoginServiceQuery query) throws Exception {
       platformLoginService.register(query); 
       return ResultUtil.success(); 
   }

    /**
     * 重置密码
     * @param query
     * @throws Exception
     */
   @RequestMapping(value=("retrievePassword.do"), method = RequestMethod.POST) 
   public JsonResult<Map<String, Object>> retrievePassword(@Validated(value={RetrievePasswordGroup.class}) @RequestBody PlatformLoginServiceQuery query) throws Exception { 
       platformLoginService.retrievePassword(query); 
       return ResultUtil.success(); 
   }



    /**
     * 删除用户
     * @param query
     */
   @RequestMapping(value=("delUser.do"), method = RequestMethod.POST) 
   public JsonResult<Map<String, Object>> delUser(@Validated(value={DelUserGroup.class}) @RequestBody PlatformLoginServiceQuery query) throws Exception { 
       platformLoginService.delUser(query); 
       return ResultUtil.success(); 
   }

    /**
     * 给用户授权
     * @param query
     */
   @RequestMapping(value=("setAuthorities.do"), method = RequestMethod.POST) 
   public JsonResult<Map<String, Object>> setAuthorities(@Validated(value={SetAuthoritiesGroup.class}) @RequestBody PlatformLoginServiceQuery query) throws Exception { 
       platformLoginService.setAuthorities(query); 
       return ResultUtil.success(); 
   }

    /**
     * 获取用户的权限列表
     * @param query
     */
   @RequestMapping(value=("getAuthorities.do"), method = RequestMethod.POST) 
   public JsonResult<Map<String, Object>> getAuthorities(@Validated(value={GetAuthoritiesGroup.class}) @RequestBody PlatformLoginServiceQuery query) throws Exception { 
       platformLoginService.getAuthorities(query); 
       return ResultUtil.success(); 
   }

    /**
     * 获取用户集合
     * @return
     */
   @RequestMapping(value=("getUserList.do"), method = RequestMethod.POST) 
   public JsonResult<Map<String, Object>> getUserList(@Validated(value={GetUserListGroup.class}) @RequestBody PlatformLoginServiceQuery query) throws Exception { 
       return ResultUtil.success(platformLoginService.getUserList(query)); 
   }

    /**
     * 编辑用户
     * @param query
     */
   @RequestMapping(value=("editUser.do"), method = RequestMethod.POST) 
   public JsonResult<Map<String, Object>> editUser(@Validated(value={EditUserGroup.class}) @RequestBody PlatformLoginServiceQuery query) throws Exception { 
       platformLoginService.editUser(query); 
       return ResultUtil.success(); 
   }
}

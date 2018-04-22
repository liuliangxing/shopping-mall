package com.jbt.shopping.biz.service.platform.login;

import com.jbt.shopping.biz.domain.platform.login.query.PlatformLoginServiceQuery;
import com.jbt.shopping.persistent.entity.mall.PlatformUser;

import java.util.List;

/**
 * 
 * ClassName:  PlatformLoginService<br/>
 * Description: PlatformLoginService Service <br/>
 * Date: 2018-03-01 <br/>
 * <hr/>
 * Modification History: <br/>
 * DATE           AUTHOR          VERSION          DISCRIPTION 				 <br/>
 * ------------------------------------------------------------------------- <br/>
 * 2018-03-01        Destiny       1.0              INIT-CREATE<br/>
 *
 */
public interface PlatformLoginService{
    /**
     * 用户登录
     * @param query
     * @return
     */
    public PlatformUser login (PlatformLoginServiceQuery query) throws Exception;

    /**
     * 注册用户
     * @param query
     */
    public void register (PlatformLoginServiceQuery query) throws Exception;

    /**
     * 重置密码
     * @param query
     * @throws Exception
     */
    public void retrievePassword (PlatformLoginServiceQuery query) throws Exception;

    /**
     * 获取用户集合
     * @return
     */
    public List<PlatformUser> getUserList (PlatformLoginServiceQuery query) throws Exception;

    /**
     * 删除用户
     * @param query
     */
    public void delUser (PlatformLoginServiceQuery query) throws Exception;

    /**
     * 给用户授权
     * @param query
     */
    public void setAuthorities(PlatformLoginServiceQuery query) throws Exception;

    /**
     * 获取用户的权限列表
     * @param query
     */
    public void getAuthorities(PlatformLoginServiceQuery query) throws Exception;

    /**
     * 编辑用户
     * @param query
     */
    public void editUser (PlatformLoginServiceQuery query) throws Exception;

}

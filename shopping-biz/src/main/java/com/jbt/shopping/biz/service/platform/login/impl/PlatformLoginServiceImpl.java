package com.jbt.shopping.biz.service.platform.login.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.destinyboy.jbt.utils.code.CodeUtil;
import com.jbt.shopping.base.service.FacadeService;
import com.jbt.shopping.biz.domain.platform.login.query.PlatformLoginServiceQuery;
import com.jbt.shopping.biz.service.platform.login.PlatformLoginService;
import com.jbt.shopping.common.constants.Constants;
import com.jbt.shopping.common.exceptions.BusinessCodeConfig;
import com.jbt.shopping.common.exceptions.BusinessException;
import com.jbt.shopping.persistent.entity.mall.PlatformUser;
import com.jbt.shopping.persistent.entity.mall.UserAuthorities;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * ClassName:  PlatformLoginServiceImpl<br/>
 * Description: PlatformLoginServiceImpl Service Impl <br/>
 * Date: 2018-03-01 <br/>
 * <hr/>
 * Modification History: <br/>
 * DATE           AUTHOR          VERSION          DISCRIPTION 				 <br/>
 * ------------------------------------------------------------------------- <br/>
 * 2018-03-01        Destiny       1.0              INIT-CREATE<br/>
 *
 */
@Service
public class PlatformLoginServiceImpl extends FacadeService implements PlatformLoginService {

    /**
     * 用户登录
     * @param query
     * @return
     */
    public PlatformUser login (PlatformLoginServiceQuery query) throws Exception{
        PlatformUser platformUser = new PlatformUser();
        platformUser.setUsername(query.getUsername());
        String password = DigestUtils.md5Hex(query.getPassword());
        platformUser.setPassword(password);
        // 登录
        platformUser = CodeUtil.handlerDBCodeOptional(this.getPlatformUserService()::selectOne, new EntityWrapper<>(platformUser))//
                .orElseThrow(() -> new BusinessException(BusinessCodeConfig.BE_ERROR_1001));
        // 判断是否失效
        CodeUtil.throwException(platformUser.getAdmin() != Constants.GLOBAL_IS_ADMIN && platformUser.getEnabled() == Constants.GLOBAL_ENABLE_DISABLE,//
                new BusinessException(BusinessCodeConfig.BE_ERROR_1002));
        return platformUser;
    }

    /**
     * 注册用户
     * @param query
     */
    public void register (PlatformLoginServiceQuery query) throws Exception{

        PlatformUser platformUser = new PlatformUser();
        platformUser.setUsername(query.getUsername());
        // 判断是否存在
        CodeUtil.handlerDBCodeOptional(this.getPlatformUserService()::selectCount, new EntityWrapper<>(platformUser)).map(count -> {
            CodeUtil.throwException(count > 0 , new BusinessException(BusinessCodeConfig.BE_ERROR_1004));
            return count;
        });

        // 密码加密
        String password = DigestUtils.md5Hex(query.getPassword());
        platformUser.setPassword(password);
        platformUser.setNickname(query.getNickname());
        CodeUtil.handlerDBCodeBasic(this.getPlatformUserService()::insert, platformUser);
    }

    /**
     * 重置密码
     * @param query
     * @throws Exception
     */
    public void retrievePassword (PlatformLoginServiceQuery query) throws Exception{

        PlatformUser platformUser = CodeUtil.handlerDBCodeOptional(this.getPlatformUserService()::selectById, query.getUserId())//
                .orElseThrow(() -> new BusinessException(BusinessCodeConfig.BE_ERROR_1006));
        // 判断原密码
        CodeUtil.throwException(!platformUser.getPassword().equals(query.getPassword()),new BusinessException(BusinessCodeConfig.BE_ERROR_1003));

        // 新密码不能和原密码一样
        CodeUtil.throwException(platformUser.getPassword().equals(query.getNewPassword()),new BusinessException(BusinessCodeConfig.BE_ERROR_1007));

        platformUser.setPassword(query.getPassword());
        CodeUtil.handlerDBCodeBasic(this.getPlatformUserService()::updateById, platformUser);
    }

    /**
     * 获取用户集合
     * @return
     */
    public List<PlatformUser> getUserList (PlatformLoginServiceQuery query) throws Exception {
        EntityWrapper<PlatformUser> entityWrapper = new EntityWrapper<>();
        entityWrapper.eq(query.getEnabled() != null, "enabled", query.getEnabled());
        entityWrapper.like(query.getUsername() != null, "username", query.getUsername());
        entityWrapper.like(query.getNickname() != null, "nickname", query.getNickname());
        Page<PlatformUser> page = new Page(query.getPageIndex(),query.getPageSize());
        List<PlatformUser> platformUsers = CodeUtil.handlerDBCodeOptional(this.getPlatformUserService()::selectPage,page, entityWrapper).get().getRecords();
        return platformUsers;
    }

    /**
     * 编辑用户
     * @param query
     */
    public void editUser (PlatformLoginServiceQuery query) throws Exception{
        PlatformUser platformUser = new PlatformUser();
        BeanUtils.copyProperties(query, platformUser);
        platformUser.setId(query.getUserId());
        CodeUtil.handlerDBCodeOptional(this.getPlatformUserService()::updateById, platformUser);
    }


    /**
     * 删除用户
     * @param query
     */
    public void delUser (PlatformLoginServiceQuery query) throws Exception{
        PlatformUser entity = new PlatformUser();
        entity.setId(query.getUserId());
        entity.setEnabled(query.getEnabled());
        CodeUtil.handlerDBCodeOptional(this.getPlatformUserService()::updateById, entity);
    }

    /**
     * 给用户授权
     * @param query
     */
    public void setAuthorities(PlatformLoginServiceQuery query) throws Exception{
        List<UserAuthorities> userAuthoritiesList = new ArrayList<>();
        List<Integer> authoritesIds = query.getAuthoritesIds();
        for (Integer id :
                authoritesIds) {
            UserAuthorities userAuthorities = new UserAuthorities();
            userAuthorities.setUserId(query.getUserId());
            userAuthorities.setAuthoritiesId(id);
            userAuthoritiesList.add(userAuthorities);
        }
        CodeUtil.handlerDBCodeOptional(this.getUserAuthoritiesService():: insertBatch, userAuthoritiesList);
    }

    /**
     * 获取用户的权限列表
     * @param query
     */
    public void getAuthorities(PlatformLoginServiceQuery query) throws Exception{
        CodeUtil.handlerDBCodeOptional(this.getUserAuthoritiesService():: selectList,
                new EntityWrapper<UserAuthorities>().eq("user_id",query.getUserId()));
    }
}

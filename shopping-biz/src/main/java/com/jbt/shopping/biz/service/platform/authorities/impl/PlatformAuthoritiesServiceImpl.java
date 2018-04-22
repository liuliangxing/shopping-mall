package com.jbt.shopping.biz.service.platform.authorities.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.destinyboy.jbt.utils.code.CodeUtil;
import com.jbt.shopping.biz.domain.platform.authorities.query.PlatformAuthoritiesServiceQuery;
import com.jbt.shopping.biz.domain.platform.authorities.vo.GetAuthoritiesListVo;
import com.jbt.shopping.biz.service.platform.authorities.PlatformAuthoritiesService;
import com.jbt.shopping.base.service.FacadeService;
import com.jbt.shopping.common.constants.Constants;
import com.jbt.shopping.common.exceptions.BusinessCodeConfig;
import com.jbt.shopping.common.exceptions.BusinessException;
import com.jbt.shopping.persistent.entity.mall.*;
import com.xiaoleilu.hutool.util.BeanUtil;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 
 * ClassName:  PlatformAuthoritiesServiceImpl<br/>
 * Description: PlatformAuthoritiesServiceImpl Service Impl <br/>
 * Date: 2018-03-22 <br/>
 * <hr/>
 * Modification History: <br/>
 * DATE           AUTHOR          VERSION          DISCRIPTION 				 <br/>
 * ------------------------------------------------------------------------- <br/>
 * 2018-03-22        Destiny       1.0              INIT-CREATE<br/>
 *
 */
@Service
public class PlatformAuthoritiesServiceImpl extends FacadeService implements PlatformAuthoritiesService {

    private final static String USER_ID = "user_id";
    private final static String ROLE_ID = "role_id";


    /**
     * 获取用户权限列表
     * @param query
     * @return
     */
    public Map<String, Object> getAuthoritiesList(PlatformAuthoritiesServiceQuery query) throws Exception{
        PlatformUser platformUser = CodeUtil.handlerDBCodeOptional(this.getPlatformUserService()::selectById, query.getUserId()).get();
        // 判断是否失效
        CodeUtil.throwException(platformUser.getAdmin() != Constants.GLOBAL_IS_ADMIN && platformUser.getEnabled() == Constants.GLOBAL_ENABLE_DISABLE,//
                new BusinessException(BusinessCodeConfig.BE_ERROR_1002));

        // 获取用户角色Id 集合
        List<Integer> authorititesIds1 = CodeUtil.handlerDBCodeOptional(this.getUserRoleService()::selectList, //
                new EntityWrapper<UserRole>().eq(USER_ID, query.getUserId()))//
                .map(userRoles -> userRoles.stream().map(UserRole::getRoleId).collect(Collectors.toList()))//
                .map(roleIds -> {
                    // 获取用户角色下的权限 Id 集合
                    return CodeUtil.handlerDBCodeOptional(!roleIds.isEmpty(), this.getRoleAuthoritiesService()::selectList,//
                            new EntityWrapper<RoleAuthorities>().in(ROLE_ID, roleIds).eq("enabled", Constants.GLOBAL_ENABLE_NORMAL))//
                            .map(roleAuthorities -> roleAuthorities.stream().map(RoleAuthorities::getAuthoritiesId).collect(Collectors.toList()))//
                            .orElse(Collections.emptyList());
                }).get();

        // 获取用户权限Id  集合
        List<Integer> authorititesIds2 = CodeUtil.handlerDBCodeOptional(this.getUserAuthoritiesService()::selectList, //
                new EntityWrapper<UserAuthorities>().eq(USER_ID, query.getUserId()))//
                .map(userAuthorities -> userAuthorities.stream().map(UserAuthorities::getAuthoritiesId).collect(Collectors.toList()))//
                .get();

        // 两个权限Id 去重
        Set<Integer> authorititesIds = new HashSet<Integer>();
        authorititesIds.addAll(authorititesIds1);
        authorititesIds.addAll(authorititesIds2);

        // 查询指定集合 权限
        List<Authorities> authorities = CodeUtil.handlerDBCodeOptional(!authorititesIds.isEmpty(),this.getAuthoritiesService()::selectBatchIds, authorititesIds).orElse(Collections.emptyList());;
        List<GetAuthoritiesListVo> getAuthoritiesList = new ArrayList<>();
        recursionAuthorities(authorities, getAuthoritiesList, -1, null);

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("authoritiesList", getAuthoritiesList);
        resultMap.put("id", platformUser.getId());
        resultMap.put("username", platformUser.getUsername());
        resultMap.put("nickname",platformUser.getNickname());
        return resultMap;
    }

    /**
     * 根据用户ID 获取权限列表ID
     * @param query
     * @return
     */
    public Set<Integer> getAuthoritiesListByUserId(PlatformAuthoritiesServiceQuery query) throws Exception{
        // 获取用户权限Id  集合
        List<Integer> authorititesIds2 = CodeUtil.handlerDBCodeOptional(this.getUserAuthoritiesService()::selectList, //
                new EntityWrapper<UserAuthorities>().eq(USER_ID, query.getUserId()))//
                .map(userAuthorities -> userAuthorities.stream().map(UserAuthorities::getAuthoritiesId).collect(Collectors.toList()))//
                .get();

        // 获取用户角色Id 集合
        List<Integer> authorititesIds1 = CodeUtil.handlerDBCodeOptional(this.getUserRoleService()::selectList, //
                new EntityWrapper<UserRole>().eq(USER_ID, query.getUserId()))//
                .map(userRoles -> userRoles.stream().map(UserRole::getRoleId).collect(Collectors.toList()))//
                .map(roleIds -> {
                    // 获取用户角色下的权限 Id 集合
                    return CodeUtil.handlerDBCodeOptional(!roleIds.isEmpty(), this.getRoleAuthoritiesService()::selectList,//
                            new EntityWrapper<RoleAuthorities>().in(ROLE_ID, roleIds).eq("enabled", Constants.GLOBAL_ENABLE_NORMAL))//
                            .map(roleAuthorities -> roleAuthorities.stream().map(RoleAuthorities::getAuthoritiesId).collect(Collectors.toList()))//
                            .orElse(Collections.emptyList());
                }).get();
        // 两个权限Id 去重
        Set<Integer> authorititesIds = new HashSet<Integer>();
        authorititesIds.addAll(authorititesIds1);
        authorititesIds.addAll(authorititesIds2);
        return authorititesIds;
    }

    public void getAuthoritiesListByRoleId() {

    }

    /**
     * 根据用户ID 授权
     * @param query
     */
    public void grantAuthoritiesByUserId(PlatformAuthoritiesServiceQuery query) throws Exception{
        // 删除当前
        CodeUtil.handlerDBCodeOptional(this.getUserAuthoritiesService():: delete,
                new EntityWrapper<UserAuthorities>().eq(USER_ID, query.getUserId()));

        // 插入新的权限
        CodeUtil.handlerDBCodeOptional(this.getUserAuthoritiesService():: insertBatch, query.getAuthoritiesList());
    }

    /**
     * 根据权限类型查询列表
     * @param query
     * @return
     */
    public List<Authorities> getAuthoritiesByType (PlatformAuthoritiesServiceQuery query) throws Exception{
        List<Authorities> authoritiesList = new ArrayList<>();
        Authorities authorities = new Authorities();
        if (query.getType() == 1) { // 菜单权限没有父级
            return authoritiesList;
        } else if (query.getType() == 2) { //页面权限，父级一定是菜单 或 没有父级
            authoritiesList = CodeUtil.handlerDBCodeOptional(this.getAuthoritiesService():: selectList, new EntityWrapper<Authorities>().eq("type", 1)).get();
        } else if (query.getType() == 3) { //操作权限， 父级一定是页面权限
            authoritiesList = CodeUtil.handlerDBCodeOptional(this.getAuthoritiesService():: selectList, new EntityWrapper<Authorities>().eq("type", 2)).get();
        }
        return authoritiesList;
    }

    /**
     * 获取所有权限
     * @return
     */
    public List<GetAuthoritiesListVo> getAuthoritiesAll () throws Exception{
        List<Authorities> authorities = CodeUtil.handlerDBCodeOptional(this.getAuthoritiesService()::selectList, new EntityWrapper<>()).get();
        List<GetAuthoritiesListVo> getAuthoritiesList = new ArrayList<>();
        recursionAuthorities(authorities, getAuthoritiesList, -1, null);
        return getAuthoritiesList;
    }

    /**
     * 获取 带有 用户角色权限ID 的权限列表 集合
     * @param query
     * @return
     */
    public List<GetAuthoritiesListVo> getAuthoritiesAllByRole (PlatformAuthoritiesServiceQuery query) throws Exception{
        List<Authorities> authorities = CodeUtil.handlerDBCodeOptional(this.getAuthoritiesService()::selectList, new EntityWrapper<>()).get();
        List<GetAuthoritiesListVo> getAuthoritiesList = new ArrayList<>();
        // 获取用户角色Id 集合
        List<Integer> authorititesIds1 = CodeUtil.handlerDBCodeOptional(this.getUserRoleService()::selectList, //
                new EntityWrapper<UserRole>().eq(USER_ID, query.getUserId()))//
                .map(userRoles -> userRoles.stream().map(UserRole::getRoleId).collect(Collectors.toList()))//
                .map(roleIds -> {
                    // 获取用户角色下的权限 Id 集合
                    return CodeUtil.handlerDBCodeOptional(!roleIds.isEmpty(), this.getRoleAuthoritiesService()::selectList,//
                            new EntityWrapper<RoleAuthorities>().in(ROLE_ID, roleIds).eq("enabled", Constants.GLOBAL_ENABLE_NORMAL))//
                            .map(roleAuthorities -> roleAuthorities.stream().map(RoleAuthorities::getAuthoritiesId).collect(Collectors.toList()))//
                            .orElse(Collections.emptyList());
                }).get();
        recursionAuthorities(authorities, getAuthoritiesList, -1, authorititesIds1);
        return getAuthoritiesList;
    }

    /**
     * 编辑权限
     * @param query
     */
    public void editAuthorities(PlatformAuthoritiesServiceQuery query) throws Exception{
        Authorities entity = new Authorities();
        BeanUtil.copyProperties(query, entity);
        CodeUtil.handlerDBCodeBasic(this.getAuthoritiesService() :: updateById, entity);
    }

    /**
     * 添加权限
     * @param query
     */
    public void addAuthorities(PlatformAuthoritiesServiceQuery query) throws Exception{
        Authorities authorities = new Authorities();
        BeanUtil.copyProperties(query, authorities);
        CodeUtil.handlerDBCodeBasic(this.getAuthoritiesService()::insert, authorities);
    }

    /**
     * 删除权限
     * @param query
     */
    public void delAuthorities(PlatformAuthoritiesServiceQuery query) throws Exception{
        List<Authorities> authorities = CodeUtil.handlerDBCodeOptional(this.getAuthoritiesService()::selectList, new EntityWrapper<>()).get();
        List<Integer> ids = new ArrayList<>();
        recursionAuthorities(authorities, ids, query.getId());
        ids.add(query.getId());
        CodeUtil.handlerDBCodeBasic(this.getAuthoritiesService()::deleteBatchIds, ids);
    }

    /**
     * 获取子权限Id
     * @param authorities
     * @param ids
     * @param id
     */
    private void recursionAuthorities(List<Authorities> authorities, List<Integer> ids, int id) {
        for (Authorities authoritie: authorities) {
            if (authoritie.getParentId().equals(id)) {
                ids.add(authoritie.getId());
                recursionAuthorities(authorities, ids, authoritie.getId());
            }
        }
    }
    /**
     * 递归查询子权限
     * @param authorities
     * @param getAuthoritiesList
     * @param pid
     */
    private void recursionAuthorities (List<Authorities> authorities, List<GetAuthoritiesListVo> getAuthoritiesList, Integer pid, List<Integer> authoritiesIds) {
        for (Authorities authoritie: authorities) {
            if (authoritie.getParentId().equals(pid)) {
                GetAuthoritiesListVo vo = new GetAuthoritiesListVo();
                BeanUtil.copyProperties(authoritie,vo);
                vo.setLabel(authoritie.getMenuNotes());
                if (authoritiesIds !=null && authoritiesIds.contains(authoritie.getId())) {
                    vo.setDisabled(Boolean.TRUE);
                }
                getAuthoritiesList.add(vo);
                recursionAuthorities(authorities, vo.getChildren(), vo.getId(), authoritiesIds);
            }
        }
        getAuthoritiesList = getAuthoritiesList.stream().sorted(Comparator.comparing(GetAuthoritiesListVo::getId)).collect(Collectors.toList());
    }


}

package com.jbt.shopping.biz.service.platform.authorities;

import com.jbt.shopping.biz.domain.platform.authorities.query.PlatformAuthoritiesServiceQuery;
import com.jbt.shopping.biz.domain.platform.authorities.vo.GetAuthoritiesListVo;
import com.jbt.shopping.persistent.entity.mall.Authorities;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 
 * ClassName:  PlatformAuthoritiesService<br/>
 * Description: PlatformAuthoritiesService Service <br/>
 * Date: 2018-03-22 <br/>
 * <hr/>
 * Modification History: <br/>
 * DATE           AUTHOR          VERSION          DISCRIPTION 				 <br/>
 * ------------------------------------------------------------------------- <br/>
 * 2018-03-22        Destiny       1.0              INIT-CREATE<br/>
 *
 */
public interface PlatformAuthoritiesService{
    /**
     * 获取权限列表
     * @param query
     * @return
     */
    public Map<String, Object> getAuthoritiesList(PlatformAuthoritiesServiceQuery query) throws Exception;

    /**
     * 获取所有权限
     * @return
     */
    public List<GetAuthoritiesListVo> getAuthoritiesAll () throws Exception;


    /**
     * 编辑权限
     * @param query
     */
    public void editAuthorities(PlatformAuthoritiesServiceQuery query) throws Exception;

    /**
     * 添加权限
     * @param query
     */
    public void addAuthorities(PlatformAuthoritiesServiceQuery query) throws Exception;

    /**
     * 删除权限
     * @param query
     */
    public void delAuthorities(PlatformAuthoritiesServiceQuery query) throws Exception;

    /**
     * 根据权限类型查询列表
     * @param query
     * @return
     */
    public List<Authorities> getAuthoritiesByType (PlatformAuthoritiesServiceQuery query) throws Exception;

    /**
     * 根据用户ID 获取权限列表ID
     * @param query
     * @return
     */
    public Set<Integer> getAuthoritiesListByUserId(PlatformAuthoritiesServiceQuery query) throws Exception;

    /**
     * 根据用户ID 授权
     * @param query
     */
    public void grantAuthoritiesByUserId(PlatformAuthoritiesServiceQuery query) throws Exception;

    /**
     * 获取 带有 用户角色权限ID 的权限列表 集合
     * @param query
     * @return
     */
    public List<GetAuthoritiesListVo> getAuthoritiesAllByRole (PlatformAuthoritiesServiceQuery query) throws Exception;
}

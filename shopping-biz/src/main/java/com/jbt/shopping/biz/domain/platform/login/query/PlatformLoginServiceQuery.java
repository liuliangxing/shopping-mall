package com.jbt.shopping.biz.domain.platform.login.query;

import com.destinyboy.jbt.utils.page.PageQuery;
import com.jbt.shopping.biz.groups.platform.login.*;
import lombok.Data;
import javax.validation.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * ClassName:  PlatformLoginServiceQuery<br/>
 * Description: PlatformLoginServiceQuery Service <br/>
 * Date: 2018-03-01 <br/>
 * <hr/>
 * Modification History: <br/>
 * DATE           AUTHOR          VERSION          DISCRIPTION 				 <br/>
 * ------------------------------------------------------------------------- <br/>
 * 2018-03-01        Destiny       1.0              INIT-CREATE<br/>
 *
 */
@Data
public class PlatformLoginServiceQuery extends PageQuery implements Serializable {
    /**
     * 用户ID
     */
    @NotNull(groups = {RetrievePasswordGroup.class, DelUserGroup.class, SetAuthoritiesGroup.class, GetAuthoritiesGroup.class, EditUserGroup.class})
    private Integer userId;
    /**
     * 用户名
     */
    @NotEmpty(groups = {LoginGroup.class, RegisterGroup.class})
    private String username;
    /**
     * 密码
     */
    @NotEmpty(groups = {LoginGroup.class, RegisterGroup.class, RetrievePasswordGroup.class})
    private String password;

    /**
     * 新密码
     */
    @NotEmpty(groups = {RetrievePasswordGroup.class})
    private String newPassword;

    /**
     * 昵称
     */
    @NotEmpty(groups = {RegisterGroup.class})
    private String nickname;

    /**
     * 权限列表
     */
    @NotEmpty(groups = {SetAuthoritiesGroup.class})
    private List<Integer> authoritesIds = new ArrayList<>();

    /**
     * 是否启用 1: 启用 2: 禁用
     */
    @NotNull(groups = {DelUserGroup.class})
    private Integer enabled;

}

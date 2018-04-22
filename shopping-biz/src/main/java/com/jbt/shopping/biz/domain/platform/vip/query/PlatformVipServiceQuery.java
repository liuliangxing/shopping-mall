package com.jbt.shopping.biz.domain.platform.vip.query;

import com.jbt.shopping.biz.groups.platform.vip.DeleteVipGroup;
import com.jbt.shopping.biz.groups.platform.vip.EditVipGroup;
import com.jbt.shopping.biz.groups.platform.vip.SaveVipGroup;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
/**
 * 
 * ClassName:  PlatformVipServiceQuery<br/>
 * Description: PlatformVipServiceQuery Service <br/>
 * Date: 2018-03-02 <br/>
 * <hr/>
 * Modification History: <br/>
 * DATE           AUTHOR          VERSION          DISCRIPTION 				 <br/>
 * ------------------------------------------------------------------------- <br/>
 * 2018-03-02        Destiny       1.0              INIT-CREATE<br/>
 *
 */
@Data
public class PlatformVipServiceQuery implements Serializable {
    /**
     * Vip Id
     */
    @NotNull(groups = {EditVipGroup.class, DeleteVipGroup.class})
    private Integer id;

    /**
     * 开始消费金额
     */
    @NotNull(groups = {SaveVipGroup.class})
    private Integer startCount;

    /**
     * 结束消费金额
     */
    @NotNull(groups = {SaveVipGroup.class})
    private Integer endCount;

    /**
     * 会员名称
     */
    @NotNull(groups = {SaveVipGroup.class})
    private Integer vipName;

    /**
     * vip 等级
     */
    @NotNull(groups = {SaveVipGroup.class})
    private Integer vipGrade;

}

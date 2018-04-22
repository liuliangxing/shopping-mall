package com.jbt.shopping.biz.domain.platform.cart.query;

import com.jbt.shopping.biz.groups.platform.cart.GetCartListGroup;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
/**
 * 
 * ClassName:  PlatformCartServiceQuery<br/>
 * Description: PlatformCartServiceQuery Service <br/>
 * Date: 2018-03-11 <br/>
 * <hr/>
 * Modification History: <br/>
 * DATE           AUTHOR          VERSION          DISCRIPTION 				 <br/>
 * ------------------------------------------------------------------------- <br/>
 * 2018-03-11        Destiny       1.0              INIT-CREATE<br/>
 *
 */
@Data
public class PlatformCartServiceQuery implements Serializable {

    /**
     * 用户Id
     */
    @NotNull(groups = {
        GetCartListGroup.class
    })
    private Integer userId;
}

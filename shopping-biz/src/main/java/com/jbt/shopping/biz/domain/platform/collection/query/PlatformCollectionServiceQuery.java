package com.jbt.shopping.biz.domain.platform.collection.query;

import com.jbt.shopping.biz.groups.platform.collection.AddCollectionGroup;
import com.jbt.shopping.biz.groups.platform.collection.GetCollectionListGroup;
import com.jbt.shopping.biz.groups.platform.collection.RemoveCollectionGroup;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
/**
 * 
 * ClassName:  PlatformCollectionServiceQuery<br/>
 * Description: PlatformCollectionServiceQuery Service <br/>
 * Date: 2018-03-11 <br/>
 * <hr/>
 * Modification History: <br/>
 * DATE           AUTHOR          VERSION          DISCRIPTION 				 <br/>
 * ------------------------------------------------------------------------- <br/>
 * 2018-03-11        Destiny       1.0              INIT-CREATE<br/>
 *
 */
@Data
public class PlatformCollectionServiceQuery implements Serializable {

    /**
     * 收藏ID
     */
    @NotNull(groups = {
            RemoveCollectionGroup.class
    })
    private Integer id;
    /**
     * 用户ID
     */
    @NotNull(groups = {
            GetCollectionListGroup.class,
            AddCollectionGroup.class
    })
    private Integer userId;

    /**
     * 商品Id
     */
    @NotNull(groups = {
            AddCollectionGroup.class
    })
    private Integer goodsId;
}

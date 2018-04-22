package com.jbt.shopping.biz.domain.platform.supplier.query;

import com.jbt.shopping.biz.groups.platform.supplier.DeleteSupplierGroup;
import com.jbt.shopping.biz.groups.platform.supplier.EditSupplierGroup;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
/**
 * 
 * ClassName:  PlatformSupplierServiceQuery<br/>
 * Description: PlatformSupplierServiceQuery Service <br/>
 * Date: 2018-03-06 <br/>
 * <hr/>
 * Modification History: <br/>
 * DATE           AUTHOR          VERSION          DISCRIPTION 				 <br/>
 * ------------------------------------------------------------------------- <br/>
 * 2018-03-06        Destiny       1.0              INIT-CREATE<br/>
 *
 */
@Data
public class PlatformSupplierServiceQuery implements Serializable {
    /**
     * id
     */
    @NotNull(groups = {EditSupplierGroup.class, DeleteSupplierGroup.class})
    private Integer id;

    /**
     * 供货商名称
     */
    private String supplierName;

    /**
     * 供货商联系人
     */
    private String supplierContacts;

    /**
     * 供货商备用联系人
     */
    private String supplierSpare;


}

package com.jbt.shopping.platform.controller.supplier;

import com.jbt.shopping.biz.service.platform.supplier.PlatformSupplierService;
import java.util.Map;
import com.destinyboy.jbt.result.JsonResult;
import com.destinyboy.jbt.utils.result.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
/**
 * 
 * ClassName:  PlatformSupplierModuleController<br/>
 * Description: PlatformSupplierModuleController Controller <br/>
 * Date: 2018-03-06 <br/>
 * <hr/>
 * Modification History: <br/>
 * DATE           AUTHOR          VERSION          DISCRIPTION 				 <br/>
 * ------------------------------------------------------------------------- <br/>
 * 2018-03-06        Destiny       1.0              INIT-CREATE<br/>
 *
 */
@RestController
@RequestMapping("platformSupplierModule")
public class PlatformSupplierModuleController {

    @Autowired
    private PlatformSupplierService platformSupplierService;
}

package com.jbt.shopping.platform.controller.goods;

import com.jbt.shopping.biz.service.platform.goods.PlatformGoodsService;
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
 * ClassName:  PlatformGoodsModuleController<br/>
 * Description: PlatformGoodsModuleController Controller <br/>
 * Date: 2018-03-01 <br/>
 * <hr/>
 * Modification History: <br/>
 * DATE           AUTHOR          VERSION          DISCRIPTION 				 <br/>
 * ------------------------------------------------------------------------- <br/>
 * 2018-03-01        Destiny       1.0              INIT-CREATE<br/>
 *
 */
@RestController
@RequestMapping("platformGoodsModule")
public class PlatformGoodsModuleController {

    @Autowired
    private PlatformGoodsService platformGoodsService;
}

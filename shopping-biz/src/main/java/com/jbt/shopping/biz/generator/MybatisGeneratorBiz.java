package com.jbt.shopping.biz.generator;


import com.destinyboy.jbt.utils.generator.GeneratorCodeUtil;
import com.jbt.shopping.base.service.FacadeService;
import com.jbt.shopping.biz.domain.platform.login.query.PlatformLoginServiceQuery;

public class MybatisGeneratorBiz {
    public static void main(String[] args) {
        GeneratorCodeUtil.generatorBCCode("com.jbt.shopping.biz", //
                "shopping-platform", //
                "cart", //
                FacadeService.class, //
                "com.jbt.shopping.platform.controller");
    }
}

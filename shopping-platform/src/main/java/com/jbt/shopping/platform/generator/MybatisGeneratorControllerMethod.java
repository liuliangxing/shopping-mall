package com.jbt.shopping.platform.generator;


import com.destinyboy.jbt.utils.generator.GeneratorCodeUtil;
import com.jbt.shopping.biz.service.platform.authorities.PlatformAuthoritiesService;
import com.jbt.shopping.biz.service.platform.login.PlatformLoginService;
import com.jbt.shopping.platform.controller.authorities.PlatformAuthoritiesModuleController;
import com.jbt.shopping.platform.controller.login.PlatformLoginModuleController;

public class MybatisGeneratorControllerMethod {
    public static void main(String[] args) throws Exception {
        GeneratorCodeUtil.generatorControllerMethod(PlatformAuthoritiesService.class, PlatformAuthoritiesModuleController.class);
    }
}

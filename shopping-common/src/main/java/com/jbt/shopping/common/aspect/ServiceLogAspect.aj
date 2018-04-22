package com.jbt.shopping.common.aspect;

import com.destinyboy.jbt.exceptions.SystemException;
import com.destinyboy.jbt.result.SystemCodeConfig;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 *
 * ClassName: WebLogAspect <br/>
 * Description: Web层日志切面 <br/>
 * Date: 2017年7月25日 下午3:01:12 <br/>
 * <hr/>
 * Modification History:(修改类时添加大概记录) <br/>
 * DATE AUTHOR VERSION DISCRIPTION <br/>
 * -------------------------------------------------------------------------
 * <br/>
 * 2017年7月25日 Destiny 1.0 初始创建<br/>
 *
 */
@Aspect
@Order(5)
@Component
public class ServiceLogAspect {
    private Logger logger = null;

    @Pointcut("execution(public * com.jbt.shopping.biz.service..*.*(..))")
    private void serviceLog() { }

    @Before("serviceLog()")
    private void doAccesCheck(JoinPoint point) {
        logger = LoggerFactory.getLogger(point.getTarget().getClass());
        logger.info(">>>>>>>>>>>>>>>>>>>>{} start", point.getTarget().getClass().getSimpleName() + "." + point.getSignature().getName());
        logger.info(String.format("input parameters: %s", Arrays.toString(point.getArgs())));
        for (Object obj : point.getArgs()) {
            if (obj == null) {
                throw new SystemException(SystemCodeConfig.SE_ERROR_1001);
            }
        }
    }

    @After("serviceLog()")
    private void after(JoinPoint point) {
        logger.info("{} end<<<<<<<<<<<<<<<<<<<<", point.getTarget().getClass().getSimpleName() + "." + point.getSignature().getName());
    }
}

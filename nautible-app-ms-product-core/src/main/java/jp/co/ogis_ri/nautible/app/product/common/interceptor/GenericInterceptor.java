package jp.co.ogis_ri.nautible.app.product.common.interceptor;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class GenericInterceptor {

    @AroundInvoke
    Object aroundInvoke(InvocationContext ctx) throws Exception {
        Class<?> targetClass = ctx.getTarget().getClass();
        Logger logger = LoggerFactory.getLogger(targetClass);
        
        String targetClassName = targetClass.getSimpleName();
        String targetMethodName = ctx.getMethod().getName();
        logger.info("start " + targetClassName + "#" + targetMethodName + ".");

        Object ret;
        try {
            ret = ctx.proceed();
        } finally {
            logger.info("end " + targetClassName + "#" + targetMethodName + ".");
        }
        return ret;
    }
}

package jp.co.ogis_ri.nautible.app.product.common.annotation;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Stereotype;
import jakarta.interceptor.InterceptorBinding;
import jakarta.transaction.Transactional;

@Inherited
@Target({ TYPE, METHOD })
@Retention(RUNTIME)
@Documented
@InterceptorBinding
@Stereotype
@ApplicationScoped
@Transactional
public @interface Service {
}

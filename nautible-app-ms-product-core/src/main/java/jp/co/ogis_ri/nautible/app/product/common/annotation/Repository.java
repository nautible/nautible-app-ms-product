package jp.co.ogis_ri.nautible.app.product.common.annotation;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Stereotype;
import javax.interceptor.InterceptorBinding;

@Inherited
@Target({ TYPE, METHOD })
@Retention(RUNTIME)
@Documented
@InterceptorBinding
@Stereotype
@ApplicationScoped
public @interface Repository {
}

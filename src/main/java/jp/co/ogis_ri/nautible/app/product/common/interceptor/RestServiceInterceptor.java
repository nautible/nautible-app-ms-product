package jp.co.ogis_ri.nautible.app.product.common.interceptor;

import static javax.interceptor.Interceptor.Priority.APPLICATION;

import javax.annotation.Priority;
import javax.interceptor.Interceptor;

import jp.co.ogis_ri.nautible.app.product.common.annotation.RestService;

@RestService
@Interceptor
@Priority(APPLICATION)
public class RestServiceInterceptor extends GenericInterceptor {

}

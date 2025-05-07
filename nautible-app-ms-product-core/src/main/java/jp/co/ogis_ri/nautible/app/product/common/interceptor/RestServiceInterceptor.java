package jp.co.ogis_ri.nautible.app.product.common.interceptor;

import static jakarta.interceptor.Interceptor.Priority.APPLICATION;

import jakarta.annotation.Priority;
import jakarta.interceptor.Interceptor;

import jp.co.ogis_ri.nautible.app.product.common.annotation.RestService;

@RestService
@Interceptor
@Priority(APPLICATION)
public class RestServiceInterceptor extends GenericInterceptor {

}

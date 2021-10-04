package jp.co.ogis_ri.nautible.app.product.common.interceptor;

import static javax.interceptor.Interceptor.Priority.APPLICATION;

import javax.annotation.Priority;
import javax.interceptor.Interceptor;

import jp.co.ogis_ri.nautible.app.product.common.annotation.Repository;

@Repository
@Interceptor
@Priority(APPLICATION)
public class RepositoryInterceptor extends GenericInterceptor {

}

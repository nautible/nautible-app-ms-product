package jp.co.ogis_ri.nautible.app.product.common.interceptor;

import static jakarta.interceptor.Interceptor.Priority.APPLICATION;

import jakarta.annotation.Priority;
import jakarta.interceptor.Interceptor;

import jp.co.ogis_ri.nautible.app.product.common.annotation.Repository;

@Repository
@Interceptor
@Priority(APPLICATION)
public class RepositoryInterceptor extends GenericInterceptor {

}

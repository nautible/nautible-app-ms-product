package jp.co.ogis_ri.nautible.app.product.domain;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

import java.util.Collection;
import java.util.Optional;

public interface ProductRepository extends PanacheRepository<Product> {
    void createProduct(Product product);

    void updateProduct(Product product);

    Optional<Product> findProductById(long productId);

    Collection<Product> findProductByNameAndPrice(String name, Money greaterThanPrice, Money lessThanPrice);

    Collection<Product> findProductByName(String name);

    Collection<Product> findProductByPriceGreaterThan(Money price);

    Collection<Product> findProductByPriceLessThan(Money price);
}

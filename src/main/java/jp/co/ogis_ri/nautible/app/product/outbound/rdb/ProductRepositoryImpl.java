package jp.co.ogis_ri.nautible.app.product.outbound.rdb;

import java.util.Collection;
// import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

// import javax.inject.Inject;
// import javax.persistence.EntityManager;
// import javax.persistence.TypedQuery;

import io.quarkus.panache.common.Parameters;
import io.quarkus.panache.common.Sort;
import io.quarkus.panache.common.Sort.Direction;
import jp.co.ogis_ri.nautible.app.product.common.annotation.Repository;
import jp.co.ogis_ri.nautible.app.product.domain.Money;
import jp.co.ogis_ri.nautible.app.product.domain.Product;
import jp.co.ogis_ri.nautible.app.product.domain.ProductRepository;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
    // @Inject
    // EntityManager entityManager;

    public void createProduct(Product product) {
        // entityManager.persist(product);
        persist(product);
    }

    public void updateProduct(Product product) {
        // entityManager.merge(product);
        getEntityManager().merge(product);
    }

    public Optional<Product> findProductById(long productId) {
        // return Optional.ofNullable(entityManager.find(Product.class, productId));
        return findByIdOptional(productId);
    }

    public Collection<Product> findProductByNameAndPrice(String name, Money greaterThanPrice, Money lessThanPrice) {
        // #2303 Add support for optional predicates in Panache is still open.
        // so, build with manual.
        // https://github.com/quarkusio/quarkus/issues/2303
        // https://github.com/quarkusio/quarkus/issues/3965
        // https://github.com/quarkusio/quarkus/issues/8136

        StringBuilder query = new StringBuilder();
        Map<String, Object> params = new HashMap<>();
        Sort sort = null;
        if (name != null) {
            query.append("name like :name");
            params.put("name", "%" + name + "%");
            sort = Sort.by("name", Direction.Ascending);
        }
        if (greaterThanPrice != null) {
            if (query.length() != 0) query.append(" and ");
            query.append("price >= :greaterThanPrice");
            params.put("greaterThanPrice", greaterThanPrice);
            if (sort == null) {
                sort = Sort.by("price", Direction.Ascending);
            } else {
                sort.and("price", Direction.Ascending);
            }
        }
        if (lessThanPrice != null) {
            if (query.length() != 0) query.append(" and ");
            query.append("price <= :lessThanPrice");
            params.put("lessThanPrice", lessThanPrice);
            if (sort == null) {
                sort = Sort.by("price", Direction.Descending);
            } else if (greaterThanPrice == null) {
                sort.and("price", Direction.Descending);
            }
        }

        // if non conditions query, return all data.
        // if (query.length() == 0) {
        //     return Collections.emptyList();
        // }

        return list(query.toString(), sort, params);
    }

    public Collection<Product> findProductByName(String name) {
        // TypedQuery<Product> query = entityManager.createQuery(
        //         "SELECT product FROM Product product WHERE product.name like :name ORDER BY product.name ASC",
        //         Product.class);
        // query.setParameter("name", "%" + name + "%");
        // return query.getResultList();
        return list("name like :name", Sort.by("name", Direction.Ascending), Parameters.with("name", "%" + name + "%"));
    }

    public Collection<Product> findProductByPriceGreaterThan(Money price) {
        // TypedQuery<Product> query = entityManager.createQuery(
        //         "SELECT product FROM Product product WHERE product.price >= :price ORDER BY product.price ASC",
        //         Product.class);
        // query.setParameter("price", price.asLong());
        // return query.getResultList();
        return list("price >= :price", Sort.by("price", Direction.Ascending), Parameters.with("price", price));
    }

    public Collection<Product> findProductByPriceLessThan(Money price) {
        // TypedQuery<Product> query = entityManager.createQuery(
        //         "SELECT product FROM Product product WHERE product.price <= :price ORDER BY product.price DESC",
        //         Product.class);
        // query.setParameter("price", price.asLong());
        // return query.getResultList();
        return list("price <= :price", Sort.by("price", Direction.Descending), Parameters.with("price", price));
    }
}
package jp.co.ogis_ri.nautible.app.product.domain;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Objects;
import java.util.Optional;

import javax.inject.Inject;

import jp.co.ogis_ri.nautible.app.product.api.rest.CreateProductRequest;
import jp.co.ogis_ri.nautible.app.product.api.rest.UpdateProductRequest;
import jp.co.ogis_ri.nautible.app.product.common.annotation.Service;

@Service
public class ProductService {

    @Inject
    ProductRepository productRepository;

    public Product create(CreateProductRequest request) {
        Product product = new Product(request.getName(), request.getMaker(), request.getDescription(),
                new Money(new BigDecimal(request.getPrice())));
        productRepository.createProduct(product);
        return product;
    }

    public void update(UpdateProductRequest request) {
        Product product = new Product(Long.parseLong(request.getId()), request.getName(), request.getMaker(),
                request.getDescription(), new Money(new BigDecimal(request.getPrice())));

        productRepository.updateProduct(product);
    }

    public Optional<Product> findById(long id) {
        return productRepository.findProductById(id);
    }

    public Collection<Product> findProductByNameAndPrice(String name, Long greaterThanPrice, Long lessThanPrice) {
        return productRepository.findProductByNameAndPrice(name, toMoney(greaterThanPrice), toMoney(lessThanPrice));
    }

    public Collection<Product> findByName(String name) {
        return productRepository.findProductByName(name);
    }

    public Collection<Product> findByPriceGreaterThan(long price) {
        return productRepository.findProductByPriceGreaterThan(new Money(new BigDecimal(price)));
    }

    public Collection<Product> findByPriceLessThan(long price) {
        return productRepository.findProductByPriceLessThan(new Money(new BigDecimal(price)));
    }

    private Money toMoney(Long price) {
        if (Objects.isNull(price)) {
            return null;
        }
        return new Money(new BigDecimal(price));
    }
}
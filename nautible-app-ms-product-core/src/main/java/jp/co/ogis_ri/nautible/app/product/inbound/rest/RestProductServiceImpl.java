package jp.co.ogis_ri.nautible.app.product.inbound.rest;

import jp.co.ogis_ri.nautible.app.product.api.rest.*;
import jp.co.ogis_ri.nautible.app.product.common.annotation.RestService;
import jp.co.ogis_ri.nautible.app.product.domain.Product;
import jp.co.ogis_ri.nautible.app.product.domain.ProductService;

import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.util.Collection;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

// import java.util.Collections;

@RestService
public class RestProductServiceImpl implements RestProductService {

    @Inject
    ProductService productService;

    public Response hello() {
        return Response.ok("hello").build();
    }

    public Response find(final String id) {
        final Optional<Product> productOptional = productService.findById(Long.parseLong(id));

        return Response.ok(
                productOptional.map(this::toGetProductResponse).orElseGet(GetProductResponse::new))
                .build();
    }

    public Response findBy(final String greater, final String less, final String name) {
        Collection<Product> products = productService.findProductByNameAndPrice(name, toLong(greater), toLong(less));

        // if (!Objects.isNull(name)) {
        //     products = productService.findByName(name);
        // } else if (!Objects.isNull(greaterThanPrice)) {
        //     products = productService.findByPriceGreaterThan(Long.parseLong(greaterThanPrice));
        // } else if (!Objects.isNull(lessThanPrice)) {
        //     products = productService.findByPriceLessThan(Long.parseLong(lessThanPrice));
        // } else {
        //     products = Collections.emptyList();
        // }

        return Response.ok(products.stream().map(this::toGetProductResponse).collect(Collectors.toList()))
                .build();
    }

    public Response register(final CreateProductRequest createProductRequest) {
        final Product product = productService.create(createProductRequest);

        return Response.ok(new CreateProductResponse().id(product.getId().toString())).build();
    }

    public Response update(final UpdateProductRequest updateProductRequest) {
        productService.update(updateProductRequest);

        return Response.ok().build();
    }

    private Long toLong(String str) {
        if (Objects.isNull(str)) {
            return null;
        }
        return Long.valueOf(str);
    }
    private GetProductResponse toGetProductResponse(final Product product) {
        return new GetProductResponse().id(product.getId().toString()).name(product.getName())
                .description(product.getDescription()).maker(product.getMaker()).price(product.getPrice().asString());
    }
}
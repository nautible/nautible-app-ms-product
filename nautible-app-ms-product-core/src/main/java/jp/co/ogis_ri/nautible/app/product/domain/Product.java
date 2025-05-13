package jp.co.ogis_ri.nautible.app.product.domain;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
// import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Access(AccessType.FIELD)
@Table(name = "Product")
public class Product {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // @SequenceGenerator(name = "productSeq", sequenceName = "product_id_seq", allocationSize = 1, initialValue = 1)
    // @GeneratedValue(generator = "productSeq")
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="maker")
    private String maker;

    @Column(name="description")
    private String description;

    @Embedded
    private Money price;

    Product() {
    }

    public Product(String name, String maker, String description, Money price) {
        this.name = name;
        this.maker = maker;
        this.description = description;
        this.price = price;
    }
    
    public Product(Long id, String name, String maker, String description, Money price) {
        this.id = id;
        this.name = name;
        this.maker = maker;
        this.description = description;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Money getPrice() {
        return price;
    }

    public void setPrice(Money price) {
        this.price = price;
    }
}
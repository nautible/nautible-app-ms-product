package jp.co.ogis_ri.nautible.app.product.domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
// import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

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
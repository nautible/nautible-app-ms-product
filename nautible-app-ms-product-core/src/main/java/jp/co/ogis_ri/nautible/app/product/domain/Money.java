package jp.co.ogis_ri.nautible.app.product.domain;

import java.math.BigDecimal;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Embeddable
@Access(AccessType.FIELD)
public class Money {
    public static Money ZERO = new Money(0);

    @Column(name="price")
    private BigDecimal price;

    Money() {
    }

    public Money(BigDecimal price) {
        this.price = price;
    }

    public Money(int i) {
        this.price = new BigDecimal(i);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (o == null || getClass() != o.getClass())
            return false;

        Money money = (Money) o;

        return new EqualsBuilder().append(price, money.price).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(price).toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("price", price).toString();
    }

    public Money add(Money delta) {
        return new Money(price.add(delta.price));
    }

    public boolean isGreaterThanOrEqual(Money other) {
        return price.compareTo(other.price) >= 0;
    }

    public String asString() {
        return price.toPlainString();
    }

    public Long asLong() {
        return price.longValue();
    }
}
package ru.javaops.topjava2.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity()
@Table(name = "dish")
public class Dish extends NamedEntity{

    @Column(name = "price")
    private Integer price;

    @Override
    public String toString() {
        return super.toString() + ": " + price + ';';
    }

}
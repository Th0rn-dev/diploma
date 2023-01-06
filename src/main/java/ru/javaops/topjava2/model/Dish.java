package ru.javaops.topjava2.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "dish")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Dish extends NamedEntity{

    @Column(name = "price")
    private Integer price;

    @ManyToOne
    @JoinColumn(name = "menu_id")
    private Menu menu;


    @Override
    public String toString() {
        return super.toString() + ": " + price + ';';
    }

}
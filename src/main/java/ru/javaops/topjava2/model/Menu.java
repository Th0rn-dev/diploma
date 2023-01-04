package ru.javaops.topjava2.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import ru.javaops.topjava2.HasId;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@ToString
@Entity()
@Table(name = "day_menu")
public class Menu extends BaseEntity implements HasId, Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Column(name = "created", nullable = false, updatable = false)
    @NotNull
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Date created = new Date();

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

// ToDo пока не понимаю, как в модель завести блюда. оставлю одно.
//  Есть предположение, что это можно сделать через EntityGraph

    @OneToOne
    @JoinColumn(name = "dish_id")
    private Dish dish;

}
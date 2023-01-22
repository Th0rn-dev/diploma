package com.github.Th0rn_dev.restaurants_voting.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
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
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;


@Entity
@Table(name = "dish", uniqueConstraints = {@UniqueConstraint(columnNames = {"display_date", "name", "menu_id"}, name = "dish_unique_display_date_name_menu")})
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Dish extends NamedEntity{

    @Column(name="display_date", nullable = false, updatable = false)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @NotNull
    private LocalDate date;

    @Column(name = "price")
    @NotNull
    private Integer price;

    // https://stackoverflow.com/questions/3325387/infinite-recursion-with-jackson-json-and-hibernate-jpa-issue
    @ManyToOne
    @JoinColumn(name = "menu_id", nullable = false)
    @JsonBackReference
    private Menu menu;

}
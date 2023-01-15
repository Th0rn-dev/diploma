package ru.javaops.topjava2.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import ru.javaops.topjava2.HasId;
import ru.javaops.topjava2.util.ClockUtil;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "vote", uniqueConstraints = {@UniqueConstraint(columnNames = {"voting_day", "user_id"}, name = "vote_unique_voting_day_user")})
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class Vote extends BaseEntity implements HasId, Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Column(name = "voting_day", nullable = false, updatable = false)
    @NotNull
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDate votingDay;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne
    @NotNull
    @JoinColumn(name = "restaurant_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Restaurant restaurant;


    public Vote(Integer id, Restaurant restaurant, User user) {
        super(id);
        this.restaurant = restaurant;
        this.user = user;
    }

    @PrePersist
    public void beforePersist() {
        votingDay = LocalDate.now(ClockUtil.getClock());
    }

}

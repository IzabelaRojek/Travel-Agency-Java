package com.kodilla.travelagency.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TRIPS")
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column
    private String destination;

    @Column
    private String description;

    @Column
    private LocalDate startDate;

    @Column
    private LocalDate stopDate;

    @Column
    private String type;

    @Column
    private BigDecimal price;

    @OneToMany(
            targetEntity = Reservation.class,
            mappedBy = "tripId",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Reservation> reservations;

    public Trip(Long id, String name, String destination, String description, LocalDate startDate, LocalDate stopDate, String type, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.destination = destination;
        this.description = description;
        this.startDate = startDate;
        this.stopDate = stopDate;
        this.type = type;
        this.price = price;
    }
}

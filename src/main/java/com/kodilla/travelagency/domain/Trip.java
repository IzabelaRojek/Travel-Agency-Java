package com.kodilla.travelagency.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    @Column(unique = true)
    private Long id;

    @Column
    private String name;

    @Column
    private String destination;

    @Column
    private String description;

    @Column
    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @Column
    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate stopDate;

    @Column
    private TripType type;

    @Column
    private BigDecimal price;

    @OneToMany(
            targetEntity = Reservation.class,
            mappedBy = "trip",
            cascade = CascadeType.MERGE,
            fetch = FetchType.LAZY
    )
    private List<Reservation> reservations;


    public Trip(Long id, String name, String destination, String description, LocalDate startDate, LocalDate stopDate, TripType type, BigDecimal price) {
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

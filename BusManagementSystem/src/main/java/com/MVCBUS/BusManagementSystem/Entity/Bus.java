package com.MVCBUS.BusManagementSystem.Entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "BUSES")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bus {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bus_seq")
    @SequenceGenerator(name = "bus_seq", sequenceName = "BUS_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "BUS_NUMBER", nullable = false)
    private String busNumber;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "SEATS", nullable = false)
    private int seats;

    @Column(name = "FARE", nullable = false)
    private double fare;

    @Column(name = "SOURCE", nullable = false)
    private String source;

    @Column(name = "DESTINATION", nullable = false)
    private String destination;

    @Column(name = "STARTING_TIME", nullable = false)
    private String startingTime;

    @Column(name = "DEPARTURE_DATE", nullable = false)
    private LocalDate departureDate;

}
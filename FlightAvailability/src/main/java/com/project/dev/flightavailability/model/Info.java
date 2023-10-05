package com.project.dev.flightavailability.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;

import java.util.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name = "info")
public class Info {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "info_id")
    private Long infoId;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @Column(name = "flight_list")
    private List<Flight> flightList;

    @Column(name = "departure_place")
    private String departurePlace;

    @Column(name = "arrival_place")
    private String arrivalPlace;

    @Column(name = "price")
    private int price;

}

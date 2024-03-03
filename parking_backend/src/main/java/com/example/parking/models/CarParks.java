package com.example.parking.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "car_parks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarParks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String carparkName;
    private String postcode;
    private String description;
    private String easting;
    private String northing;
}

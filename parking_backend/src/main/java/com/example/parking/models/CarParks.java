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
    private String Status;
}
//package com.example.parking.models;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name = "carparks")
//public class CarParks {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long id;
//
//    private String carparkName;
//    private String postcode;
//    private String description;
//    private String easting;
//    private String northing;
//    private String status; // Add this field
//
//    // Getters and setters
//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public String getCarparkName() {
//        return carparkName;
//    }
//
//    public void setCarparkName(String carparkName) {
//        this.carparkName = carparkName;
//    }
//
//    public String getPostcode() {
//        return postcode;
//    }
//
//    public void setPostcode(String postcode) {
//        this.postcode = postcode;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public String getEasting() {
//        return easting;
//    }
//
//    public void setEasting(String easting) {
//        this.easting = easting;
//    }
//
//    public String getNorthing() {
//        return northing;
//    }
//
//    public void setNorthing(String northing) {
//        this.northing = northing;
//    }
//
//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }
//}

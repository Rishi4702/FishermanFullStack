package com.example.fisherman.model;

import com.example.fisherman.DTO.LocationDTO;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "location")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "spottype")
    private String spotType;
    @Column(name = "latitude")
    private double latitude;
    @Column(name="longitude")
    private double longitude;
    @Column(name = "description")
    private String description;

    public List<ModelCatch> getModelCatches() {
        return modelCatches;
    }

    public void setModelCatches(List<ModelCatch> modelCatches) {
        this.modelCatches = modelCatches;
    }

    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL)
    private List<ModelCatch> modelCatches = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpotType() {
        return spotType;
    }

    public void setSpotType(String spotType) {
        this.spotType = spotType;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public LocationDTO toDTO(){
        return new LocationDTO().id(BigDecimal.valueOf(this.id)).description(this.description).latitude(this.latitude).longitude(this.longitude).name(this.name).spotType(this.spotType);
    }
}

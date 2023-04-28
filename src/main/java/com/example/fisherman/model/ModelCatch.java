package com.example.fisherman.model;

import com.example.fisherman.DTO.ModelCatchDTO;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class ModelCatch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "length")
    private int length;

    @Column(name = "weight")
    private double weight;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "ModelCatch{" +
                "id=" + id +
                ", length=" + length +
                ", weight=" + weight +
                ", quantity=" + quantity +
                ", species='" + species + '\'' +
                ", fisherman=" + fisherman +
                ", fishSpecies=" + fishSpecies +
                ", location=" + location +
                '}';
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public Fisherman getFisherman() {
        return fisherman;
    }

    public void setFisherman(Fisherman fisherman) {
        this.fisherman = fisherman;
    }

    public FishSpecies getFishSpecies() {
        return fishSpecies;
    }

    public void setFishSpecies(FishSpecies fishSpecies) {
        this.fishSpecies = fishSpecies;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "species")
    private String species;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fisherman_id", nullable = false)
    private Fisherman fisherman;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fish_species_id", nullable = false)
    private FishSpecies fishSpecies;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id", nullable = false)
    private Location location;
    public ModelCatchDTO toDTO() {
        ModelCatchDTO dto = new ModelCatchDTO();
        dto.setLength(BigDecimal.valueOf(this.length));
        dto.setWeight(BigDecimal.valueOf(this.weight));
        dto.setQuantity(BigDecimal.valueOf(this.quantity));
        dto.setSpecies(this.species);
        dto.setFishermanId(BigDecimal.valueOf(this.getFisherman().getId()));
        dto.setFishSpeciesId(BigDecimal.valueOf(this.getFishSpecies().getId()));
        dto.setLocationId(BigDecimal.valueOf(this.getLocation().getId()));
        return dto;
    }




    // constructors, getters, and setters
}

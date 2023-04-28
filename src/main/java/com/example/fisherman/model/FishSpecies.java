package com.example.fisherman.model;

import com.example.fisherman.DTO.FishSpeciesDTO;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "fishspecies")
public class FishSpecies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "Protected")
    private boolean Protected;

    public List<ModelCatch> getModelCatches() {
        return modelCatches;
    }

    public void setModelCatches(List<ModelCatch> modelCatches) {
        this.modelCatches = modelCatches;
    }

    @OneToMany(mappedBy = "fishSpecies", cascade = CascadeType.ALL)
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isProtected() {
        return Protected;
    }

    public void setProtected(boolean aProtected) {
        Protected = aProtected;
    }

    @Override
    public String toString() {
        return "FishSpecies{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", Protected=" + Protected +
                '}';
    }
    public FishSpeciesDTO toDTO(){
       return new FishSpeciesDTO().name(this.getName()).id(BigDecimal.valueOf(this.getId())).description(this.getDescription())._protected(this.Protected);
    }
}

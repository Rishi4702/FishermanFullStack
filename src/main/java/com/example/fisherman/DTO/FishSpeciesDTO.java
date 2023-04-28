package com.example.fisherman.DTO;

import java.util.Objects;

import com.example.fisherman.model.FishSpecies;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import jakarta.annotation.Generated;

/**
 * FishSpecies
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-04-20T08:34:41.907903300+02:00[Europe/Warsaw]")
public class FishSpeciesDTO {

  @JsonProperty("id")
  private BigDecimal id;

  @JsonProperty("name")
  private String name;

  @JsonProperty("description")
  private String description;

  @JsonProperty("protected")
  private Boolean _protected;

  public FishSpeciesDTO id(BigDecimal id) {
    this.id = id;
    return this;
  }

  /**
   * The unique ID of the fish species
   * @return id
  */
  @NotNull @Valid 
  @Schema(name = "id", description = "The unique ID of the fish species", requiredMode = Schema.RequiredMode.REQUIRED)
  public BigDecimal getId() {
    return id;
  }

  public void setId(BigDecimal id) {
    this.id = id;
  }

  public FishSpeciesDTO name(String name) {
    this.name = name;
    return this;
  }

  /**
   * The common name of the fish species
   * @return name
  */
  @NotNull 
  @Schema(name = "name", description = "The common name of the fish species", requiredMode = Schema.RequiredMode.REQUIRED)
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public FishSpeciesDTO description(String description) {
    this.description = description;
    return this;
  }

  /**
   * A description of the fish species
   * @return description
  */
  @NotNull 
  @Schema(name = "description", description = "A description of the fish species", requiredMode = Schema.RequiredMode.REQUIRED)
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public FishSpeciesDTO _protected(Boolean _protected) {
    this._protected = _protected;
    return this;
  }

  /**
   * true when the fish is protected by the government
   * @return _protected
  */
  @NotNull 
  @Schema(name = "protected", description = "true when the fish is protected by the government", requiredMode = Schema.RequiredMode.REQUIRED)
  public Boolean getProtected() {
    return _protected;
  }

  public void setProtected(Boolean _protected) {
    this._protected = _protected;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FishSpeciesDTO fishSpecies = (FishSpeciesDTO) o;
    return Objects.equals(this.id, fishSpecies.id) &&
        Objects.equals(this.name, fishSpecies.name) &&
        Objects.equals(this.description, fishSpecies.description) &&
        Objects.equals(this._protected, fishSpecies._protected);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, description, _protected);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FishSpecies {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    _protected: ").append(toIndentedString(_protected)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

  public FishSpecies toModel(){
    FishSpecies f= new FishSpecies();
    f.setName(this.name);
    f.setProtected(this._protected);
    f.setDescription(this.description);
//    f.setId((this.id.longValue()));
    return f;
  }
}


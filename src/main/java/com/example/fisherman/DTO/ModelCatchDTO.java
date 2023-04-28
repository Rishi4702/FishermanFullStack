package com.example.fisherman.DTO;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.math.BigDecimal;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import jakarta.annotation.Generated;

/**
 * ModelCatch
 */

@JsonTypeName("Catch")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-04-20T08:34:41.907903300+02:00[Europe/Warsaw]")
public class ModelCatchDTO {

  @JsonProperty("species")
  private String species;

  @JsonProperty("length")
  private BigDecimal length;

  @JsonProperty("weight")
  private BigDecimal weight;

  @JsonProperty("quantity")
  private BigDecimal quantity;

  @JsonProperty("locationId")
  private BigDecimal locationId;

  @JsonProperty("fishermanId")
  private BigDecimal fishermanId;

  @JsonProperty("fishSpeciesId")
  private BigDecimal fishSpeciesId;

  public ModelCatchDTO species(String species) {
    this.species = species;
    return this;
  }

  /**
   * Get species
   * @return species
  */
  @NotNull 
  @Schema(name = "species", requiredMode = Schema.RequiredMode.REQUIRED)
  public String getSpecies() {
    return species;
  }

  public void setSpecies(String species) {
    this.species = species;
  }

  public ModelCatchDTO length(BigDecimal length) {
    this.length = length;
    return this;
  }

  /**
   * Get length
   * @return length
  */
  @NotNull @Valid 
  @Schema(name = "length", requiredMode = Schema.RequiredMode.REQUIRED)
  public BigDecimal getLength() {
    return length;
  }

  public void setLength(BigDecimal length) {
    this.length = length;
  }

  public ModelCatchDTO weight(BigDecimal weight) {
    this.weight = weight;
    return this;
  }

  /**
   * Get weight
   * @return weight
  */
  @NotNull @Valid 
  @Schema(name = "weight", requiredMode = Schema.RequiredMode.REQUIRED)
  public BigDecimal getWeight() {
    return weight;
  }

  public void setWeight(BigDecimal weight) {
    this.weight = weight;
  }

  public ModelCatchDTO quantity(BigDecimal quantity) {
    this.quantity = quantity;
    return this;
  }

  /**
   * Get quantity
   * @return quantity
  */
  @NotNull @Valid 
  @Schema(name = "quantity", requiredMode = Schema.RequiredMode.REQUIRED)
  public BigDecimal getQuantity() {
    return quantity;
  }

  public void setQuantity(BigDecimal quantity) {
    this.quantity = quantity;
  }

  public ModelCatchDTO locationId(BigDecimal locationId) {
    this.locationId = locationId;
    return this;
  }

  /**
   * Get locationId
   * @return locationId
  */
  @NotNull @Valid 
  @Schema(name = "locationId", requiredMode = Schema.RequiredMode.REQUIRED)
  public BigDecimal getLocationId() {
    return locationId;
  }

  public void setLocationId(BigDecimal locationId) {
    this.locationId = locationId;
  }

  public ModelCatchDTO fishermanId(BigDecimal fishermanId) {
    this.fishermanId = fishermanId;
    return this;
  }

  /**
   * Get fishermanId
   * @return fishermanId
  */
  @NotNull @Valid 
  @Schema(name = "fishermanId", requiredMode = Schema.RequiredMode.REQUIRED)
  public BigDecimal getFishermanId() {
    return fishermanId;
  }

  public void setFishermanId(BigDecimal fishermanId) {
    this.fishermanId = fishermanId;
  }

  public ModelCatchDTO fishSpeciesId(BigDecimal fishSpeciesId) {
    this.fishSpeciesId = fishSpeciesId;
    return this;
  }

  /**
   * Get fishSpeciesId
   * @return fishSpeciesId
  */
  @NotNull @Valid 
  @Schema(name = "fishSpeciesId", requiredMode = Schema.RequiredMode.REQUIRED)
  public BigDecimal getFishSpeciesId() {
    return fishSpeciesId;
  }

  public void setFishSpeciesId(BigDecimal fishSpeciesId) {
    this.fishSpeciesId = fishSpeciesId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ModelCatchDTO _catch = (ModelCatchDTO) o;
    return Objects.equals(this.species, _catch.species) &&
        Objects.equals(this.length, _catch.length) &&
        Objects.equals(this.weight, _catch.weight) &&
        Objects.equals(this.quantity, _catch.quantity) &&
        Objects.equals(this.locationId, _catch.locationId) &&
        Objects.equals(this.fishermanId, _catch.fishermanId) &&
        Objects.equals(this.fishSpeciesId, _catch.fishSpeciesId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(species, length, weight, quantity, locationId, fishermanId, fishSpeciesId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ModelCatch {\n");
    sb.append("    species: ").append(toIndentedString(species)).append("\n");
    sb.append("    length: ").append(toIndentedString(length)).append("\n");
    sb.append("    weight: ").append(toIndentedString(weight)).append("\n");
    sb.append("    quantity: ").append(toIndentedString(quantity)).append("\n");
    sb.append("    locationId: ").append(toIndentedString(locationId)).append("\n");
    sb.append("    fishermanId: ").append(toIndentedString(fishermanId)).append("\n");
    sb.append("    fishSpeciesId: ").append(toIndentedString(fishSpeciesId)).append("\n");
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
}


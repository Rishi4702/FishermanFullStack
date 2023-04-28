package com.example.fisherman.DTO;

import java.util.Objects;

import com.example.fisherman.model.Fisherman;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import jakarta.annotation.Generated;

/**
 * Fisherman
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-04-20T08:34:41.907903300+02:00[Europe/Warsaw]")
public class FishermanDTO {

  @JsonProperty("id")
  private BigDecimal id;

  @JsonProperty("name")
  private String name;

  @JsonProperty("password")
  private String password;

  @JsonProperty("age")
  private Integer age;

  @JsonProperty("email")
  private String email;

  @JsonProperty("phone")
  private String phone;

  public FishermanDTO id(BigDecimal id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  @NotNull @Valid 
  @Schema(name = "id", requiredMode = Schema.RequiredMode.REQUIRED)
  public BigDecimal getId() {
    return id;
  }

  public void setId(BigDecimal id) {
    this.id = id;
  }

  public FishermanDTO name(String name) {
    this.name = name;
    return this;
  }

  public Fisherman tomodel(){
    return new Fisherman(this.name,this.password,this.age,this.email,this.phone);
  }

  /**
   * Get name
   * @return name
  */
  @NotNull 
  @Schema(name = "name", requiredMode = Schema.RequiredMode.REQUIRED)
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public FishermanDTO password(String password) {
    this.password = password;
    return this;
  }

  /**
   * Get password
   * @return password
  */
  @NotNull 
  @Schema(name = "password", requiredMode = Schema.RequiredMode.REQUIRED)
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public FishermanDTO age(Integer age) {
    this.age = age;
    return this;
  }

  /**
   * Get age
   * minimum: 18
   * maximum: 99
   * @return age
  */
  @NotNull @Min(18) @Max(99) 
  @Schema(name = "age", requiredMode = Schema.RequiredMode.REQUIRED)
  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public FishermanDTO email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Get email
   * @return email
  */
  @NotNull @Email
  @Schema(name = "email", requiredMode = Schema.RequiredMode.REQUIRED)
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public FishermanDTO phone(String phone) {
    this.phone = phone;
    return this;
  }

  /**
   * Get phone
   * @return phone
  */
  @NotNull 
  @Schema(name = "phone", requiredMode = Schema.RequiredMode.REQUIRED)
  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FishermanDTO fisherman = (FishermanDTO) o;
    return Objects.equals(this.id, fisherman.id) &&
        Objects.equals(this.name, fisherman.name) &&
        Objects.equals(this.password, fisherman.password) &&
        Objects.equals(this.age, fisherman.age) &&
        Objects.equals(this.email, fisherman.email) &&
        Objects.equals(this.phone, fisherman.phone);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, password, age, email, phone);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Fisherman {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
    sb.append("    age: ").append(toIndentedString(age)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    phone: ").append(toIndentedString(phone)).append("\n");
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


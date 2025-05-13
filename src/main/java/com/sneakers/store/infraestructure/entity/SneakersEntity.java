package com.sneakers.store.infraestructure.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SneakersEntity {
    @JsonProperty("id")
    private String id;

    @JsonProperty("brand")
    private String brand;

    @JsonProperty("color")
    private String color;

    @JsonProperty("colorway")
    private String colorway;

    @JsonProperty("estimatedMarketValue")
    private int estimatedMarketValue;

    @JsonProperty("gender")
    private String gender;

    @JsonProperty("image")
    private ImagesSneakersEntity images;

    @JsonProperty("links")
    private StoreLinksEntity links;

    @JsonProperty("name")
    private String name;

    @JsonProperty("releaseDate")
    private String releaseDate;

    @JsonProperty("releaseYear")
    private String releaseYear;

    @JsonProperty("retailPrice")
    private int retailPrice;

    @JsonProperty("silhouette")
    private String silhouette;

    @JsonProperty("sku")
    private String sku;

    @JsonProperty("story")
    private String story;
}

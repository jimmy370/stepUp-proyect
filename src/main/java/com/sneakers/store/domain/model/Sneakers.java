package com.sneakers.store.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.awt.*;

@Builder
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Sneakers {
    private String id;
    private String sku;
    private String brand;
    private String name;
    private String colorway;
    private String gender;
    private String silhouette;
    private String releaseYear;
    private String releaseDate;
    private int retailPrice;
    private int estimatedMarketValue;
    private String story;
    private ImagesSneakers image;
    private StoreLinks links;
}

package com.sneakers.store.infraestructure.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ImagesSneakersEntity {
    private List<String> _360;
    private String original;
    private String small;
    private String thumbnail;
}

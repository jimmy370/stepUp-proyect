package com.sneakers.store.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ImagesSneakers {
    private List<String> _360;
    private String original;
    private String small;
    private String thumbnail;
}

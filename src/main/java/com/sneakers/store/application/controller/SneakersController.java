package com.sneakers.store.application.controller;

import com.sneakers.store.domain.model.*;
import com.sneakers.store.domain.service.SneakersApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class SneakersController {

    @Autowired
    private SneakersApi sneakersApi;

    @GetMapping
    public SneakersResponse getSneakersByCriteria(@RequestBody RequestCriteria requestCriteria) {
        return sneakersApi.getAllSneakers(requestCriteria);
    }

    @GetMapping("/get/{name}")
    public BrandsAndGenders getBrands(@PathVariable String name) {
        return sneakersApi.getBrandOrGender(name);
    }

}

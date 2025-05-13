package com.sneakers.store.domain.service;

import com.sneakers.store.domain.model.*;

public interface SneakersApi {

    SneakersResponse getAllSneakers(RequestCriteria requestCriteria);

    BrandsAndGenders getBrandOrGender(String name);
}

package com.sneakers.store.domain.port;

import com.sneakers.store.domain.model.BrandsAndGendersResponse;
import com.sneakers.store.domain.model.SneakersResponse;

public interface SneakersPort {

    SneakersResponse getAllSneakers(String url3);

    BrandsAndGendersResponse getBrandsOrGender(String nameUrl);
}

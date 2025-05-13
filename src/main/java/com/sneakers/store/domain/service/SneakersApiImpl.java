package com.sneakers.store.domain.service;

import com.sneakers.store.domain.model.*;
import com.sneakers.store.domain.port.SneakersPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class SneakersApiImpl implements SneakersApi {
    @Autowired
    private SneakersPort sneakersPort;

    private static final String url2="/sneakers";
    public SneakersApiImpl(SneakersPort sneakersPort) {
        this.sneakersPort = sneakersPort;
    }

    @Override
    public SneakersResponse getAllSneakers(RequestCriteria requestCriteria) {
        String url = "?limit=" + requestCriteria.getLimit();
        System.out.println(requestCriteria);
        List<String> params = new ArrayList<>();
        for (Criteria criteria : requestCriteria.getCriteria()) {
            String param = criteria.getNameField() + "=" + criteria.getValue();
            params.add(param);
        }
        if (!params.isEmpty()) {
            url += "&" + String.join("&", params);
        }
        return sneakersPort.getAllSneakers(url);
    }

    @Override
    public BrandsAndGenders getBrandOrGender(String name) {
        var results = sneakersPort.getBrandsOrGender(name);
        if (name.equalsIgnoreCase("brands")){
            return BrandsAndGenders
                    .builder()
                    .brands(results.getResults())
                    .build();
        }
        return BrandsAndGenders
                .builder()
                .genders(results.getResults())
                .build();
    }
}

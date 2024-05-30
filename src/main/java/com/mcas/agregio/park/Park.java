package com.mcas.agregio.park;

import java.util.Objects;

import lombok.Getter;

// Electricity Production Park
@Getter
public class Park {
    private final int id;

    private final String name;

    private final ProductionType productionType;

    public Park(String name, ProductionType productionType) {
        this.id = Objects.hash(name);
        this.name = name;
        this.productionType = productionType;
    }
}

package com.mcas.agregio.park;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

// Electricity Production Park
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Park {
    private int id;

    private String name;

    private ProductionType productionType;
}

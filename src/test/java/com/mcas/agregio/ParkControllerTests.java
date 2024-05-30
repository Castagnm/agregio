package com.mcas.agregio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mcas.agregio.market.Market;
import com.mcas.agregio.park.Park;
import com.mcas.agregio.park.ParkController;
import com.mcas.agregio.park.ProductionType;

class ParkControllerTests {

    private ParkController parkController;

    @BeforeEach
    void beforeEach() {
        parkController = new ParkController();
    }

    @Test
    void shouldBuildPark() {
        // Given
        String name = "SunPower";
        ProductionType productionType = ProductionType.SOLAR;
        // When
        Park park = parkController.createPark(name, productionType);
        // Then
        assertNotNull(park);
        assertNotNull(park.getId());
        assertEquals(name, park.getName());
        assertEquals(productionType, park.getProductionType());
    }

    @Test
    void shouldReturnListOfParksForMarket() {
        // Given
        Market market = Market.PRIMARY_RESERVE;
        // When
        List<Park> parks = parkController.getSellingParks(market);
        // Then
        assertNotNull(parks);
    }
}

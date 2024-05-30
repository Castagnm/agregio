package com.mcas.agregio.park;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mcas.agregio.market.Market;

@ExtendWith(MockitoExtension.class)
class ParkControllerTests {

    @Mock
    private ParkService parkService;

    @InjectMocks
    private ParkController parkController;

    @Test
    void shouldBuildPark() {
        // Given
        String name = "SunPower";
        int id = Objects.hash(name);
        ProductionType productionType = ProductionType.SOLAR;
        Park park = new Park(id, name, productionType);
        when(parkService.savePark(park)).thenReturn(id);
        // When
        int returnedId = parkController.createPark(park);
        // Then
        assertEquals(returnedId, park.getId());
    }

    @Test
    void shouldReturnListOfParksForMarket() {
        // Given
        Market market = Market.PRIMARY_RESERVE;
        Set<Park> parks = new HashSet<>();
        when(parkService.getParks(market)).thenReturn(parks);
        // When
        Set<Park> returnedParks = parkController.getSellingParks(market);
        // Then
        assertEquals(returnedParks, parks);
    }
}

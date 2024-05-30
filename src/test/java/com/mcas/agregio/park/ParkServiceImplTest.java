package com.mcas.agregio.park;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mcas.agregio.block.Block;
import com.mcas.agregio.block.BlockService;
import com.mcas.agregio.market.Market;
import com.mcas.agregio.offer.Offer;
import com.mcas.agregio.offer.OfferService;

@ExtendWith(MockitoExtension.class)
class ParkServiceImplTest {

    @Mock
    private BlockService blockService;

    @InjectMocks
    private ParkServiceImpl parkService;

    @Test
    void shouldReturnIntOnParkSave() {
        // Given
        String name = "SunPower";
        int id = Objects.hash(name);
        ProductionType productionType = ProductionType.SOLAR;
        Park park = new Park(id, name, productionType);
        // When
        int returnedId = parkService.savePark(park);
        // Then
        assertEquals(id, returnedId);
    }

    @Test
    void shouldReturnListPark() {
        // Given
        Market market = Market.PRIMARY_RESERVE;
        // When
        Set<Park> parks = parkService.getParks(market);
        // Then
        assertNotNull(parks);
    }

    @Test
    void shouldReturnExpectedListParkForMarket() {
        // Given
        Market market = Market.PRIMARY_RESERVE;
        
        String nameSunPower = "SunPower";
        Park sunParkProducer = new Park(Objects.hash(nameSunPower), nameSunPower, ProductionType.SOLAR);
        parkService.savePark(sunParkProducer);

        Map<Park, Integer> blockProducers = new HashMap<>();
        blockProducers.put(sunParkProducer, 300);

        Offer offer = new Offer(0, Market.PRIMARY_RESERVE);
        Block block = new Block(3, 50, offer, blockProducers);

        when(blockService.getBlocks(market)).thenReturn(List.of(block));
        // When
        Set<Park> parks = parkService.getParks(market);
        // Then
        assertTrue(parks.stream().anyMatch(e -> e.equals(sunParkProducer)));
    }
}

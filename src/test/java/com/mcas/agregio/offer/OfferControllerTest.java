package com.mcas.agregio.offer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mcas.agregio.market.Market;
import com.mcas.agregio.park.Park;
import com.mcas.agregio.park.ProductionType;

@ExtendWith(MockitoExtension.class)
class OfferControllerTest {

    @Mock
    private OfferService offerService;

    @InjectMocks
    private OfferController offerController;

    @Test
    void shouldCreateOffer() {
        // Given
        Offer offer = buildMockOffer();
        when(offerService.saveOffer(offer)).thenReturn(offer);
        // When
        Offer returnedOffer = offerController.createOffer(offer);
        // Then
        assertEquals(offer, returnedOffer);
    }

    @Test
    void shouldReturnMarketOffers() {
        // Given
        Market market = Market.PRIMARY_RESERVE;
        List<Offer> offers = List.of(buildMockOffer());
        when(offerService.getOffers(market)).thenReturn(offers);
        // When
        List<Offer> returnedOffers = offerController.getOffers(market);
        // Then
        assertEquals(offers, returnedOffers);
    }

    private Offer buildMockOffer() {
        String parkName = "SunPower";
        Park park = new Park(Objects.hash(parkName), parkName, ProductionType.SOLAR);
        Map<Park, Integer> producers = new HashMap<>();
        producers.put(park, 300);
        Block block = new Block(5, 50, producers);
        Offer offer = new Offer(List.of(block));
        return offer;

    }
}

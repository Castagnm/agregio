package com.mcas.agregio.offer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mcas.agregio.market.Market;

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
        Offer offer = new Offer(1, Market.PRIMARY_RESERVE);
        return offer;

    }
}

package com.mcas.agregio.block;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mcas.agregio.market.Market;
import com.mcas.agregio.offer.Offer;
import com.mcas.agregio.offer.OfferService;

@Service
public class BlockServiceImpl implements BlockService {

    private final List<Block> blocks;

    private final OfferService offerService;

    public BlockServiceImpl(OfferService offerService) {
        this.offerService = offerService;
        this.blocks = new ArrayList<>();
    }

    public Block saveBlock(Block block) {
        blocks.add(block);
        return block;
    }

    public List<Block> getBlocks(Market market) {
        List<Offer> offers = offerService.getOffers(market);
        return blocks.stream().filter(e -> offers.contains(e.getOffer())).toList();
    }
}

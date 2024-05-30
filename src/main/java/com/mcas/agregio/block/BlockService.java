package com.mcas.agregio.block;

import java.util.List;

import com.mcas.agregio.market.Market;

public interface BlockService {

    Block saveBlock(Block block);
    
    List<Block> getBlocks(Market market);
}

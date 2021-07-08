package com.yangdq.java.designpattern.adapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FishingBoat {
    public static Logger logger = LoggerFactory.getLogger(FishingBoat.class);

    void sail() {
        logger.info("The fishing boat is sailing");
    }
}

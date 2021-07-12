package com.yangdq.java.designpattern.bridge;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SoulEatingEnchantment implements Enchantment {
    public final Logger logger = LoggerFactory.getLogger(SoulEatingEnchantment.class);

    @Override
    public void onActivate() {
        logger.info("The item spreads bloodlust.");
    }

    @Override
    public void apply() {
        logger.info("The item eats the soul of enemies.");
    }

    @Override
    public void onDeactivate() {
        logger.info("Bloodlust slowly disappears.");
    }
}

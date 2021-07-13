package com.yangdq.java.designpattern.builder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {
    public final static Logger LOGGER = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        Hero hero = new Hero.Builder(Profession.MAGE, "hero").withHairColor(HairColor.BLACK).build();
        LOGGER.info(hero.toString());
    }
}

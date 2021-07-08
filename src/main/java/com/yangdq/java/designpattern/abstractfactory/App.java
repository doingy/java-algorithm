package com.yangdq.java.designpattern.abstractfactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 抽象工厂哦死
 * https://java-design-patterns.com/patterns/abstract-factory/
 */
public class App {
    public static Logger logger = LoggerFactory.getLogger(App.class);

    private Army army;
    private Castle castle;
    private King king;

    public static class FactoryMaker {
        public enum KingdomType {
            ELF, ORC
        }

        public static KingdomFactory makeFactory(KingdomType type) {
            switch (type) {
                case ELF -> {
                    return new ElfKingdomFactory();
                }
                case ORC -> {
                    return new OrcKingdomFactory();
                }
                default -> {
                    throw new IllegalArgumentException("KingdomType not supported");
                }
            }
        }
    }

    public static void main(String[] args) {
        var app = new App();

        logger.info("ELF Kingdom");
        app.createKindom(FactoryMaker.makeFactory(FactoryMaker.KingdomType.ELF));
        logger.info(app.getArmy().getDescription());
        logger.info(app.getKing().getDescription());
        logger.info(app.getCastle().getDescription());

        logger.info("Orc Kingdom");
        app.createKindom(FactoryMaker.makeFactory(FactoryMaker.KingdomType.ORC));
        logger.info(app.getArmy().getDescription());
        logger.info(app.getKing().getDescription());
        logger.info(app.getCastle().getDescription());
    }

    private void createKindom(KingdomFactory kingdomFactory) {
        setArmy(kingdomFactory.createArmy());
        setKing(kingdomFactory.createKing());
        setCastle(kingdomFactory.createCastle());
    }

    public Army getArmy() {
        return army;
    }

    public void setArmy(Army army) {
        this.army = army;
    }

    public Castle getCastle() {
        return castle;
    }

    public void setCastle(Castle castle) {
        this.castle = castle;
    }

    public King getKing() {
        return king;
    }

    public void setKing(King king) {
        this.king = king;
    }
}

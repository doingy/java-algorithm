package com.yangdq.java.designpattern.abstractfactory;

public interface KingdomFactory {
    King createKing();

    Castle createCastle();

    Army createArmy();
}

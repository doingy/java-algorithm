package com.yangdq.java.designpattern.adapter;

public class App {
    public static void main(String[] args) {
        Captain captain = new Captain(new FishingBoatAdapter());
        captain.row();
    }
}

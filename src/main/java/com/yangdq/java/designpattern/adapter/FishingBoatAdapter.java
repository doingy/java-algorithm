package com.yangdq.java.designpattern.adapter;

public class FishingBoatAdapter implements RowingBoat {
    private final FishingBoat fishingBoat;

    public FishingBoatAdapter() {
        fishingBoat = new FishingBoat();
    }

    @Override

    public void row() {
        fishingBoat.sail();
    }
}

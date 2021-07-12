package com.yangdq.java.designpattern.bridge;

public class App {
    public static void main(String[] args) {
        var sword = new Sword(new SoulEatingEnchantment());
        sword.wield();
        sword.swing();
        sword.unwield();

        var hammer = new Sword(new FlyingEnchantment());
        hammer.wield();
        hammer.swing();
        hammer.unwield();
    }
}

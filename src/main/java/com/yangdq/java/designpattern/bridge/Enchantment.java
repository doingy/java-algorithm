package com.yangdq.java.designpattern.bridge;

/**
 * 附魔
 */
public interface Enchantment {
    void onActivate();

    void apply();

    void onDeactivate();
}

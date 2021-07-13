package com.yangdq.java.designpattern.builder;

public final class Hero {
    private final Profession profession;
    private final String name;
    private final HairColor hairColor;
    private final HairType hairType;
    private final Weapon weapon;
    private final Armor armor;

    public Hero(Profession profession, String name, HairColor hairColor, HairType hairType, Weapon weapon, Armor armor) {
        this.profession = profession;
        this.name = name;
        this.hairColor = hairColor;
        this.hairType = hairType;
        this.weapon = weapon;
        this.armor = armor;
    }

    private Hero(Builder builder) {
        this.profession = builder.profession;
        this.name = builder.name;
        this.hairColor = builder.hairColor;
        this.hairType = builder.hairType;
        this.weapon = builder.weapon;
        this.armor = builder.armor;
    }

    public static class Builder {
        private final Profession profession;
        private final String name;
        private HairColor hairColor;
        private HairType hairType;
        private Weapon weapon;
        private Armor armor;

        public Builder(Profession profession, String name) {
            this.profession = profession;
            this.name = name;
        }

        public Builder withHairType(HairType hairType) {
            this.hairType = hairType;
            return this;
        }

        public Builder withHairColor(HairColor hairColor) {
            this.hairColor = hairColor;
            return this;
        }

        public Builder withWeapon(Weapon weapon) {
            this.weapon = weapon;
            return this;
        }

        public Builder withArmor(Armor armor) {
            this.armor = armor;
            return this;
        }

        public Hero build() {
            return new Hero(this);
        }
    }
}

package com.game.model.impl;

import com.game.model.Weapon;

public class Bow implements Weapon {
    @Override
    public void attack() { System.out.println("Long-range bow shot! Damage: 22"); }
    @Override
    public int getDamage() { return 22; }
}
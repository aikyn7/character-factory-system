package com.game.model.impl;
import com.game.model.Weapon;

public class Dagger implements Weapon {
    @Override public void attack() { System.out.println("Swift dagger strike! Damage: 20"); }
    @Override public int getDamage() { return 20; }
}
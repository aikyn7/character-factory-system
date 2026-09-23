package com.game.model.impl;
import com.game.model.Weapon;

public class Sword implements Weapon {
    @Override public void attack() { System.out.println("Sword slash! Damage: 25"); }
    @Override public int getDamage() { return 25; }
}
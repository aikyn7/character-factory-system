package com.game.model.impl;
import com.game.model.Weapon;

public class Staff implements Weapon {
    @Override public void attack() { System.out.println("Magic staff bolt! Damage: 15"); }
    @Override public int getDamage() { return 15; }
}
package com.game.model.impl;
import com.game.model.Armor;

public class LeatherArmor implements Armor {
    @Override public void defend() { System.out.println("Leather armor allows dodging. Defense: 20"); }
    @Override public int getDefense() { return 20; }
}
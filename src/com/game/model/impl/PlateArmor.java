package com.game.model.impl;
import com.game.model.Armor;

public class PlateArmor implements Armor {
    @Override public void defend() { System.out.println("Plate armor blocks incoming damage. Defense: 40"); }
    @Override public int getDefense() { return 40; }
}
package com.game.model.impl;
import com.game.model.Armor;

public class Robe implements Armor {
    @Override public void defend() { System.out.println("Magic robe absorbs spell damage. Defense: 10"); }
    @Override public int getDefense() { return 10; }
}
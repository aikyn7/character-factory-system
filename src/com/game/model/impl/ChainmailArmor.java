package com.game.model.impl;

import com.game.model.Armor;

public class ChainmailArmor implements Armor {
    @Override
    public void defend() { System.out.println("Chainmail provides flexible protection. Defense: 25"); }
    @Override
    public int getDefense() { return 25; }
}
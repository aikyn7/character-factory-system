package com.game.model.impl;
import com.game.model.Skill;

public class BattleCry implements Skill {
    @Override public void use() { System.out.println("Skill activated: Battle Cry!"); }
}
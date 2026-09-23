package com.game.model.impl;
import com.game.model.Skill;

public class Stealth implements Skill {
    @Override public void use() { System.out.println("Skill activated: Stealth!"); }
}
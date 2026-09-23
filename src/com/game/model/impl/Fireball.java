package com.game.model.impl;
import com.game.model.Skill;

public class Fireball implements Skill {
    @Override public void use() { System.out.println("Skill activated: Fireball!"); }
}
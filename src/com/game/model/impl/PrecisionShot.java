package com.game.model.impl;

import com.game.model.Skill;

public class PrecisionShot implements Skill {
    @Override
    public void use() { System.out.println("Skill activated: Precision Shot!"); }
}
package com.game.factory.method;

import com.game.model.Weapon;
import com.game.model.impl.Sword;

public class WarriorWeaponCreator extends WeaponCreator {
    @Override
    protected Weapon createWeapon() {
        return new Sword();
    }
}
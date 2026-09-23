package com.game.factory.method;

import com.game.model.Weapon;
import com.game.model.impl.Staff;

public class MageWeaponCreator extends WeaponCreator {
    @Override
    protected Weapon createWeapon() {
        return new Staff();
    }
}
package com.game.factory.method;

import com.game.model.Weapon;
import com.game.model.impl.Bow;

public class ArcherWeaponCreator extends WeaponCreator {
    @Override
    protected Weapon createWeapon() { return new Bow(); }
}
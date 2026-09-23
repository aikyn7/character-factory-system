package com.game.factory.method;

import com.game.model.Weapon;
import com.game.model.impl.Dagger;

public class RogueWeaponCreator extends WeaponCreator {
    @Override
    protected Weapon createWeapon() {
        return new Dagger();
    }
}
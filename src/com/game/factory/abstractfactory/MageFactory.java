package com.game.factory.abstractfactory;

import com.game.model.Armor;
import com.game.model.Skill;
import com.game.model.Weapon;
import com.game.model.impl.Fireball;
import com.game.model.impl.Robe;
import com.game.model.impl.Staff;

public class MageFactory implements CharacterEquipmentFactory {
    @Override
    public Weapon createWeapon() {
        return new Staff();
    }

    @Override
    public Armor createArmor() {
        return new Robe();
    }

    @Override
    public Skill createSkill() {
        return new Fireball();
    }
}
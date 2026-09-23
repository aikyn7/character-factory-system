package com.game.factory.abstractfactory;

import com.game.model.Armor;
import com.game.model.Skill;
import com.game.model.Weapon;
import com.game.model.impl.Dagger;
import com.game.model.impl.LeatherArmor;
import com.game.model.impl.Stealth;

public class RogueFactory implements CharacterEquipmentFactory {
    @Override
    public Weapon createWeapon() {
        return new Dagger();
    }

    @Override
    public Armor createArmor() {
        return new LeatherArmor();
    }

    @Override
    public Skill createSkill() {
        return new Stealth();
    }
}
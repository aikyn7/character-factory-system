package com.game.factory.abstractfactory;

import com.game.model.Armor;
import com.game.model.Skill;
import com.game.model.Weapon;
import com.game.model.impl.BattleCry;
import com.game.model.impl.PlateArmor;
import com.game.model.impl.Sword;

public class WarriorFactory implements CharacterEquipmentFactory {
    @Override
    public Weapon createWeapon() {
        return new Sword();
    }

    @Override
    public Armor createArmor() {
        return new PlateArmor();
    }

    @Override
    public Skill createSkill() {
        return new BattleCry();
    }
}
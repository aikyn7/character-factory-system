package com.game.factory.abstractfactory;

import com.game.model.Armor;
import com.game.model.Skill;
import com.game.model.Weapon;

public interface CharacterEquipmentFactory {
    Weapon createWeapon();
    Armor createArmor();
    Skill createSkill();
}
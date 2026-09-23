package com.game.factory.abstractfactory;

import com.game.model.Armor;
import com.game.model.Skill;
import com.game.model.Weapon;
import com.game.model.impl.Bow;
import com.game.model.impl.ChainmailArmor;
import com.game.model.impl.PrecisionShot;

public class ArcherFactory implements CharacterEquipmentFactory {
    @Override
    public Weapon createWeapon() { return new Bow(); }
    @Override
    public Armor createArmor() { return new ChainmailArmor(); }
    @Override
    public Skill createSkill() { return new PrecisionShot(); }
}
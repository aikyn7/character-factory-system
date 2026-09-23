package com.game.client;

import com.game.factory.abstractfactory.CharacterEquipmentFactory;
import com.game.model.Armor;
import com.game.model.Skill;
import com.game.model.Weapon;

public class GameClient {
    private final Weapon weapon;
    private final Armor armor;
    private final Skill skill;

    // working with only abstract factory
    public GameClient(CharacterEquipmentFactory factory) {
        this.weapon = factory.createWeapon();
        this.armor = factory.createArmor();
        this.skill = factory.createSkill();
    }

    // preparation to battle
    public void prepareForCombat() {
        System.out.println("\n=== Business Operation 1: Combat Readiness Inspection ===");
        System.out.println("Equipped Weapon Damage: " + weapon.getDamage());
        System.out.println("Equipped Armor Defense: " + armor.getDefense());
        int totalCombatPower = (weapon.getDamage() * 2) + armor.getDefense();
        System.out.println("Total Estimated Combat Power: " + totalCombatPower);
    }

    // scenario 2 making combo
    public void executeCombatSequence() {
        System.out.println("\n=== Business Operation 2: Executing Attack Combo ===");
        System.out.print("[Step 1 - Tactical Buff]: ");
        skill.use();

        System.out.print("[Step 2 - Primary Strike]: ");
        weapon.attack();

        System.out.print("[Step 3 - Defensive Stance]: ");
        armor.defend();
    }

    // scenario 3 damage with equipment
    public void receiveEnemyAttack(int incomingDamage) {
        System.out.println("\n=== Business Operation 3: Incoming Enemy Attack ===");
        System.out.println("Incoming Raw Damage: " + incomingDamage);

        int actualDamage = Math.max(0, incomingDamage - armor.getDefense());
        armor.defend();

        System.out.println("Damage absorbed by armor: " + (incomingDamage - actualDamage));
        System.out.println("Final Health Points Lost: " + actualDamage);

        if (actualDamage > 0) {
            System.out.print("Counter-attack triggered: ");
            weapon.attack();
        }
    }
}
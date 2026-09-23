package com.game.factory.method;

import com.game.model.Weapon;

public abstract class WeaponCreator {

    // Factory Method - implemented by subclasses
    protected abstract Weapon createWeapon();

    // Business Logic using the created Product
    public Weapon prepareWeaponForBattle() {
        Weapon weapon = createWeapon();

        System.out.println("\n=== Weapon Guild: Preparing Weapon ===");
        System.out.println("Retrieved weapon type: " + weapon.getClass().getSimpleName());

        int baseDamage = weapon.getDamage();
        System.out.println("Base damage: " + baseDamage);
        System.out.println("Weapon inspected, sharpened, and balanced!");

        System.out.print("Test swing: ");
        weapon.attack();

        return weapon;
    }
}
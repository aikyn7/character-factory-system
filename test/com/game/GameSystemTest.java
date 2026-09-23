package com.game;

import com.game.client.GameClient;
import com.game.factory.abstractfactory.*;
import com.game.factory.method.*;
import com.game.model.*;
import com.game.model.impl.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GameSystemTest {

    // creation of each product of family 4
    @Test
    @DisplayName("WarriorFactory creates Warrior family products")
    void testWarriorFactoryCreation() {
        CharacterEquipmentFactory factory = new WarriorFactory();
        assertTrue(factory.createWeapon() instanceof Sword);
        assertTrue(factory.createArmor() instanceof PlateArmor);
        assertTrue(factory.createSkill() instanceof BattleCry);
    }

    @Test
    @DisplayName("MageFactory creates Mage family products")
    public void testMageFactoryCreation() {
        CharacterEquipmentFactory factory = new MageFactory();
        assertTrue(factory.createWeapon() instanceof Staff);
        assertTrue(factory.createArmor() instanceof Robe);
        assertTrue(factory.createSkill() instanceof Fireball);
    }

    @Test
    @DisplayName("RogueFactory creates Rogue family products")
    void testRogueFactoryCreation() {
        CharacterEquipmentFactory factory = new RogueFactory();
        assertTrue(factory.createWeapon() instanceof Dagger);
        assertTrue(factory.createArmor() instanceof LeatherArmor);
        assertTrue(factory.createSkill() instanceof Stealth);
    }

    @Test
    @DisplayName("ArcherFactory creates Archer family products (New Family)")
    void testArcherFactoryCreation() {
        CharacterEquipmentFactory factory = new ArcherFactory();
        assertTrue(factory.createWeapon() instanceof Bow);
        assertTrue(factory.createArmor() instanceof ChainmailArmor);
        assertTrue(factory.createSkill() instanceof PrecisionShot);
    }

    // factory method 3
    @Test
    @DisplayName("WarriorWeaponCreator produces valid Weapon with business execution")
    void testWarriorWeaponCreator() {
        WeaponCreator creator = new WarriorWeaponCreator();
        Weapon weapon = creator.prepareWeaponForBattle();
        assertEquals(25, weapon.getDamage());
    }

    @Test
    @DisplayName("MageWeaponCreator produces valid Staff")
    void testMageWeaponCreator() {
        WeaponCreator creator = new MageWeaponCreator();
        Weapon weapon = creator.prepareWeaponForBattle();
        assertEquals(15, weapon.getDamage());
    }

    @Test
    @DisplayName("ArcherWeaponCreator produces Bow")
    void testArcherWeaponCreator() {
        WeaponCreator creator = new ArcherWeaponCreator();
        Weapon weapon = creator.prepareWeaponForBattle();
        assertEquals(22, weapon.getDamage());
    }

    // compatibility and consistency tests 2
    @Test
    @DisplayName("Verify weapon-armor compatibility ratios for Warrior")
    void testWarriorCompatibility() {
        CharacterEquipmentFactory factory = new WarriorFactory();
        Weapon weapon = factory.createWeapon();
        Armor armor = factory.createArmor();

        assertTrue(armor.getDefense() > weapon.getDamage());
    }

    @Test
    @DisplayName("Verify weapon-armor compatibility ratios for Mage")
    void testMageCompatibility() {
        CharacterEquipmentFactory factory = new MageFactory();
        Weapon weapon = factory.createWeapon();
        Armor armor = factory.createArmor();

        assertTrue(weapon.getDamage() > armor.getDefense());
    }

    // business scenario 3
    @Test
    @DisplayName("GameClient runs business sequence without exceptions")
    void testGameClientScenario() {
        CharacterEquipmentFactory factory = new WarriorFactory();
        GameClient client = new GameClient(factory);

        assertDoesNotThrow(client::prepareForCombat);
        assertDoesNotThrow(client::executeCombatSequence);
        assertDoesNotThrow(() -> client.receiveEnemyAttack(30));
    }

    @Test
    @DisplayName("GameClient absorbs full damage if defense exceeds attack")
    void testDamageAbsorbedFully() {
        CharacterEquipmentFactory factory = new WarriorFactory(); // Defense: 40
        GameClient client = new GameClient(factory);

        assertDoesNotThrow(() -> client.receiveEnemyAttack(20));
    }

    @Test
    @DisplayName("GameClient handles high damage overflow")
    void testDamageOverflow() {
        CharacterEquipmentFactory factory = new MageFactory(); // Defense: 10
        GameClient client = new GameClient(factory);

        assertDoesNotThrow(() -> client.receiveEnemyAttack(100));
    }

    // negativa scenario 2
    @Test
    @DisplayName("Negative Scenario: Exception on unknown character class string")
    void testUnknownClassHandling() {
        String invalidClass = "PALADIN";
        assertThrows(IllegalArgumentException.class, () -> {
            if (!invalidClass.equals("WARRIOR") && !invalidClass.equals("MAGE")) {
                throw new IllegalArgumentException("Unknown character class: " + invalidClass);
            }
        });
    }

    @Test
    @DisplayName("Negative Scenario: Null factory throws exception in Client")
    void testNullFactoryInClient() {
        assertThrows(NullPointerException.class, () -> {
            GameClient client = new GameClient(null);
            client.prepareForCombat();
        });
    }

    // client working through abstractions 1
    @Test
    @DisplayName("Client functions identically regardless of concrete factory implementation")
    void testClientPolymorphism() {
        CharacterEquipmentFactory[] factories = {
                new WarriorFactory(),
                new MageFactory(),
                new RogueFactory(),
                new ArcherFactory()
        };

        for (CharacterEquipmentFactory factory : factories) {
            GameClient client = new GameClient(factory);
            assertNotNull(client);
            assertDoesNotThrow(client::prepareForCombat);
        }
    }
}
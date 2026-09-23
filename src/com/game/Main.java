package com.game;

import com.game.client.GameClient;
import com.game.factory.abstractfactory.*;

import java.io.InputStream;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        CharacterEquipmentFactory factory = loadFactoryFromConfig();

        GameClient client = new GameClient(factory);

        client.prepareForCombat();
        client.executeCombatSequence();
        client.receiveEnemyAttack(50);
    }

    private static CharacterEquipmentFactory loadFactoryFromConfig() {
        Properties properties = new Properties();
        String classType = "WARRIOR";

        try (InputStream input = Main.class.getClassLoader().getResourceAsStream("app.properties")) {
            if (input != null) {
                properties.load(input);
                classType = properties.getProperty("character.class", "WARRIOR").toUpperCase();
            } else {
                System.out.println("Config file 'app.properties' not found. Using default: WARRIOR");
            }
        } catch (Exception e) {
            System.out.println("Error loading config: " + e.getMessage());
        }

        System.out.println("Initializing system for Character Class: " + classType);

        switch (classType) {
            case "WARRIOR":
                return new WarriorFactory();
            case "MAGE":
                return new MageFactory();
            case "ROGUE":
                return new RogueFactory();
            default:
                throw new IllegalArgumentException("Unsupported character class: " + classType);
        }
    }
}
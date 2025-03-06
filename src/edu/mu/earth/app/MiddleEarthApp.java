package edu.mu.earth.app;
import java.util.Scanner;
import edu.mu.earth.characters.*;
import edu.mu.earth.manager.*;

public class MiddleEarthApp {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MiddleEarthCouncil council = MiddleEarthCouncil.getInstance();
        CharacterManager manager = council.getCharacterManager();

        while (true) {
            System.out.println("1. Add a new character");
            System.out.println("2. View all characters");
            System.out.println("3. Update a character");
            System.out.println("4. Delete a character");
            System.out.println("5. Execute all characters' attacks");
            System.out.println("6. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline character

            switch (choice) {
                case 1:
                    // Add new character
                    System.out.print("Enter character name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter character health: ");
                    double health = scanner.nextDouble();
                    System.out.print("Enter character power: ");
                    double power = scanner.nextDouble();
                    scanner.nextLine(); // consume the newline
                    System.out.print("Enter character race (Elf, Dwarf, Human, Orc, Wizard): ");
                    String race = scanner.nextLine();
                    EarthCharacter newCharacter = null;
                    switch (race.toLowerCase()) {
                        case "elf":
                            newCharacter = new Elf(name, health, power);
                            break;
                        case "dwarf":
                            newCharacter = new Dwarf(name, health, power);
                            break;
                        case "human":
                            newCharacter = new Human(name, health, power);
                            break;
                        case "orc":
                            newCharacter = new Orc(name, health, power);
                            break;
                        case "wizard":
                            newCharacter = new Wizard(name, health, power);
                            break;
                        default:
                            System.out.println("Invalid race!");
                            break;
                    }
                    if (newCharacter != null) {
                        manager.addCharacter(newCharacter);
                    }
                    break;

                case 2:
                    manager.displayAllCharacters();
                    break;

                case 3:
                    // Update a character
                    System.out.print("Enter character name to update: ");
                    String updateName = scanner.nextLine();
                    EarthCharacter characterToUpdate = manager.getCharacter(updateName);
                    if (characterToUpdate != null) {
                        System.out.print("Enter new health: ");
                        double newHealth = scanner.nextDouble();
                        System.out.print("Enter new power: ");
                        double newPower = scanner.nextDouble();
                        manager.updateCharacter(updateName, newHealth, newPower);  // Fixed update call
                    } else {
                        System.out.println("Character not found.");
                    }
                    break;

                case 4:
                    // Delete a character
                    System.out.print("Enter character name to delete: ");
                    String deleteName = scanner.nextLine();
                    EarthCharacter characterToDelete = manager.getCharacter(deleteName);
                    if (characterToDelete != null) {
                        manager.deleteCharacter(characterToDelete);
                        System.out.println("Character deleted.");
                    } else {
                        System.out.println("Character not found.");
                    }
                    break;

                case 5:
                    // Execute all attack actions
                    System.out.println("Executing all attacks...");
                    for (int i = 0; i < manager.getAllCharacters().length; i++) {
                        if (manager.getAllCharacters()[i] != null) {
                            EarthCharacter attacker = manager.getAllCharacters()[i];
                            for (int j = 0; j < manager.getAllCharacters().length; j++) {
                                if (i != j && manager.getAllCharacters()[j] != null) {
                                    EarthCharacter target = manager.getAllCharacters()[j];
                                    attacker.attack(target);
                                }
                            }
                        }
                    }
                    break;

                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option! Try again.");
            }
        }
    }
}

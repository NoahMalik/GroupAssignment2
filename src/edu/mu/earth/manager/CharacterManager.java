package edu.mu.earth.manager;
import edu.mu.earth.characters.*;

public class CharacterManager {
	private EarthCharacter[] characters;
    private int size;

    // Constructor to initialize the array and size
    public CharacterManager() {
        characters = new EarthCharacter[10];  // Initial size of 10
        size = 0;  // No characters initially
    }

    // Method to add a new character
    public boolean addCharacter(EarthCharacter c) {
        if (size == characters.length) {
            // If the array is full, double its size
            EarthCharacter[] newArray = new EarthCharacter[characters.length * 2];
            System.arraycopy(characters, 0, newArray, 0, characters.length);
            characters = newArray;
        }
        characters[size++] = c;  // Add the new character and increment size
        return true;
    }

    // Method to get a character by its name
    public EarthCharacter getCharacter(String name) {
        for (int i = 0; i < size; i++) {
            if (characters[i].getName().equals(name)) {
                return characters[i];  // Return the character if found
            }
        }
        return null;  // Return null if not found
    }

    // Method to update a character's health and power
    public boolean updateCharacter(String name, double health, double power) {
        for (int i = 0; i < size; i++) {
            if (characters[i].getName().equals(name)) {
                characters[i].setHealth(health);  // Update health
                characters[i].setPower(power);    // Update power
                return true;  // Return true if updated successfully
            }
        }
        return false;  // Return false if the character was not found
    }

    // Method to delete a character
    public boolean deleteCharacter(EarthCharacter character) {
        for (int i = 0; i < size; i++) {
            if (characters[i].equals(character)) {
                // Shift all characters after the deleted one
                System.arraycopy(characters, i + 1, characters, i, size - i - 1);
                characters[--size] = null;  // Decrease size and remove reference to deleted character
                return true;
            }
        }
        return false;  // Return false if character was not found
    }

    // Method to display all characters' information
    public void displayAllCharacters() {
        for (int i = 0; i < size; i++) {
            characters[i].displayInfo();  // Call displayInfo() for each character
            System.out.println("----------------------");
        }
    }

    // Optional: method to return the number of characters in the array
    public int getSize() {
        return size;
    }
    public EarthCharacter[] getAllCharacters() {
        return characters;
    }
}

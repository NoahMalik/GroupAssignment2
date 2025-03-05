package edu.mu.earth.characters;

public class EarthCharacter {
	protected String name;
    protected double health;
    protected double power;

    // Constructor
    public MiddleEarthCharacter(String name, double health, double power) {
        this.name = name;
        this.health = health;
        this.power = power;
    }

    // Abstract methods
    public abstract boolean attack(MiddleEarthCharacter target);
    public abstract String getRace();

    // Concrete method to display character info
    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Race: " + getRace());
        System.out.println("Health: " + health);
        System.out.println("Power: " + power);
    }
}

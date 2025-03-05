package edu.mu.earth.characters;

public abstract class EarthCharacter {
	private String name;
    private double health;
    private double power;

    public EarthCharacter(String name, double health, double power) {
        this.name = name;
        this.health = health;
        this.power = power;
    }

    public abstract boolean attack(EarthCharacter target);
    public abstract String getRace();

    // Getter methods for name, health, and power
    public String getName() {
        return name;
    }

    public double getHealth() {
        return health;
    }

    public double getPower() {
        return power;
    }

    // Setter methods for health, and power
    public void setHealth(double health) {
        this.health = health;
    }

    public void setPower(double power) {
        this.power = power;
    }
    public void displayInfo() {
    	System.out.println("Name: " + getName());
    	System.out.println("Race: " + getRace());
    	System.out.println("Health: " + getHealth());
    	System.out.println("Power: " + getPower());
    }
}

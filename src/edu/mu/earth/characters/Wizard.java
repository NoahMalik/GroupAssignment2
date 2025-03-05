package edu.mu.earth.characters;

public class Wizard extends EarthCharacter{
	
	public Wizard(String name, double health, double power) {
        super(name, health, power);
    }

    @Override
    public boolean attack(EarthCharacter target) {
        if (this.getRace().equals(target.getRace())) {
            return false; // Cannot attack own kin
        }

        if (target.getRace().equals("Dwarf")) {
            target.setHealth(target.getHealth() - this.getPower() * 1.5); // 1.5x damage against Dwarf
            return true;
        } else if (target.getRace().equals("Human") || target.getRace().equals("Wizard")) {
            return false; // No damage
        } else {
            target.setHealth(target.getHealth() - this.getPower()); // Normal damage
            return true;
        }
    }

    @Override
    public String getRace() {
        return "Wizard";
    }
}

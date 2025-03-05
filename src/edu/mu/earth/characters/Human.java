package edu.mu.earth.characters;

public class Human extends EarthCharacter{
	
	public Human(String name, double health, double power) {
        super(name, health, power);
    }

    @Override
    public boolean attack(EarthCharacter target) {  // Changed parameter type to EarthCharacter
        if (this.getRace().equals(target.getRace())) {
            return false; // Cannot attack own kin
        }

        if (target.getRace().equals("Wizard")) {
            target.setHealth(target.getHealth() - this.getPower() * 1.5); // 1.5x damage against Wizard
            return true;
        } else if (target.getRace().equals("Orc") || target.getRace().equals("Human")) {
            return false; // No damage to Orc or Human
        } else {
            target.setHealth(target.getHealth() - this.getPower()); // Normal damage
            return true;
        }
    }

    @Override
    public String getRace() {
        return "Human";
    }
}

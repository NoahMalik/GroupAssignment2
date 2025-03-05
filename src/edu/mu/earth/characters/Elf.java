package edu.mu.earth.characters;

public class Elf extends EarthCharacter {
	
	public Elf(String name, double health, double power) {
        super(name, health, power);
    }

    @Override
    public boolean attack(EarthCharacter target) {
        if (this.getRace().equals(target.getRace())) {
            return false; // Cannot attack own kin
        }

        if (target.getRace().equals("Orc")) {
            target.setHealth(target.getHealth() - this.getPower() * 1.5); // 1.5x damage against Orc
            return true;
        } else if (target.getRace().equals("Dwarf") || target.getRace().equals("Elf")) {
            return false; // No damage
        } else {
            target.setHealth(target.getHealth() - this.getPower()); // Normal damage
            return true;
        }
    }

    @Override
    public String getRace() {
        return "Elf";
    }
}

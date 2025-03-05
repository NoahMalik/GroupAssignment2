package edu.mu.earth.characters;

public class Dwarf extends EarthCharacter{
	
	public Dwarf(String name, double health, double power) {
        super(name, health, power);
    }

    @Override
    public boolean attack(EarthCharacter target) {  // Changed parameter type to EarthCharacter
        if (this.getRace().equals(target.getRace())) {
            return false; // Cannot attack own kin
        }

        if (target.getRace().equals("Elf")) {
            target.setHealth(target.getHealth() - this.getPower() * 1.5); // 1.5x damage against Elf
            return true;
        } else if (target.getRace().equals("Wizard") || target.getRace().equals("Dwarf")) {
            return false; // No damage to Wizard or Dwarf
        } else {
            target.setHealth(target.getHealth() - this.getPower()); // Normal damage
            return true;
        }
    }

    @Override
    public String getRace() {
        return "Dwarf";
    }
}

package edu.mu.earth.characters;

public class Orc extends EarthCharacter{

	    public Orc(String name, double health, double power) {
	        super(name, health, power);
	    }

	    @Override
	    public boolean attack(EarthCharacter target) {
	        if (this.getRace().equals(target.getRace())) {
	            return false; // Cannot attack own kin
	        }

	        if (target.getRace().equals("Human")) {
	            target.setHealth(target.getHealth() - this.getPower() * 1.5); // 1.5x damage against Human
	            return true;
	        } else if (target.getRace().equals("Elf") || target.getRace().equals("Orc")) {
	            return false; // No damage
	        } else {
	            target.setHealth(target.getHealth() - this.getPower()); // Normal damage
	            return true;
	        }
	    }

	    @Override
	    public String getRace() {
	        return "Orc";
	    }
}

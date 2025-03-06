package edu.mu.earth.manager;

public class MiddleEarthCouncil {
	private static MiddleEarthCouncil instance;
    private CharacterManager characterManager;

    private MiddleEarthCouncil() {
        characterManager = new CharacterManager();
    }

    public static MiddleEarthCouncil getInstance() {
        if (instance == null) {
            instance = new MiddleEarthCouncil();
        }
        return instance;
    }

    public CharacterManager getCharacterManager() {
        return characterManager;
    }
}

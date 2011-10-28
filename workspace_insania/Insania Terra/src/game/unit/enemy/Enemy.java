package game.unit.enemy;

import game.unit.Unit;

public class Enemy extends Unit {

	public Enemy(String name, Integer unitStrength, Integer unitVitality, Integer unitDexterity, Integer unitSpirit,
			Integer unitMagic, Integer level, Integer experience, Integer difficulty) {
		super(name);
		setUnitStats(unitStrength, unitVitality, unitDexterity, unitSpirit, unitMagic, level);
		setExperienceGiven(experience);
		setDifficulty(difficulty);
	}
}

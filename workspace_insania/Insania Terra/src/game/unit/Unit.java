package game.unit;

public class Unit {

	/**
	 * Dynamic stats
	 */
	private Integer actualHitPoints;
	private Integer actualMagicPoints;
	private Integer actualExperience = 0;
	private Integer[] nextLevelExperience = { 0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 };

	/**
	 * Calculated stats
	 */
	private Integer minAttack;
	private Integer maxAttack;
	private Integer maxHitPoints;
	private Integer maxMagicPoints;
	private Integer defense;
	private Integer magicAttack;
	private Integer magicDefense;

	/**
	 * Raw stats
	 */
	protected Integer strength;
	protected Integer vitality;
	protected Integer dexterity;
	protected Integer magic;
	protected Integer spirit;
	protected Integer level;
	private String name;
	protected Integer experienceGiven;
	protected Integer difficulty;

	private static Integer HERO_LEVEL_UP_STRENGHT = 2;
	private static Integer HERO_LEVEL_UP_VITALITY = 2;
	private static Integer HERO_LEVEL_UP_DEXTERITY = 2;
	private static Integer HERO_LEVEL_UP_MAGIC = 2;
	private static Integer HERO_LEVEL_UP_SPIRIT = 2;

	public Unit(String name) {
		this.name = name;
	}

	protected void setUnitStats(Integer strength, Integer vitality, Integer dexterity, Integer spirit, Integer magic,
			Integer level) {
		this.level = level;
		this.strength = strength;
		this.vitality = vitality;
		this.spirit = spirit;
		this.magic = magic;
		this.dexterity = dexterity;
		calculateAttributes();
		fullHeal();
	}

	public void fullHeal() {
		this.actualHitPoints = maxHitPoints;
		this.actualMagicPoints = maxMagicPoints;
	}

	public void levelUp() {
		strength += HERO_LEVEL_UP_STRENGHT;
		vitality += HERO_LEVEL_UP_VITALITY;
		dexterity += HERO_LEVEL_UP_DEXTERITY;
		magic += HERO_LEVEL_UP_MAGIC;
		spirit += HERO_LEVEL_UP_SPIRIT;
		level++;
		calculateAttributes();
	}

	public String addExperience(Integer exp) {
		actualExperience += exp;
		String expLog = "Won " + exp + " experience points.";
		if (actualExperience >= nextLevelExperience[level]) {
			this.levelUp();
			actualExperience = 0;
			expLog = expLog.concat("\nLevel Up!");
		}
		return expLog;
	}

	protected void calculateAttributes() {
		setPhysicalStats();
		setMagicalStats();
	}

	private void setPhysicalStats() {
		this.minAttack = (int) Math.round(strength * 0.5);
		this.maxAttack = strength * 1;
		this.maxHitPoints = vitality * 10;
		this.defense = dexterity;
	}

	private void setMagicalStats() {
		this.magicAttack = magic * 3;
		this.magicDefense = spirit;
		this.maxMagicPoints = magic * 10;
	}

	protected void setDifficulty(Integer difficulty) {
		this.difficulty = difficulty;
	}

	public void takeDamage(Integer damage) {
		this.actualHitPoints -= damage;
	}

	public Integer getNextLevelExperience() {
		return this.nextLevelExperience[level];
	}

	public Integer getActualHitPoints() {
		return this.actualHitPoints;
	}

	public Integer getActualMagicPoints() {
		return this.actualMagicPoints;
	}

	public Integer getActualExperience() {
		return this.actualExperience;
	}

	public Integer getExperienceGiven() {
		return this.experienceGiven;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setExperienceGiven(Integer exp) {
		this.experienceGiven = exp;
	}

	public Integer getLevel() {
		return this.level;
	}

	public Integer getStrength() {
		return this.strength;
	}

	public Integer getVitality() {
		return this.vitality;
	}

	public Integer getDexterity() {
		return this.dexterity;
	}

	public Integer getSpirit() {
		return this.spirit;
	}

	public Integer getMagic() {
		return this.magic;
	}

	public Integer getMaxHitPoints() {
		return this.maxHitPoints;
	}

	public Integer getMaxMagicPoints() {
		return this.maxMagicPoints;
	}

	public Integer getMinAttack() {
		return minAttack;
	}

	public Integer getMaxAttack() {
		return maxAttack;
	}

	public Integer getDefense() {
		return defense;
	}

	public Integer getMagicAttack() {
		return magicAttack;
	}

	public Integer getMagicDefense() {
		return magicDefense;
	}

	public Integer getDifficulty() {
		return difficulty;
	}
}

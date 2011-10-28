package game.unit.item;

public class Equipment extends Item {

	/**
	 * Modifiers
	 */
	private Integer minAttack = 0;
	private Integer maxAttack = 0;
	private Integer maxHitPoints = 0;
	private Integer maxMagicPoints = 0;
	private Integer defense = 0;
	private Integer magicAttack = 0;
	private Integer magicDefense = 0;
	private Integer strength = 0;
	private Integer vitality = 0;
	private Integer dexterity = 0;
	private Integer magic = 0;
	private Integer spirit = 0;

	/**
	 * Preffixes and suffixes
	 */
	

	public Equipment() {
		super(true, false, false);
	}

}

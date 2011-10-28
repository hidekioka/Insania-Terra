package game.unit.item;

public class Modifier {

	private enum Attribute {
		MINATTACK("Min. Attack"),
		MAXATTACK("Min. Attack"),
		MAXHITPOINTS("Min. Attack"),
		MAXMAGICPOINTS("Min. Attack"),
		DEFENSE("Min. Attack"),
		MAGICATTACK("Min. Attack"),
		MAGICDEFENSE("Min. Attack"),
		STRENGTH("Min. Attack"),
		VITALITY("Min. Attack"),
		DEXTERITY("Min. Attack"),
		MAGIC("Min. Attack"),
		SPIRIT("Min. Attack");

		private String attributeString;

		Attribute(String attributeString) {
			this.attributeString = attributeString;
		}

		String getString() {
			return attributeString;
		}
	}

	private boolean isIncrement;
	private Attribute attribute;
	private Integer value;

	public Modifier(Attribute attribute, boolean isIncrement, Integer value) {
		this.attribute = attribute;
		this.isIncrement = isIncrement;
		this.value = value;
	}

	public String mountDescriptionString() {
		String description = "";
		description = description.concat(attribute.getString());
		if (isIncrement)
			description = description.concat(" + ");
		else
			description = description.concat(" - ");
		description = description.concat(value.toString());
		return description;
	}
}

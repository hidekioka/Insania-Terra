package game.unit.player;

import game.dungeon.Dungeon;
import game.unit.Unit;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Hero extends Unit {

	public enum HeroStatus {
		BUSY, IDLE, DEAD, REPORTING
	}

	private static Double initialStrength = 10.0;
	private static Double initialVitality = 10.0;
	private static Double initialDexterity = 10.0;
	private static Double initialSpirit = 10.0;
	private static Double initialMagic = 10.0;
	private HeroStatus status;
	private Dungeon activeDungeon;
	private Integer floorsToGo;

	private static String SAVE_FILE = "C://Documents and Settings//henrique.oka//Desktop//MainCharacter.properties";

	public Hero(String name) {
		super(name);
		setUnitStats(initialStrength.intValue(), initialVitality.intValue(), initialDexterity.intValue(),
				initialSpirit.intValue(), initialMagic.intValue(), 1);
		this.status = HeroStatus.IDLE;
	}

	public void saveCharacter() {
		try {
			Properties properties = new Properties();
			properties.setProperty("hero.name", getName());
			properties.setProperty("hero.level", ((Integer) getLevel()).toString());
			properties.setProperty("hero.strength", ((Integer) getStrength()).toString());
			properties.setProperty("hero.vitality", ((Integer) getVitality()).toString());
			properties.setProperty("hero.dexterity", ((Integer) getDexterity()).toString());
			properties.setProperty("hero.spirit", ((Integer) getSpirit()).toString());
			properties.setProperty("hero.magic", ((Integer) getMagic()).toString());
			properties.store(new FileOutputStream(SAVE_FILE), "");
		} catch (IOException e) {
		}
	}

	public void loadCharacter() {
		try {
			int level = 1;
			int strength = 10;
			int vitality = 10;
			int dexterity = 10;
			int spirit = 10;
			int magic = 10;
			String name = "";
			Properties properties = new Properties();
			FileInputStream fileInputStream = new FileInputStream(SAVE_FILE);
			try {
				properties.load(fileInputStream);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (properties != null) {
				if (properties.containsKey("hero.level")) {
					level = Integer.parseInt(properties.getProperty("hero.level"));
				}
				if (properties.containsKey("hero.name")) {
					name = properties.getProperty("hero.name");
				}
				if (properties.containsKey("hero.strength")) {
					strength = Integer.parseInt(properties.getProperty("hero.strength"));
				}
				if (properties.containsKey("hero.vitality")) {
					vitality = Integer.parseInt(properties.getProperty("hero.vitality"));
				}
				if (properties.containsKey("hero.dexterity")) {
					dexterity = Integer.parseInt(properties.getProperty("hero.dexterity"));
				}
				if (properties.containsKey("hero.spirit")) {
					spirit = Integer.parseInt(properties.getProperty("hero.spirit"));
				}
				if (properties.containsKey("hero.magic")) {
					magic = Integer.parseInt(properties.getProperty("hero.magic"));
				}
			}
			setName(name);
			setUnitStats(strength, vitality, dexterity, spirit, magic, level);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public HeroStatus getHeroStatus() {
		return status;
	}

	public void setHeroStatus(HeroStatus status) {
		this.status = status;
	}

	public Dungeon getActiveDungeon() {
		return activeDungeon;
	}

	public int getFloorsToGo() {
		return floorsToGo;
	}

	public void setActiveDungeon(Dungeon dungeon, int floorsToGo) {
		this.activeDungeon = dungeon;
		this.floorsToGo = floorsToGo;
	}
}

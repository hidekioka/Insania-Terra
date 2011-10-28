package game.dungeon;

import game.unit.Unit;
import game.util.FightController;

import java.util.ArrayList;

import android.util.Log;

public class Floor {

	private int dificulty;
	// private boolean isSpecial;
	private TileEventManager eventManager;
	private int size;
	private Unit[] monsters;

	public Floor(int dificulty, int size, Unit[] monsters, int encounterRate, int itemFindRate, int healTileRate,
			int trapTileRate) {
		this.dificulty = dificulty;
		// this.isSpecial = false;
		this.size = size;
		this.eventManager = new TileEventManager(encounterRate, itemFindRate, healTileRate, trapTileRate);
		populateMonsters(monsters);
	}

	private void populateMonsters(Unit[] monsters) {
		this.monsters = monsters;
	}

	private Unit getRandomMonster() {
		return monsters[(int) (Math.random() * monsters.length)];
	}

	public ArrayList<String> eventProcess(Unit hero) {
		ArrayList<String> floorLog = new ArrayList<String>();
		for (int i = 0; i < size; i++) {
			String eventLog = "";
			switch (eventManager.rollEvent()) {
			case ENCOUNTER:
				eventLog = FightController.fight(hero, getRandomMonster());
				floorLog.add(eventLog);
				break;
			case ITEM:
				eventLog = "Found item";
				floorLog.add(eventLog);
				break;
			case HEAL:
				eventLog = "Heal";
				floorLog.add(eventLog);
				break;
			case TRAP:
				eventLog = "Trap!";
				floorLog.add(eventLog);
				break;
			default:
				break;
			}
		}
		Log.w("Dungeon", "Size of floor" + floorLog.size());
		return floorLog;
	}

	public int getDificulty() {
		return dificulty;
	}

}

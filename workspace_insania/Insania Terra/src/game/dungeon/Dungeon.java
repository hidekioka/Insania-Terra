package game.dungeon;

import game.unit.Unit;
import game.unit.player.Hero;

import java.util.ArrayList;

public class Dungeon {

	public enum DungeonStatus {
		ENABLED, DISABLED, BUSY, IDLE
	}

	private Floor[] floors;
	private String name;

	public Dungeon(String name, int floorNumber, int size, Unit[] monsters, int encounterRate, int itemFindRate,
			int healTileRate, int trapTileRate) {
		this.name = name;
		floors = new Floor[floorNumber];
		for (int i = 0; i < floorNumber; i++) {
			floors[i] = new Floor(i, size, monsters, encounterRate, itemFindRate, healTileRate, trapTileRate);
		}
	}

	public String getName() {
		return this.name;
	}

	public int getFloorNumber() {
		return this.floors.length;
	}

	public ArrayList<String> processDungeon(Unit hero) {
		ArrayList<String> dungeonLog = new ArrayList<String>();
		dungeonLog.add("Entered ".concat(name));
		/* For all of the floors in the dungeon, rolls random events for each floor tile. */
		for (Integer i = 0; i <= ((Hero) hero).getFloorsToGo(); i++) {
			dungeonLog.add((">Entered floor ").concat(i.toString()));
			ArrayList<String> floorLog = floors[i].eventProcess(hero);
			for (int j = 0; j < floorLog.size() - 1; j++) {
				dungeonLog.add(">>" + floorLog.get(j));
			}
			dungeonLog.add((">Left floor ").concat(i.toString()));
		}
		return dungeonLog;

	}
}

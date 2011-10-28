package game.dungeon;

import android.util.Log;

public class TileEventManager {
	public enum TileEventType {
		ENCOUNTER, ITEM, HEAL, TRAP, SPECIALENCOUNTER, NO_EVENT
	};

	private int itemFindRate;
	private int encounterRate;
	private int healTileRate;
	private int trapTileRate;

	public TileEventManager(int encounterRate, int itemFindRate, int healTileRate, int trapTileRate) {
		this.encounterRate = encounterRate;
		this.itemFindRate = itemFindRate;
		this.healTileRate = healTileRate;
		this.trapTileRate = trapTileRate;
	}

	public TileEventType rollEvent() {
		Integer encounterRoll = (int) (Math.random() * 100);
		if (encounterRoll < encounterRate) {
			Log.w("TileEventType", "roll " + encounterRoll + " = ENCOUNTER");
			return TileEventType.ENCOUNTER;
		} else if (encounterRoll >= encounterRate && encounterRoll < itemFindRate + encounterRate) {
			Log.w("TileEventType", "roll " + encounterRoll + " = ITEM");
			return TileEventType.ITEM;

		} else if (encounterRoll >= encounterRate + encounterRate
				&& encounterRoll < itemFindRate + encounterRate + healTileRate) {
			Log.w("TileEventType", "roll " + encounterRoll + " = HEAL");
			return TileEventType.HEAL;
		} else if (encounterRoll >= encounterRate + encounterRate + healTileRate
				&& encounterRoll < itemFindRate + encounterRate + healTileRate + trapTileRate) {
			Log.w("TileEventType", "roll " + encounterRoll + " = TRAP");
			return TileEventType.TRAP;
		}
		Log.w("TileEventType", "roll " + encounterRoll + " = NOTHING");
		return TileEventType.NO_EVENT;
	}
}

package game.android;

import game.dungeon.Dungeon;
import game.dungeon.DungeonManager;
import game.unit.Unit;
import game.unit.enemy.EnemyDatabase;
import game.unit.player.Hero;
import android.app.Application;
import android.content.Context;

public class InsaniaTerra extends Application {
	private Unit hero = new Hero("testando");
	private DungeonManager dungeonManager;
	private EnemyDatabase enemyDB;

	public Unit getHero() {
		return hero;
	}

	public void setHero(Unit hero) {
		this.hero = hero;
	}

	public Dungeon getDungeonByName(String name) {
		return dungeonManager.getDungeonByName(name);
	}

	public void createDungeonManager(Context context) {
		this.dungeonManager = new DungeonManager(context);
	}

	public void createEnemyDatabase(Context context) {
		this.enemyDB = new EnemyDatabase(context);
	}

	public EnemyDatabase getEnemyDatabase() {
		return enemyDB;
	}
	
}

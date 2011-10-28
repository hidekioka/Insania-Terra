package game.dungeon;

import game.unit.enemy.EnemyDatabase;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.content.Context;

import com.android.R;

public class DungeonManager {
	private int dungeonNumber = 2;
	private Dungeon[] dungeons = new Dungeon[dungeonNumber];
	private EnemyDatabase enemyDB;

	public DungeonManager(Context context) {
		this.enemyDB = new EnemyDatabase(context);
		InputStream inputStream = null;
		try {
			inputStream = context.getResources().openRawResource(R.raw.dungeon_database);
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			String read = bufferedReader.readLine();
			int counter = 0;
			while (read != null) {
				read = bufferedReader.readLine();
				String[] dungeonProperties = read.split(" ");
				String name = dungeonProperties[0];
				Integer floorNumber = Integer.parseInt(dungeonProperties[1]);
				Integer size = Integer.parseInt(dungeonProperties[2]);
				Integer difficulty = Integer.parseInt(dungeonProperties[3]);
				Integer encounterRate = Integer.parseInt(dungeonProperties[4]);
				Integer itemFindRate = Integer.parseInt(dungeonProperties[5]);
				Integer healTileRate = Integer.parseInt(dungeonProperties[6]);
				Integer trapTileRate = Integer.parseInt(dungeonProperties[7]);
				dungeons[counter] = new Dungeon(name, floorNumber, size, enemyDB.getEnemiesByDifficulty(difficulty),
						encounterRate, itemFindRate, healTileRate, trapTileRate);
				counter++;
			}
			inputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Dungeon getDungeonByName(String name) {
		for (int i = 0; i < dungeonNumber; i++) {
			if (dungeons[i].getName().equals(name))
				return dungeons[i];
		}
		return null;
	}
}

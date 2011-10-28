package game.dungeon;

import game.android.InsaniaTerra;
import game.unit.enemy.EnemyDatabase;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import android.content.Context;
import android.util.Log;

import com.android.R;

public class DungeonManager {
	private ArrayList<Dungeon> dungeons = new ArrayList<Dungeon>();

	public DungeonManager(Context context) {
		EnemyDatabase enemyDB = ((InsaniaTerra) context.getApplicationContext()).getEnemyDatabase();
		InputStream inputStream = null;
		try {
			inputStream = context.getResources().openRawResource(R.raw.dungeon_database);
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			String read = bufferedReader.readLine();
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
				Integer timePerTile = Integer.parseInt(dungeonProperties[8]);
				dungeons.add(new Dungeon(name, floorNumber, size, enemyDB.getEnemiesByDifficulty(difficulty),
						encounterRate, itemFindRate, healTileRate, trapTileRate, timePerTile));
			}
			inputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Dungeon getDungeonByName(String name) {
		Log.w("Dungeon", dungeons.toString());
		for (Dungeon d : dungeons) {
			// if (dungeons.get(i).getName().equals(name))
			Log.w("Dungeon", d.getName());
			return d;
		}
		return new Dungeon("Error");
	}
}

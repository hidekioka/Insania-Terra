package game.unit.enemy;

import game.unit.enemy.Enemy;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.android.R;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

public class EnemyDatabase {
	private Enemy[] enemies = new Enemy[3];

	public EnemyDatabase(Context context) {
		InputStream inputStream = null;
		try {
			inputStream = context.getResources().openRawResource(R.raw.enemy_database);
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			String read = bufferedReader.readLine();
			int counter = 0;
			while (read != null) {
				read = bufferedReader.readLine();
				String[] monsterStats = read.split(" ");
				String name = monsterStats[0];
				Integer strength = Integer.parseInt(monsterStats[1]);
				Integer vitality = Integer.parseInt(monsterStats[2]);
				Integer dexterity = Integer.parseInt(monsterStats[3]);
				Integer magic = Integer.parseInt(monsterStats[4]);
				Integer spirit = Integer.parseInt(monsterStats[5]);
				Integer level = Integer.parseInt(monsterStats[6]);
				Integer exp = Integer.parseInt(monsterStats[7]);
				Integer difficulty = Integer.parseInt(monsterStats[8]);
				enemies[counter] = new Enemy(name, strength, vitality, dexterity, magic, spirit, level, exp, difficulty);
				counter++;
			}
			inputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Enemy getRandomEnemy(Integer level) {
		return enemies[1];
	}

	public Enemy[] getEnemiesByDifficulty(Integer difficulty) {
		return enemies;
	}
}

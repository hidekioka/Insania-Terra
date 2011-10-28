package game.android;

import game.dungeon.Dungeon;
import game.unit.player.Hero;
import game.unit.player.Hero.HeroStatus;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.R;

public class DungeonActivity extends Activity {

	private String[] floorStrings;
	private Dungeon dungeon;
	private String dungeonName = "";
	private Hero hero;
	private Context context = this;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
			dungeonName = extras.getString("name");
			dungeon = ((InsaniaTerra) this.getApplication()).getDungeonByName(dungeonName);
			createFloorList();
		} else {
			floorStrings = new String[] { "Error" };
		}
		setContentView(R.layout.dungeon);
		TextView dungeonNameText = (TextView) findViewById(R.id.dungeonNameText);
		dungeonNameText.setText(dungeonName);
		ListView floorsListView = (ListView) findViewById(R.id.floorsListView);
		floorsListView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, floorStrings));
		floorsListView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> a, View v, int position, long id) {
				sendHeroToDungeon(v, position, dungeonName);
			}
		});
	}

	protected void onStart() {
		super.onStart();
	}

	protected void onRestart() {
		super.onRestart();
	}

	protected void onResume() {
		super.onResume();
	}

	protected void onPause() {
		super.onPause();
	}

	protected void onStop() {
		super.onStop();
	}

	protected void onDestroy() {
		super.onDestroy();
	}

	public class WidgetTask extends TimerTask {
		public void run() {
			// Toast.makeText(context, "timer ON", Toast.LENGTH_LONG).show();
			hero.setHeroStatus(HeroStatus.REPORTING);
			updateWidget();
		}
	}

	public void sendHeroToDungeon(View view, int floorsToGo, String dungeonName) {
		finish();
		hero = ((Hero) ((InsaniaTerra) this.getApplication()).getHero());
		if (hero.getHeroStatus() == HeroStatus.IDLE) {
			hero.setHeroStatus(HeroStatus.BUSY);
			Toast.makeText(this, hero.getName() + " entered " + dungeonName + ".", Toast.LENGTH_LONG).show();
			hero.setActiveDungeon(dungeon, floorsToGo);
			updateWidget();
			/* timer coxamente implementado */
			Timer heroTimer = new Timer("Timer");
			Date currentDate = new Date();
			currentDate.setTime(currentDate.getTime() + 10000);
			heroTimer.schedule(new WidgetTask(), currentDate);
		} else {
			Toast.makeText(this, hero.getName() + " is busy.", Toast.LENGTH_LONG).show();
		}
	}

	public void viewMapScreen(View view) {
		finish();
	}

	private void createFloorList() {
		floorStrings = new String[dungeon.getFloorNumber()];
		for (Integer i = 0; i < floorStrings.length; i++) {
			floorStrings[i] = "Floor ".concat(i.toString());
		}
	}

	private void updateWidget() {
		Intent updateWidgetIntent = new Intent(this, GameWidget.class);
		updateWidgetIntent.setAction(GameWidget.ACTION_WIDGET_RECEIVER);
		this.sendBroadcast(updateWidgetIntent);
	}
}

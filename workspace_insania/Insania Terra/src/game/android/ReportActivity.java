package game.android;

import game.dungeon.Dungeon;
import game.unit.player.Hero;
import game.unit.player.Hero.HeroStatus;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.R;

public class ReportActivity extends Activity {
	// private Dungeon dungeon;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.report);
		Hero hero = ((Hero) ((InsaniaTerra) this.getApplication()).getHero());
		Dungeon dungeon = hero.getActiveDungeon();
		ArrayList<String> report = dungeon.processDungeon(((InsaniaTerra) this.getApplication()).getHero());
		LinearLayout reportLayout = (LinearLayout) findViewById(R.id.reportLayout);
		for (int i = 0; i < report.size(); i++) {
			TextView reportText = new TextView(this);
			reportText.setText(report.get(i));
			reportLayout.addView(reportText);
		}
		hero.setHeroStatus(HeroStatus.IDLE);
		updateWidget();
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

	public void viewMapScreen(View view) {
		finish();
	}

	private void updateWidget() {
		Intent updateWidgetIntent = new Intent(this, GameWidget.class);
		updateWidgetIntent.setAction(GameWidget.ACTION_WIDGET_RECEIVER);
		this.sendBroadcast(updateWidgetIntent);
	}
}

package game.android;

import game.unit.player.Hero;
import game.unit.player.Hero.HeroStatus;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.android.R;

public class TownActivity extends Activity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.town);
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

	public void viewProfileScreen(View view) {
		// finish();
		startActivity(new Intent(this, ProfileActivity.class));
	}

	public void viewReportScreen(View view) {
		// finish();
		Hero hero = ((Hero) ((InsaniaTerra) this.getApplication()).getHero());
		if (hero.getHeroStatus() == HeroStatus.REPORTING) {
			startActivity(new Intent(this, ReportActivity.class));
		} else {
			Toast.makeText(this, "There are no reports to view.", Toast.LENGTH_LONG).show();
		}
	}

	public void healCharacter(View view) {
		((InsaniaTerra) this.getApplication()).getHero().fullHeal();
	}

	public void viewMapScreen(View view) {
		finish();
		// startActivity(new Intent(this, MapActivity.class));
	}

	public void closeProgram(View view) {
		// finish();
	}
}

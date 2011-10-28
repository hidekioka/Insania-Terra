package game.android;

import game.unit.Unit;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.R;

public class ProfileActivity extends Activity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.profile);
		Unit character = ((InsaniaTerra) this.getApplication()).getHero();
		TextView nameText = (TextView) findViewById(R.id.nameText);
		TextView hpText = (TextView) findViewById(R.id.minMaxHPText);
		TextView mpText = (TextView) findViewById(R.id.minMaxMPText);
		TextView expText = (TextView) findViewById(R.id.minMaxExpText);
		TextView levelText = (TextView) findViewById(R.id.levelText);
		TextView strText = (TextView) findViewById(R.id.strText);
		TextView vitText = (TextView) findViewById(R.id.vitText);
		TextView dexText = (TextView) findViewById(R.id.dexText);
		TextView magText = (TextView) findViewById(R.id.magText);
		TextView sprText = (TextView) findViewById(R.id.sprText);
		ProgressBar hpBar = (ProgressBar) findViewById(R.id.hpBar);
		ProgressBar mpBar = (ProgressBar) findViewById(R.id.mpBar);
		ProgressBar expBar = (ProgressBar) findViewById(R.id.expBar);
		hpBar.setProgressDrawable(getResources().getDrawable(R.drawable.hp_bar));
		mpBar.setProgressDrawable(getResources().getDrawable(R.drawable.mp_bar));
		expBar.setProgressDrawable(getResources().getDrawable(R.drawable.exp_bar));
		String actualHP = Integer.toString(character.getActualHitPoints());
		String actualMP = Integer.toString(character.getActualMagicPoints());
		String actualExp = Integer.toString(character.getActualExperience());
		String maxHP = Integer.toString(character.getMaxHitPoints());
		String maxMP = Integer.toString(character.getMaxMagicPoints());
		String nextLvExp = Integer.toString(character.getNextLevelExperience());
		hpText.setText(actualHP.concat("/").concat(maxHP));
		mpText.setText(actualMP.concat("/").concat(maxMP));
		expText.setText(actualExp.concat("/").concat(nextLvExp));
		strText.setText(character.getStrength().toString());
		vitText.setText(character.getVitality().toString());
		dexText.setText(character.getDexterity().toString());
		magText.setText(character.getMagic().toString());
		sprText.setText(character.getSpirit().toString());
		levelText.setText("Knight LV ".concat(character.getLevel().toString()));
		nameText.setText(character.getName());
		hpBar.setProgress(character.getActualHitPoints() * 100 / character.getMaxHitPoints());
		mpBar.setProgress(character.getActualMagicPoints() * 100 / character.getMaxMagicPoints());
		expBar.setProgress(character.getActualExperience() * 100 / character.getNextLevelExperience());
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

	public void viewTownScreen(View view) {
		finish();
		// startActivity(new Intent(this, TownActivity.class));
	}
}

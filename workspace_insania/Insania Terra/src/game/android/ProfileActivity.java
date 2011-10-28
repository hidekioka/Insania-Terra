package game.android;

import game.unit.Unit;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.R;

public class ProfileActivity extends Activity {

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.profile);
		Unit hero = ((InsaniaTerra) this.getApplication()).getHero();
		setStatusOnScreen(hero);
		setProgressBarOnScreen(hero);
		setNameLevelOnScreen(hero);
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
	}

	/**
	 * Sets the character's status on the profile screen.
	 * 
	 * @param hero
	 */
	private void setStatusOnScreen(Unit hero) {
		TextView strText = (TextView) findViewById(R.id.strText);
		TextView vitText = (TextView) findViewById(R.id.vitText);
		TextView dexText = (TextView) findViewById(R.id.dexText);
		TextView magText = (TextView) findViewById(R.id.magText);
		TextView sprText = (TextView) findViewById(R.id.sprText);
		strText.setText(hero.getStrength().toString());
		vitText.setText(hero.getVitality().toString());
		dexText.setText(hero.getDexterity().toString());
		magText.setText(hero.getMagic().toString());
		sprText.setText(hero.getSpirit().toString());
	}

	/**
	 * Sets the parameters related to the progress bar on the profile screen.
	 * 
	 * @param hero
	 */
	private void setProgressBarOnScreen(Unit hero) {
		TextView hpText = (TextView) findViewById(R.id.minMaxHPText);
		TextView mpText = (TextView) findViewById(R.id.minMaxMPText);
		TextView expText = (TextView) findViewById(R.id.minMaxExpText);
		ProgressBar hpBar = (ProgressBar) findViewById(R.id.hpBar);
		ProgressBar mpBar = (ProgressBar) findViewById(R.id.mpBar);
		ProgressBar expBar = (ProgressBar) findViewById(R.id.expBar);
		hpBar.setProgressDrawable(getResources().getDrawable(R.drawable.hp_bar));
		mpBar.setProgressDrawable(getResources().getDrawable(R.drawable.mp_bar));
		expBar.setProgressDrawable(getResources().getDrawable(R.drawable.exp_bar));
		String actualHP = Integer.toString(hero.getActualHitPoints());
		String actualMP = Integer.toString(hero.getActualMagicPoints());
		String actualExp = Integer.toString(hero.getActualExperience());
		String maxHP = Integer.toString(hero.getMaxHitPoints());
		String maxMP = Integer.toString(hero.getMaxMagicPoints());
		String nextLvExp = Integer.toString(hero.getNextLevelExperience());
		hpText.setText(actualHP.concat("/").concat(maxHP));
		mpText.setText(actualMP.concat("/").concat(maxMP));
		expText.setText(actualExp.concat("/").concat(nextLvExp));
		hpBar.setProgress(hero.getActualHitPoints() * 100 / hero.getMaxHitPoints());
		mpBar.setProgress(hero.getActualMagicPoints() * 100 / hero.getMaxMagicPoints());
		expBar.setProgress(hero.getActualExperience() * 100 / hero.getNextLevelExperience());
	}

	/**
	 * Sets the parameters related to the name and level on the profile screen.
	 * 
	 * @param hero
	 */
	private void setNameLevelOnScreen(Unit hero) {
		TextView nameText = (TextView) findViewById(R.id.nameText);
		TextView levelText = (TextView) findViewById(R.id.levelText);
		levelText.setText("Knight LV ".concat(hero.getLevel().toString()));
		nameText.setText(hero.getName());
	}
}

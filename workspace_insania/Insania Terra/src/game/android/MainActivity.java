package game.android;

import game.unit.player.Hero;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

import com.android.R;

public class MainActivity extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		((InsaniaTerra) this.getApplication()).createDungeonManager(this);
		setContentView(R.layout.initial);
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

	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
					switch (which) {
						case DialogInterface.BUTTON_POSITIVE:
							finish();
							break;

						case DialogInterface.BUTTON_NEGATIVE:
							break;
					}
				}
			};

			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setMessage("Do you want to close this application?").setPositiveButton("Yes", dialogClickListener)
					.setNegativeButton("No", dialogClickListener).show();

		}
		return super.onKeyDown(keyCode, event);
	}

	public void viewMapScreen(View view) {
		// finish();
		startActivity(new Intent(this, ProfileActivity.class));
	}

	public void loadGame(View view) {
		// finish();
		((InsaniaTerra) this.getApplication()).setHero(new Hero("LoadGame"));
		startActivity(new Intent(this, MapActivity.class));
	}

	public void viewNewGameScreen(View view) {
		// finish();
		startActivity(new Intent(this, NewGameActivity.class));
	}

	public void closeProgram(View view) {
		finish();
	}

}

package game.android;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

import com.android.R;

public class MapActivity extends Activity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.map);
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
							android.os.Process.killProcess(android.os.Process.myPid());
							break;

						case DialogInterface.BUTTON_NEGATIVE:
							break;
					}
				}
			};

			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setMessage("Return to main menu?").setPositiveButton("Yes", dialogClickListener).setNegativeButton(
					"No", dialogClickListener).show();

		}
		return super.onKeyDown(keyCode, event);
	}

	public void viewTowerDungeonScreen(View view) {
		// finish();
		Intent intent = new Intent(this, DungeonActivity.class);
		intent.putExtra("name", "Tower");
		startActivity(intent);
	}

	public void viewMountainDungeonScreen(View view) {
		// finish();
		Intent intent = new Intent(this, DungeonActivity.class);
		intent.putExtra("name", "Mountain");
		startActivity(intent);
	}

	public void viewTownScreen(View view) {
		// finish();
		startActivity(new Intent(this, TownActivity.class));
	}
}

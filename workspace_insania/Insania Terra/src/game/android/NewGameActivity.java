package game.android;

import game.unit.player.Hero;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.android.R;

public class NewGameActivity extends Activity {

	private ImageView imgView;
	private Integer[] Imgid = { R.drawable.character01, R.drawable.character02, R.drawable.character03,
			R.drawable.character04 };

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.newgame);
		setStatusOnScreen();
		Spinner spinner = (Spinner) findViewById(R.id.vocationSpinner);
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.vocation_array,
				android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);
		imgView = (ImageView) findViewById(R.id.characterPhoto);
		imgView.setImageResource(Imgid[0]);
		Gallery gallery = (Gallery) findViewById(R.id.gallery);
		gallery.setAdapter(new ImageAdapter(this));
		gallery.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
				imgView.setImageResource(Imgid[position]);
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

	public void startGame(View view) {
		EditText heroNameEdit = (EditText) findViewById(R.id.heroNameEdit);
		String heroName = heroNameEdit.getText().toString();
		finish();
		((InsaniaTerra) this.getApplication()).setHero(new Hero(heroName));
		updateWidget();
		startActivity(new Intent(this, MapActivity.class));
	}

	public void viewInitialScreen(View view) {
		finish();
	}

	private void updateWidget() {
		Intent updateWidgetIntent = new Intent(this, Widget.class);
		updateWidgetIntent.setAction(Widget.ACTION_WIDGET_RECEIVER);
		this.sendBroadcast(updateWidgetIntent);
	}

	private void setStatusOnScreen() {
		TextView strText = (TextView) findViewById(R.id.strTextNewGame);
		TextView vitText = (TextView) findViewById(R.id.vitTextNewGame);
		TextView dexText = (TextView) findViewById(R.id.dexTextNewGame);
		TextView magText = (TextView) findViewById(R.id.magTextNewGame);
		TextView sprText = (TextView) findViewById(R.id.sprTextNewGame);
		strText.setText("10");
		vitText.setText("10");
		dexText.setText("10");
		magText.setText("10");
		sprText.setText("10");
	}
}

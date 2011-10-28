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

import com.android.R;

public class NewGameActivity extends Activity {

	private Gallery gallery;
	private ImageView imgView;
	private Integer[] Imgid = { R.drawable.character01, R.drawable.character02, R.drawable.character03,
			R.drawable.character04 };

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.newgame);
		Spinner spinner = (Spinner) findViewById(R.id.vocationSpinner);
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.vocation_array,
				android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);
		imgView = (ImageView) findViewById(R.id.characterPhoto);
		imgView.setImageResource(Imgid[0]);
		gallery = (Gallery) findViewById(R.id.gallery);
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
		startActivity(new Intent(this, MapActivity.class));
	}

	public void viewInitialScreen(View view) {
		finish();
	}
}

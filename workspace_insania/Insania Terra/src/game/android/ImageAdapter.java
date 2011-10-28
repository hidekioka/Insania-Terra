package game.android;

import android.content.Context;
import android.content.res.TypedArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.android.R;

public class ImageAdapter extends BaseAdapter {

	int galleryItemBg;
	private Integer[] Imgid = { R.drawable.character01, R.drawable.character02, R.drawable.character03,
			R.drawable.character04 };
	private Context cont;

	public ImageAdapter(Context c) {
		cont = c;
		TypedArray typArray = c.obtainStyledAttributes(R.styleable.GalleryTheme);
		galleryItemBg = typArray.getResourceId(R.styleable.GalleryTheme_android_galleryItemBackground, 0);
		typArray.recycle();
	}

	public int getCount() {
		return Imgid.length;
	}

	public Object getItem(int position) {
		return position;
	}

	public long getItemId(int position) {
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		ImageView imgView = new ImageView(cont);
		imgView.setImageResource(Imgid[position]);
		imgView.setScaleType(ImageView.ScaleType.FIT_XY);
		imgView.setBackgroundResource(galleryItemBg);
		return imgView;
	}
}

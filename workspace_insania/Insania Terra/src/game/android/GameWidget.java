package game.android;

import game.unit.player.Hero;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

import com.android.R;

public class GameWidget extends AppWidgetProvider {
	public static final String ACTION_WIDGET_RECEIVER = "ActionRecieverWidget";

	public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
		final int N = appWidgetIds.length;
		for (int i = 0; i < N; i++) {
			int appWidgetId = appWidgetIds[i];
			RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.widget);
			String widgetText = "";
			switch (((Hero) ((InsaniaTerra) context.getApplicationContext()).getHero()).getHeroStatus()) {
				case IDLE: {
					widgetText = "Your have an idle hero.";
					break;
				}
				case BUSY: {
					widgetText = "Your hero is currently on a quest.";
					break;
				}
				case DEAD: {
					widgetText = "Your hero is dead.";
					break;
				}
				case REPORTING: {
					widgetText = "You have a unread report.";
					break;
				}
			}
			views.setTextViewText(R.id.widgetText, widgetText);
			Intent intent = new Intent(context, GameWidget.class);
			intent.setAction(ACTION_WIDGET_RECEIVER);
			PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, 0);
			views.setOnClickPendingIntent(R.id.widgetText, pendingIntent);
			views.setOnClickPendingIntent(R.id.widgetSpriteImage, pendingIntent);
			appWidgetManager.updateAppWidget(appWidgetId, views);
		}
	}

	public void onReceive(Context context, Intent intent) {
		super.onReceive(context, intent);
		if (ACTION_WIDGET_RECEIVER.equals(intent.getAction())) {
			AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
			ComponentName thisAppWidget = new ComponentName(context.getPackageName(), GameWidget.class.getName());
			int[] appWidgetIds = appWidgetManager.getAppWidgetIds(thisAppWidget);
			onUpdate(context, appWidgetManager, appWidgetIds);
		}

	}
}

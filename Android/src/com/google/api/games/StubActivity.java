package com.google.api.games;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.gms.games.Games;
import com.google.android.gms.games.GamesActivityResultCodes;

public class StubActivity extends Activity {

	public static final String ACTION_SHOW_LEADERBOARDS_ACTIVITY = "showLeaderboardsActivity";
	public static final String ACTION_SHOW_LEADERBOARD_BY_ID_ACTIVITY = "showLeaderboardByIdActivity";
	public static final String ACTION_SHOW_ACHIEVEMENTS_ACTIVITY = "showAchievementsActivity";

	public static final String EXTRA_LEADERBOARD_ID = "extraLeaderboardId";

	private static boolean isShown;

	private static final int REQUEST_CODE = 7325;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (isShown) {
			return;
		}

		if (getIntent().getAction().equals(ACTION_SHOW_ACHIEVEMENTS_ACTIVITY)) {
			startActivityForResult(
					Games.Achievements.getAchievementsIntent(SignInActivity.mHelper
							.getApiClient()), REQUEST_CODE);
		}

		else if (getIntent().getAction().equals(
				ACTION_SHOW_LEADERBOARDS_ACTIVITY)) {
			startActivityForResult(
					Games.Leaderboards.getAllLeaderboardsIntent(SignInActivity.mHelper
							.getApiClient()), REQUEST_CODE);
		}

		else if (getIntent().getAction().equals(
				ACTION_SHOW_LEADERBOARD_BY_ID_ACTIVITY)) {
			String leaderboardId = getIntent().getStringExtra(
					EXTRA_LEADERBOARD_ID);
			startActivityForResult(Games.Leaderboards.getLeaderboardIntent(
					SignInActivity.mHelper.getApiClient(), leaderboardId),
					REQUEST_CODE);
		}

		isShown = true;
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == REQUEST_CODE
				&& resultCode == GamesActivityResultCodes.RESULT_RECONNECT_REQUIRED) {
			SignInActivity.mHelper.onDisconnectedFromGoogleActivity();

		}
		isShown = false;
		finish();
		
	}

}

package com.google.api.games;

import android.content.Intent;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREInvalidObjectException;
import com.adobe.fre.FREObject;
import com.adobe.fre.FRETypeMismatchException;
import com.adobe.fre.FREWrongThreadException;
import com.google.android.gms.games.Games;

public class Leaderboards {
	public static class showAll implements FREFunction {

		@Override
		public FREObject call(FREContext context, FREObject[] args) {
			

			Intent intent = new Intent(context.getActivity(), StubActivity.class);
			intent.setAction(StubActivity.ACTION_SHOW_LEADERBOARDS_ACTIVITY);
			context.getActivity().startActivity(intent);
			return null;
		}

	}
	
	public static class show implements FREFunction {

		@Override
		public FREObject call(FREContext context, FREObject[] args) {
			try {
				
				Intent intent = new Intent(context.getActivity(), StubActivity.class);
				intent.setAction(StubActivity.ACTION_SHOW_LEADERBOARD_BY_ID_ACTIVITY);
				intent.putExtra(StubActivity.EXTRA_LEADERBOARD_ID, args[0].getAsString());
				context.getActivity().startActivity(intent);
			} catch (IllegalStateException e) {
			
				e.printStackTrace();
			} catch (FRETypeMismatchException e) {
				
				e.printStackTrace();
			} catch (FREInvalidObjectException e) {
				
				e.printStackTrace();
			} catch (FREWrongThreadException e) {
			
				e.printStackTrace();
			}
			return null;
		}

	}

	public static class submitScore implements FREFunction {

		@Override
		public FREObject call(FREContext context, FREObject[] args) {
			try {
				Games.Leaderboards.submitScore(SignInActivity.mHelper.getApiClient(),
						args[0].getAsString(), args[1].getAsInt());
			} catch (IllegalStateException e) {

				e.printStackTrace();
			} catch (FRETypeMismatchException e) {

				e.printStackTrace();
			} catch (FREInvalidObjectException e) {

				e.printStackTrace();
			} catch (FREWrongThreadException e) {

				e.printStackTrace();
			}
			return null;
		}

	}
}

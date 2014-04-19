package com.google.api.games;

import android.content.Intent;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREInvalidObjectException;
import com.adobe.fre.FREObject;
import com.adobe.fre.FRETypeMismatchException;
import com.adobe.fre.FREWrongThreadException;
import com.google.android.gms.games.Games;

public class Achievements {

	public static class show implements FREFunction {

		@Override
		public FREObject call(FREContext context, FREObject[] arg1) {

			Intent intent = new Intent(context.getActivity(), StubActivity.class);
			intent.setAction(StubActivity.ACTION_SHOW_ACHIEVEMENTS_ACTIVITY);
			context.getActivity().startActivity(intent);
			return null;
		}
	}

	public static class reveal implements FREFunction {

		@Override
		public FREObject call(FREContext context, FREObject[] args) {
			try {
				Games.Achievements.reveal(
						SignInActivity.mHelper.getApiClient(),
						args[0].getAsString());
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

	public static class unlock implements FREFunction {

		@Override
		public FREObject call(FREContext context, FREObject[] args) {
			try {
				Games.Achievements.unlock(
						SignInActivity.mHelper.getApiClient(),
						args[0].getAsString());
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

	public static class increment implements FREFunction {

		@Override
		public FREObject call(FREContext context, FREObject[] args) {
			try {
				Games.Achievements.increment(
						SignInActivity.mHelper.getApiClient(),
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

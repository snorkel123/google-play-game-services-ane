package com.google.api.games;

import android.os.Bundle;

import com.google.example.games.basegameutils.BaseGameActivity;

public class SignInActivity extends BaseGameActivity {

	@Override
	protected void onCreate(Bundle b) {

		super.onCreate(b);
		if (mHelper == null) {
			getGameHelper();
			mHelper.setActivityForDialogs(Extension.context.getActivity());
			mHelper.setup(Extension.context);
			

			if (Extension.autoSignIn)
				mHelper.setMaxAutoSignInAttempts(3);
			else
				mHelper.setMaxAutoSignInAttempts(0);

		}

	}

}

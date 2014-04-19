package com.google.api.games;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREExtension;

public class Extension implements FREExtension {

	public static Context context;
	public static boolean autoSignIn;

	@Override
	public FREContext createContext(String type) {

		context = new Context();

		return context;
	}

	@Override
	public void dispose() {
		
	}

	@Override
	public void initialize() {
		
	}

}

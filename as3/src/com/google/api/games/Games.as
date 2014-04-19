
package com.google.api.games
{
	import flash.desktop.NativeApplication;
	import flash.events.Event;
	import flash.events.EventDispatcher;
	import flash.events.StatusEvent;
	import flash.external.ExtensionContext;
	
	public class Games
	{
		public static var Achievements:iAchievements;
		public static var Leaderboards:iLeaderboards;
		
		private static var funcSignInSuccess:Function;
		private static var funcSignInFail:Function;
		
		internal static var context:ExtensionContext;
		
		public static function initialize():void
		{
			context = ExtensionContext.createExtensionContext("com.google.api.games", null);
			context.addEventListener(StatusEvent.STATUS, onStatusEventListener);
			Achievements = new iAchievements();
			Leaderboards = new iLeaderboards();
		}
		
		public static function addStatusEventListener(listener:Function):void
		{
			context.addEventListener(StatusEvent.STATUS, listener);
		}
		
		public static function removeStatusEventListener(listener:Function):void
		{
			context.removeEventListener(StatusEvent.STATUS, listener);
		}
		
		public static function start():void
		{
			context.call("start", null);
		}
		
		public static function promptUserToSignInOnStartup(enable:Boolean):void
		{
			
			context.call("promptUserToSignInOnStartup", enable);
		}
		
		public static function setSignInSuccessListener(func:Function):void
		{
			funcSignInSuccess = func;
		}
		
		public static function setSignInFailListener(func:Function):void
		{
			funcSignInFail = func;
		}
		
		public static function beginUserInitiatedSignIn():void
		{
			
			context.call("beginUserInitiatedSignIn", null);
		}
		
		public static function isSignedIn():Boolean
		{
			return context.call("isSignedIn", null) as Boolean;
		}
		
		public static function signOut():void
		{
			
			context.call("signOut", null);
		}
		
		private static function onStatusEventListener(e:StatusEvent):void
		{
			switch (e.code)
			{
				case SignIn.SUCCESS: 
					funcSignInSuccess();
					break;
				case SignIn.FAIL: 
					funcSignInFail();
					break;
			}
		}
	
	}

}
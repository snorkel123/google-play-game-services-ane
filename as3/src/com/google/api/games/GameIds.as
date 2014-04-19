package com.google.api.games
{
	
	public class GameIds
	{
		private static var xml:XML;
		
		public static function initialize(xml:XML)
		{
			GameIds.xml = xml;
		}
		
		public static function getIdByName(name:String):String
		{
			var xnList:XMLList = xml.string.(@name == name);
			return xnList[0];
		}
	
	}

}


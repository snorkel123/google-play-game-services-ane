package com.google.api.games
{
	
	public class GameIds
	{
		private static var xml:XML;
		
		public static function initialize(xml:XML) : void
		{
			GameIds.xml = xml;
		}
		
		public static function getIdByName(pName:String):String
		{
			var xnList:XMLList = xml.string.(@name == pName);
			return xnList[0];
		}
	
	}

}


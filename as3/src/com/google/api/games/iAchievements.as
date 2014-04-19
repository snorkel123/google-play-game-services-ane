package com.google.api.games 
{

	internal class iAchievements 
	{
		public function show():void
		{
			if(Games.context) Games.context.call("Achievements.show",null);
		}
		
		public function reveal(id:String):void
		{
			if (Games.context) Games.context.call("Achievements.reveal",id);
		}
		
		public function unlock(id:String):void
		{
			if (Games.context) Games.context.call("Achievements.unlock",id);
		}
		
		public function increment(id:String, numSteps:int):void
		{
			if (Games.context) Games.context.call("Achievements.increment",id, numSteps);
		}
		
		
		
	}

}
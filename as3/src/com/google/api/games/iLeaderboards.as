package com.google.api.games 
{
	internal class iLeaderboards 
	{
		public function showAll():void
		{
			if (Games.context) Games.context.call("Leaderboards.showAll",null);
		}
		
		public function show(id:String):void
		{
			if (Games.context) Games.context.call("Leaderboards.show",id);
		}
		
		public function submitScore(id:String, score:Number):void
		{
			if (Games.context) Games.context.call("Leaderboards.submitScore",id,score);
		}
		
	}

}
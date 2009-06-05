package player;

import java.io.File;

public class Ranking {

	private class Player {	
		public String user;
		public int score;		
	}
	
	private int n_total_players;
	
	private final int MAX_TOP_PLAYERS = 10;
	
	private Player ranking[] = new Player[MAX_TOP_PLAYERS];
	
	private void SaveScore(String user, int score){
		
		for(int i=0;i<n_total_players;i++){
			if( ranking[i].score < score ) {
				ranking[i].score = score;
				ranking[i].user  = user;
				break;		
			}
		}
		
	}
	
	
	
	
	
}

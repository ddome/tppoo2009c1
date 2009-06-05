package player;

import java.io.File;

public class Ranking {

	private class Player {	
		public String user;
		public int score;		
	}
	
	private int n_top_players;
	
	private final int MAX_TOP_PLAYERS = 10;
	
	private Player ranking[] = new Player[MAX_TOP_PLAYERS];
	
	private File rankingFile;
	
	public Ranking(File rankingFile){
	
		this.rankingFile = rankingFile;
		
		//CARGAR RANKING ranking[] = CARGAR ACA
		// n_top_players = cantidad de players cargados
		
		
	}
	
	public void saveScore(String user, int score){
		
		int i;
		for(i=0;i<n_top_players;i++){
			if( ranking[i].score < score ) {
				ranking[i].score = score;
				ranking[i].user  = user;
				
				//GUARDAR ARCHIVO
				
				break;		
			}
		}
		
		if( i < MAX_TOP_PLAYERS ) {
			ranking[i].score = score;
			ranking[i].user = user;
			
			//GUARDAR ARCHIVO
		}
		
	}
	
	
	
	
	
}

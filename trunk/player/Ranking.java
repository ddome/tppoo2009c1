package player;

import java.io.File;

import questions.LevelException;
import questions.Question;

public class Ranking {
	
	private int n_top_players;
	
	private final int MAX_TOP_PLAYERS = 10;
	
	private Game ranking_easy[] = new Game[MAX_TOP_PLAYERS];
	private Game ranking_medium[] = new Game[MAX_TOP_PLAYERS];
	private Game ranking_hard[] = new Game[MAX_TOP_PLAYERS];
	
	private File rankingFile;
	
	public Ranking(File rankingFile){
	
		this.rankingFile = rankingFile;
		
		//CARGAR RANKING ranking[] = CARGAR ACA
		// n_top_players = cantidad de players cargados
		
		
	}
	
	public void saveScore(Game game){

		Game ranking[];
		
		switch(game.getLevel()) {
			case(Question.LEVEL_EASY ):
				ranking = ranking_easy;
				break;
			case(Question.LEVEL_MEDIUM):
				ranking = ranking_medium;
				break;
			case(Question.LEVEL_HARD):
				ranking = ranking_hard;
				break;
			default: 
				throw new LevelException();		
		}
		
		int i;
		for(i=0;i<n_top_players;i++){
			if( ranking[i].getScore() < game.getScore()) {
				ranking[i].setScore(game.getScore());
				ranking[i].setUser(game.getUser());
				ranking[i].setLevel(game.getLevel());
				
				//GUARDAR ARCHIVO
				
				break;		
			}
		}
		
		if( i < MAX_TOP_PLAYERS ) {
			ranking[i].setScore(game.getScore());
			ranking[i].setUser(game.getUser());
			ranking[i].setLevel(game.getLevel());
			
			//GUARDAR ARCHIVO
		}
		
	}
	
	
	
	
	
}

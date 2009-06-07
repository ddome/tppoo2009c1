package player;

import java.io.File;

import questions.LevelException;
import questions.Question;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.EOFException;

public class Ranking {
	private final int MAX_TOP_PLAYERS = 10;

	private Game ranking_easy[] = new Game[MAX_TOP_PLAYERS];
	private Game ranking_medium[] = new Game[MAX_TOP_PLAYERS];
	private Game ranking_hard[] = new Game[MAX_TOP_PLAYERS];
	
	private File rankingFile;
	
	public Ranking(File rankingFile) throws RankingFileException,Exception{
	
		this.rankingFile = rankingFile;

		ReadScores();
	}
	
	public void saveScore(Game game)throws LevelException,Exception{

		Game ranking[];
		Game aux;
		int i;
		
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
		
		for(i=0;ranking[i]!=null && i<MAX_TOP_PLAYERS;i++){
			if( ranking[i]!=null && (ranking[i].getScore() < game.getScore()) ) {
				aux=game;
				game=ranking[i];
				ranking[i]=aux;
			}
		}
		
		if( i < MAX_TOP_PLAYERS && ranking[i]==null) {
			
			ranking[i] = new Game(game.getUser(),game.getLevel());
			ranking[i].setScore(game.getScore());
		}

		WriteScores();
	
	}

	
	private void WriteScores() throws LevelException,Exception{
		int level=Question.LEVEL_EASY,i;
		boolean exit=false;
		Game ranking[];
		ObjectOutputStream wFile = new ObjectOutputStream(new FileOutputStream(rankingFile));
		
		try{
			while(!exit){
				
				switch(level) {
				case(Question.LEVEL_EASY ):
					ranking = ranking_easy;
					level=Question.LEVEL_MEDIUM;
					break;
				case(Question.LEVEL_MEDIUM):
					ranking = ranking_medium;
					level=Question.LEVEL_HARD;
					break;
				case(Question.LEVEL_HARD):
					ranking = ranking_hard;
					exit=true;
					break;
				default: 
					throw new LevelException();		
				}
				i=0;
				while(ranking[i]!=null){
					wFile.writeInt(ranking[i].getLevel());
					wFile.writeInt(ranking[i].getScore());
					wFile.writeObject(ranking[i].getUser());
					i++;
				}	
			}
		}catch(Exception e){
			throw e;
		}
		finally{
			wFile.close();
		}
	}
	
	private void ReadScores() throws Exception{
		ObjectInputStream rFile = new ObjectInputStream(new FileInputStream(rankingFile));
		int level,i=0,j=0,k=0,score;
		String user;
		boolean exit=false;
		Game player;
		try{
			
			while(!exit){
				level=rFile.readInt();
				
				switch(level) {
					case(Question.LEVEL_EASY ):
						System.out.println("Leyendo");
						ranking_easy[i] = new Game();
						player = ranking_easy[i];
						i++;
						break;
					case(Question.LEVEL_MEDIUM):
						player = ranking_medium[j];
						j++;
						break;
					case(Question.LEVEL_HARD):
						player = ranking_hard[k];
						k++;
						break;
					default: 
						throw new LevelException();		
				}
				
				try{
					score=rFile.readInt();
					user=(String)rFile.readObject();
				}catch(Exception e){
					rFile.close();
					throw new RankingFileException("Archivo invalido.");
				}
				player.setLevel(level);
				player.setUser(user);
				player.setScore(score);
			}
			
		}catch(EOFException e){

		}finally{
			rFile.close();
		}
	}
	
	
	
	
	
}


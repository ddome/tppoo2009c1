package player;

import java.io.File;

import questions.LevelException;
import questions.Question;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.EOFException;

/**
 * Clase que administra el ranking de maximos puntajes de usuarios
 * @author Grupo 4 de Programacion Orientada a Objetos
 *
 */
public class Ranking {
	public final int MAX_TOP_PLAYERS = 10;

	private Game ranking_easy[] = new Game[MAX_TOP_PLAYERS];
	private Game ranking_medium[] = new Game[MAX_TOP_PLAYERS];
	private Game ranking_hard[] = new Game[MAX_TOP_PLAYERS];
	
	private File rankingFile;
	
	/**
	 * Devuelve una nueva instancia
	 * @param rankingFile El archivo de los maximos puntajes
	 * @throws RankingFileException Error al leer el archivo de maximos puntajes
	 * @throws Exception
	 */
	public Ranking(File rankingFile) throws RankingFileException,Exception{
	
		this.rankingFile = rankingFile;
		try{
		    ReadScores();
		}catch(Exception e){
			rankingFile.delete();
			rankingFile.createNewFile();
			ReadScores();
		}
	}
	
	/**
	 * Guarda el puntaje para un juego en caso de haber llegado al top 10.
	 * @param game El usuario y puntaje
	 * @throws LevelException Nivel de dificultad invalido
	 * @throws Exception 
	 */
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
		
		for(i=0;i<MAX_TOP_PLAYERS && ranking[i]!=null;i++){
			if( ranking[i]!=null && (ranking[i].getScore() < game.getScore()) ) {
				aux=game;
				game=ranking[i];
				ranking[i]=new Game(aux.getUser(),aux.getLevel());
				ranking[i].setScore(aux.getScore());
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
				while(i<MAX_TOP_PLAYERS && ranking[i]!=null){
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
	
	private void ReadScores() throws Exception,RankingFileException{
		ObjectInputStream rFile;
		try{
			rFile = new ObjectInputStream(new FileInputStream(rankingFile));
		}catch(EOFException e){
			return;
		}
		int level,i=0,j=0,k=0,score;
		String user;
		boolean exit=false;
		Game player;
		try{
			
			while(!exit){
				try{
					level=rFile.readInt();
				}catch(EOFException e2){
					return;
				}
				switch(level) {
					case(Question.LEVEL_EASY ):
						ranking_easy[i] = new Game();
						player = ranking_easy[i];
						i++;
						break;
					case(Question.LEVEL_MEDIUM):
						ranking_medium[j] = new Game();
						player = ranking_medium[j];
						j++;
						break;
					case(Question.LEVEL_HARD):
						ranking_hard[k] = new Game();
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
				if(user==null || (level!=Question.LEVEL_EASY && level!=Question.LEVEL_MEDIUM && level!=Question.LEVEL_HARD))
					throw new RankingFileException("Archivo invalido.");
				player.setScore(score);
				player.setUser(user);
				player.setLevel(level);
			}
			
		}catch(EOFException e){
			
		}finally{
			rFile.close();
		}
	}
	
	public Game[] getEasyTop(){
		return ranking_easy.clone();
	}
	
	public Game[] getMediumTop(){
		return ranking_medium.clone();
	}
	
	public Game[] getHardTop(){
		return ranking_hard.clone();
	}
	
}
package questions;
import java.util.*;
import java.io.File;
import java.io.IOException;

import fileHandler.*;

import player.*;

import fileHandler.FileParser;
import fileHandler.QuestionSaver;

/** 
 * Clase encargada de almacenar y administrar las preguntas
 * utilizadas en cada juego.
 * @author Grupo 4 de Programacion Orientada a Objetos
 *
 */

public class Questionnaire {
	
	private LinkedList<Question> easy_questions   = new LinkedList<Question>();
	private LinkedList<Question> medium_questions = new LinkedList<Question>();
	private LinkedList<Question> hard_questions   = new LinkedList<Question>();
	
	public static final int QUESTIONS_NUMBER = 10;
	
	private File rankingFile;
	private File questionsFile;
		
	/**
	 * Devuelve una nueva instancia.
	 * @param questionsFile El archivo con las preguntas.
	 * @param rankingFile El archivo con los maximos puntajes.
	 * @throws RankingFileException Error al leer el archivo de puntajes
	 * @throws FileParserException Error al leer el archivo de las preguntas
	 * @throws Exception
	 */
	public Questionnaire( File questionsFile, File rankingFile ) throws RankingFileException,FileParserException,Exception{
		
		FileParser fd = new FileParser(questionsFile);
		ArrayList<Question> questions = fd.readQuestions();
		fd.close();
		this.rankingFile = rankingFile;
		this.questionsFile = questionsFile;

		for( Question q: questions ) {
			switch(q.getLevel()) {
			
			case(Question.LEVEL_EASY ):
				if( !(this.easy_questions.contains(q))  )
					this.easy_questions.add(q);
				break;
			case(Question.LEVEL_MEDIUM):
				if( !this.medium_questions.contains(q)  )
					this.medium_questions.add(q);
				break;
			case(Question.LEVEL_HARD):
				if( !this.hard_questions.contains(q)  )
					this.hard_questions.add(q);
				break;
			default: 
				throw new LevelException();		
			}
		}

		/* Lo dejo preparado para una nueva jugada */
		Collections.shuffle(easy_questions);
		Collections.shuffle(medium_questions);
		Collections.shuffle(hard_questions);
		
	}
	
	/**
	 * Genera un nuevo juego de diez preguntas al azar.
	 * @param user El usuario a guardar en caso de alcanzar un puntaje maximo
	 * @param level El nivel del juego
	 * @return Un nuevo juego con diez preguntas tomadas al azar del cuestionario
	 * @throws LevelException El nivel de dificultad es incorrecto
	 * @throws Exception
	 */
	public Quiz generateQuiz(String user,int level) throws LevelException,Exception {
		
		Question q[];
		List<Question> list;
		int size;
		
		switch(level) {	
		case(Question.LEVEL_EASY ):
			list = easy_questions;
			break;
		case(Question.LEVEL_MEDIUM):
			list = medium_questions;
			break;
		case(Question.LEVEL_HARD):
			list = hard_questions;
			break;
		default: 
			throw new LevelException();		
		}
		/* Chequeo si hay menos preguntas que el estandar de diez */
		if( list.size() < QUESTIONS_NUMBER )
			size = list.size();
		else
			size = QUESTIONS_NUMBER;
		/* Guardo las diez primeras preguntas del cuestionario */
		q =  new Question[size];				
		for(int i=0;i<size;i++) {
			q[i] = list.get(i);
		}
		/* Dejo listo el cuestionario para un nuevo juego */
		Collections.shuffle(list);
		return new Quiz(user,level,q,rankingFile);			
	}
	
	/**
	 * @param level El nivel de dificultad de la lista a devolver
	 * @return Una lista de preguntas de la dificultad pedida
	 */
	public Question[] getQuestionList(int level){
		
		LinkedList<Question> list;
		Question[] questions;

		switch(level) {
			case(Question.LEVEL_EASY ):
				list = easy_questions;
				break;
			case(Question.LEVEL_MEDIUM):
				list = medium_questions;
				break;
			case(Question.LEVEL_HARD):
				list = hard_questions;
				break;
			default: 
				throw new LevelException();		
		}
		questions = new Question[list.size()+1];
		questions = list.toArray(questions);
		return questions;
	}
	
	/**
	 * Borra una pregunta de la base de datos.
	 * @param q Pregunta a borrar
	 */
	public void deleteQuestion(Question q){

		LinkedList<Question> list;
		switch(q.getLevel()) {
			case(Question.LEVEL_EASY ):
				list = easy_questions;
				break;
			case(Question.LEVEL_MEDIUM):
				list = medium_questions;
				break;
			default:
				list = hard_questions;				
		}		
		
		
		for( Question q2: list ) {
			
			if( q2.equals(q)  ) {
				list.remove(q2);
				break;
			}			
		}
		
		SaveModification();
	}
	
	/**
	 * Agrega una pregunta a la base de datos.
	 * @param q La pregunta a agregar
	 */
	public void newQuestion(Question q) {
		
		LinkedList<Question> list;
		
		switch(q.getLevel()) {
			case(Question.LEVEL_EASY ):
				list = easy_questions;
				break;
			case(Question.LEVEL_MEDIUM):
				list = medium_questions;
				break;
			default:
				list = hard_questions;				
		}
		
		list.add(q);
		
		SaveModification();
	}

	/**
	 * Modifica una pregunta de la base de datos.
	 * @param org La pregunta original a modificar
	 * @param mod La pregunta modificada
	 * @throws IOException 
	 */
	public void modifyQuestion(Question org,Question mod) {
		
		LinkedList<Question> list;
		
		deleteQuestion(org);	
		newQuestion(mod);
		
		SaveModification();
	}
	
	/**
	 * 
	 * @param q Pregunta a buscar
	 * @return Verdadero si contiene a la pregunta, falso caso contrario
	 */
	public boolean containsQuestion(Question q){
		
		LinkedList<Question> list;
		
		switch(q.getLevel()) {
			case(Question.LEVEL_EASY ):
				list = easy_questions;
				break;
			case(Question.LEVEL_MEDIUM):
				list = medium_questions;
				break;
			default:
				list = hard_questions;				
		}
		return list.contains(q);		
	}
	
	private void SaveModification(){
		Question[] easy_questionsAux = new Question[easy_questions.size()];
		Question[] medium_questionsAux = new Question[medium_questions.size()];
		Question[] hard_questionsAux = new Question[hard_questions.size()];
		
		easy_questionsAux = easy_questions.toArray(easy_questionsAux);
		medium_questionsAux = medium_questions.toArray(medium_questionsAux);
		hard_questionsAux = hard_questions.toArray(hard_questionsAux);

		QuestionSaver saver = new QuestionSaver(questionsFile);
		saver.Save(easy_questionsAux, medium_questionsAux, hard_questionsAux);
		saver.close();
	}
	
	/**
	 * 
	 * @return La lista con los TOP 10 por nivel.
	 */
	public String[] getMaxScores(int level)throws RankingFileException,Exception{
		String[] retTop;
		Game[] top;
		Ranking rank = new Ranking(rankingFile);
		int i;
		switch(level){
			case(Question.LEVEL_EASY ):
				top=rank.getEasyTop();
				break;
			case(Question.LEVEL_MEDIUM):
				top=rank.getMediumTop();
				break;
			case(Question.LEVEL_HARD):
				top=rank.getHardTop();
				break;
			default: 
				throw new LevelException("Nivel incorrecto");
		}
		retTop= new String[top.length+1];
		for(i=0;i<top.length;i++){
			retTop[i] =Integer.valueOf(top[i].getScore()).toString().concat("  ->  " + top[i].getUser());
		}
		
		return retTop;
	}
	
	
}


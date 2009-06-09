package questions;
import java.util.*;
import java.io.File;
import java.io.IOException;

import fileHandler.*;

import player.*;

import fileHandler.FileParser;
import fileHandler.QuestionSaver;

public class Questionnaire {
	
	private LinkedList<Question> easy_questions   = new LinkedList<Question>();
	private LinkedList<Question> medium_questions = new LinkedList<Question>();
	private LinkedList<Question> hard_questions   = new LinkedList<Question>();
	
	public static final int QUESTIONS_NUMBER = 10;
	
	private File rankingFile;
	private File questionsFile;
		
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

		
		Collections.shuffle(easy_questions);
		Collections.shuffle(medium_questions);
		Collections.shuffle(hard_questions);
		
	}
	
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
		
		if( list.size() < QUESTIONS_NUMBER )
			size = list.size();
		else
			size = QUESTIONS_NUMBER;
		
		q =  new Question[size];
				
		for(int i=0;i<size;i++) {
			q[i] = list.get(i);
		}
		
		Collections.shuffle(list);
		
		return new Quiz(user,level,q,rankingFile);			
	}
	
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
		try{
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
			Question[] easy_questionsAux = new Question[easy_questions.size()];
			Question[] medium_questionsAux = new Question[medium_questions.size()];
			Question[] hard_questionsAux = new Question[hard_questions.size()];
			
			easy_questionsAux = easy_questions.toArray(easy_questionsAux);
			medium_questionsAux = medium_questions.toArray(medium_questionsAux);
			hard_questionsAux = hard_questions.toArray(hard_questionsAux);

			QuestionSaver qSaver = new QuestionSaver(questionsFile,easy_questionsAux,medium_questionsAux,hard_questionsAux);

		}catch(Exception e){
			System.out.println(e.getMessage());
		}
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
		
	}

	/**
	 * Modifica una pregunta de la base de datos.
	 * @param org La pregunta original a modificar
	 * @param mod La pregunta modificada
	 * @throws IOException 
	 */
	public void modifyQuestion(Question org,Question mod) throws IOException {
		
		LinkedList<Question> list;
		
		deleteQuestion(org);	
		newQuestion(mod);
		
	}
	
	
	
	
	
}


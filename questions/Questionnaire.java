package questions;
import java.util.*;
import java.io.File;
import fileHandler.*;

import fileHandler.FileParser;

public class Questionnaire {
	
	private LinkedList<Question> easy_questions   = new LinkedList<Question>();
	private LinkedList<Question> medium_questions = new LinkedList<Question>();
	private LinkedList<Question> hard_questions   = new LinkedList<Question>();
	
	public static final int QUESTIONS_NUMBER = 10;
		
	public Questionnaire( File questionsFile ) throws FileParserException,Exception{
		
		FileParser fd = new FileParser(questionsFile);
		ArrayList<Question> questions = fd.readQuestions();
		fd.close();

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
	
	public Quiz generateQuiz(String user,int level) throws LevelException {
		
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
		
		return new Quiz(user,q);			
	}
	
	public Question[] getQuestionList(int level){
		
		LinkedList<Question> list;
		
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
	
		return (Question[])list.toArray();
	}

	
	
	
}

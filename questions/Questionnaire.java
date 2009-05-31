package questions;
import java.util.*; 

public class Questionnaire {
	
	private ArrayList<Question> easy_questions   = new ArrayList<Question>();
	private ArrayList<Question> medium_questions = new ArrayList<Question>();
	private ArrayList<Question> hard_questions   = new ArrayList<Question>();
	
	public static final int QUESTIONS_NUMBER = 10;
	
	public Questionnaire(Question questions[] ) {
		
		for( Question q: questions ) {
			if( q.getLevel() == Question.LEVEL_EASY )
				this.easy_questions.add(q);
			else if( q.getLevel() == Question.LEVEL_MEDIUM )
				this.medium_questions.add(q);
			else if(  q.getLevel() == Question.LEVEL_HARD  )
				this.hard_questions.add(q);
		}		
	}
	
	public Quiz generateQuiz(int level) throws LevelException {
		
		Question q[] = new Question[QUESTIONS_NUMBER];
		ArrayList<Question> list;
		
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
				
		for(int i=0;i<QUESTIONS_NUMBER;i++) {
			q[i] = list.get(i);
		}
		return new Quiz(q);			
	}
	
	
}

package questions;
import java.util.*; 

public class Questionnaire {
	
	private LinkedList<Question> easy_questions   = new LinkedList<Question>();
	private LinkedList<Question> medium_questions = new LinkedList<Question>();
	private LinkedList<Question> hard_questions   = new LinkedList<Question>();
	
	public static final int QUESTIONS_NUMBER = 10;
	
	public Questionnaire(Question questions[] ) {
				
		for( Question q: questions ) {
			switch(q.getLevel()) {
			
			case(Question.LEVEL_EASY ):
				this.easy_questions.add(q);
				break;
			case(Question.LEVEL_MEDIUM):
				this.medium_questions.add(q);
				break;
			case(Question.LEVEL_HARD):
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
		
		Question q[] = new Question[QUESTIONS_NUMBER];
		List<Question> list;
		
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
		
		Collections.shuffle(list);
		
		return new Quiz(user,q);			
	}
	
	
}

package questions;
import java.util.*; 

public class Quiz {
	
	private ArrayList<Question> easy_questions   = new ArrayList<Question>();
	private ArrayList<Question> medium_questions = new ArrayList<Question>();
	private ArrayList<Question> hard_questions   = new ArrayList<Question>();
	
	public Quiz(Question questions[] ) {
		
		for( Question q: questions ) {
			if( q.getLevel() == Question.LEVEL_EASY )
				this.easy_questions.add(q);
			else if( q.getLevel() == Question.LEVEL_MEDIUM )
				this.medium_questions.add(q);
			else if(  q.getLevel() == Question.LEVEL_HARD  )
				this.hard_questions.add(q);
		}		
	}
	
}

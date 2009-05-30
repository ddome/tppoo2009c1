import questions.BooleanQuestion;
import questions.MultipleChoiceQuestion;
import questions.Question;
import questions.SimpleNumberQuestion;
import questions.SimpleTextQuestion;
import questions.SingleChoiceQuestion;

public class prueba {

	public static void main( String[] args) {
	
		String choices1[] = {"uno","dos","tres"};
		String choices2[] = {"Evita","Madona","Isabel"};
		Integer answers[] = {1,3};
		Integer fruta[] = {1,3};
		
		BooleanQuestion q1 = new BooleanQuestion("Peron es gay?", true, Question.LEVEL_EASY);
		SimpleTextQuestion q2 = new SimpleTextQuestion("Presidente de Argentina", "Peron", Question.LEVEL_EASY);
		SimpleNumberQuestion q3 = new SimpleNumberQuestion("Numero de trabas que se comio Peron",455,Question.LEVEL_MEDIUM);
		SingleChoiceQuestion q4 = new SingleChoiceQuestion("Que tan gay era Peron?", choices1,1, Question.LEVEL_HARD );
		MultipleChoiceQuestion q5 = new MultipleChoiceQuestion("Esposas de Peron",choices2, answers, Question.LEVEL_EASY );
		
		System.out.println(q1.isCorrect(true));
		System.out.println(q2.isCorrect("peron"));
		System.out.println(q3.isCorrect(455));
		System.out.println(q4.isCorrect(1));
		System.out.println(q5.isCorrect(fruta));
		
	}
		
}

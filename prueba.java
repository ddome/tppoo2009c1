import questions.*;

public class prueba {

	public static void main( String[] args) {
	
		String choices1[] = {"uno","dos","tres"};
		String choices2[] = {"Evita","Madona","Isabel"};
		Integer answers[] = {1,3};
		Integer fruta[] = {1,3};
		Question qarray[] = new Question[10];
				

		
		BooleanQuestion q1 = new BooleanQuestion("Peron es gay?", true, Question.LEVEL_EASY,10);
		SimpleTextQuestion q2 = new SimpleTextQuestion("Presidente de Argentina", "Peron", Question.LEVEL_EASY,10);
		SimpleNumberQuestion q3 = new SimpleNumberQuestion("Numero de trabas que se comio Peron",455,Question.LEVEL_EASY,10);
		SingleChoiceQuestion q4 = new SingleChoiceQuestion("Que tan gay era Peron?", choices1,1, Question.LEVEL_EASY,10 );
		MultipleChoiceQuestion q5 = new MultipleChoiceQuestion("Esposas de Peron",choices2, answers, Question.LEVEL_EASY,10 );
		BooleanQuestion q6 = new BooleanQuestion("Peron es gay?", true, Question.LEVEL_EASY,10);
		SimpleTextQuestion q7 = new SimpleTextQuestion("Presidente de Argentina", "Peron", Question.LEVEL_EASY,10);
		SimpleNumberQuestion q8 = new SimpleNumberQuestion("Numero de trabas que se comio Peron",455,Question.LEVEL_EASY,10);
		SingleChoiceQuestion q9 = new SingleChoiceQuestion("Que tan gay era Peron?", choices1,1, Question.LEVEL_EASY,10 );
		MultipleChoiceQuestion q10 = new MultipleChoiceQuestion("Esposas de Peron",choices2, answers, Question.LEVEL_EASY,10 );	
		
		int pos = 0;
		qarray[pos++] = q1;
		qarray[pos++] = q2;
		qarray[pos++] = q3;
		qarray[pos++] = q4;
		qarray[pos++] = q5;
		qarray[pos++] = q6;
		qarray[pos++] = q7;
		qarray[pos++] = q8;
		qarray[pos++] = q9;
		qarray[pos++] = q10;
				
		Questionnaire preguntas = new Questionnaire(qarray);
		Quiz quiz = preguntas.generateQuiz(Question.LEVEL_EASY);
		
		Question q;
		System.out.println(q = quiz.getNextQuestion());
		System.out.println(q.getClass() );
		quiz.setAnswer(true);
		System.out.println(quiz.getNextQuestion());
		quiz.setAnswer("Peron");
		System.out.println(quiz.getScore());
		System.out.println(quiz.getNextQuestion());
		System.out.println(quiz.getNextQuestion());
		System.out.println(quiz.getNextQuestion());
		
	}
		
}

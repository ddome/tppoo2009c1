package test;

import java.io.File;

import org.junit.Assert;
import org.junit.Test;
import questions.*;

import java.io.*;

public class TestQuestionnaire {
	
	File questions;
	File ranking = new File("testdata/ranking");
	Questionnaire q;
	
	
	@Test
	public void testParser() {
		
		questions = new File("testdata/testaux");
		String choices1[] = {"uno","dos","tres"};
        String choices2[] = {"choice1","choice2","choice3"};
        String answers[] = {"choice1","choice3"};
		BooleanQuestion q1 = new BooleanQuestion("BooleanTest", true, Question.LEVEL_EASY,10);
		SimpleTextQuestion q2 = new SimpleTextQuestion("TextTest", "Peron", Question.LEVEL_EASY,10);
		SimpleNumberQuestion q3 = new SimpleNumberQuestion("NumberTest",455,Question.LEVEL_EASY,10);
		SingleChoiceQuestion q4 = new SingleChoiceQuestion("SingleChoiceTest", choices1,"uno", Question.LEVEL_EASY,10 );
		MultipleChoiceQuestion q5 = new MultipleChoiceQuestion("MulChoiceTest",choices2, answers, Question.LEVEL_EASY,10 );	
		
		try {		
			questions.createNewFile();
		} catch(IOException e){};
		
		try {
			q = new Questionnaire(questions, ranking);
		} catch(Exception e) {};
		
		q.newQuestion(q1);
		q.newQuestion(q2);
		q.newQuestion(q3);
		q.newQuestion(q4);
		q.newQuestion(q5);
		
		try {
			q = new Questionnaire(questions, ranking);
		} catch(Exception e) {};
		
		
		Assert.assertTrue(q.containsQuestion(q1));
		Assert.assertTrue(q.containsQuestion(q2));
		Assert.assertTrue(q.containsQuestion(q3));
		Assert.assertTrue(q.containsQuestion(q4));
		Assert.assertTrue(q.containsQuestion(q5));
		
		
		questions.delete();
	}
	
	@Test
	public void testQuestion() {
		
		questions = new File("testdata/testaux");
		BooleanQuestion q1 = new BooleanQuestion("BooleanTest", true, Question.LEVEL_EASY,10);
		BooleanQuestion q2 = new BooleanQuestion("BooleanTest2", true, Question.LEVEL_EASY,10);
		
		try {		
			questions.createNewFile();
		} catch(IOException e){};
		
		Question[] qarray;
		
		try {
			q = new Questionnaire(questions, ranking);
		} catch(Exception e) {};
		
		q.newQuestion(q1);				
		qarray = q.getQuestionList(Question.LEVEL_EASY);
		Assert.assertTrue(qarray[0].equals(q1));
		
		q.modifyQuestion(q1, q2);
		qarray = q.getQuestionList(Question.LEVEL_EASY);
		Assert.assertTrue(qarray[0].equals(q2));
		
		q.deleteQuestion(q2);
		qarray = q.getQuestionList(Question.LEVEL_EASY);
		Assert.assertTrue(qarray[0] == null);
		
		questions.delete();
	}
	
}

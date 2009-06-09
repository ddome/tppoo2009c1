package test;

import java.io.File;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import questions.*;
import player.*;

public class TestQuiz {
	
    Quiz quiz;
    Question qarray[] = new Question[5];
    Object aarray[] = new Object[5];
	
	@Before
	public void init() {
		
		String choices1[] = {"uno","dos","tres"};
        String choices2[] = {"choice1","choice2","choice3"};
        Integer answers[] = {1,3};
     
        aarray[0] = new Boolean(true);
        aarray[1] = new String("Test");
        aarray[2] = new Integer(455);
        aarray[3] = new Integer(1);
        aarray[4] = answers;      
        
        
		qarray[0] = new BooleanQuestion("BooleanTest", (Boolean)aarray[0], Question.LEVEL_EASY,10);
		qarray[1] = new SimpleTextQuestion("TextTest", (String)aarray[1], Question.LEVEL_EASY,10);
		qarray[2] = new SimpleNumberQuestion("NumberTest",(Integer)aarray[2],Question.LEVEL_EASY,10);
        qarray[3] = new SingleChoiceQuestion("SingleChoiceTest", choices1,(Integer)aarray[3], Question.LEVEL_EASY,10 );
        qarray[4] = new MultipleChoiceQuestion("MulChoiceTest",choices2,(Integer[])aarray[4], Question.LEVEL_EASY,10 );				
	    
        try {
        	quiz = new Quiz("Test",Question.LEVEL_EASY,qarray,new File("testdata/ranking"));
        } catch( RankingFileException e) {
        	
        } catch( Exception e ) {
        	
        }
	}
	
	@Test
	public void testAnswers() {
		
		for(int i=0;i<qarray.length;i++){
			Assert.assertTrue(quiz.getActualQuestion().equals(qarray[i]));
	        try {
	        	quiz.answerActualQuestion(aarray[i]);
	        } catch( RankingFileException e) {
	        } catch( Exception e ) {	        	
	        }			
		}
		Assert.assertTrue((new Integer(quiz.getScore())).equals(50));
		Assert.assertFalse(quiz.questionExists());
	}
		
}

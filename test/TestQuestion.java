package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import questions.*;

public class TestQuestion {

	private BooleanQuestion q1;
	private SimpleTextQuestion q2;
	private SimpleNumberQuestion q3;
	private SingleChoiceQuestion q4;
	private MultipleChoiceQuestion q5;
	
	
	@Before
	public void init() {
		
		String choices1[] = {"uno","dos","tres"};
        String choices2[] = {"choice1","choice2","choice3"};
        Integer answers[] = {1,3};
        
		q1 = new BooleanQuestion("BooleanTest", true, Question.LEVEL_EASY,10);
		q2 = new SimpleTextQuestion("TextTest", "Peron", Question.LEVEL_EASY,10);
		q3 = new SimpleNumberQuestion("NumberTest",455,Question.LEVEL_EASY,10);
        q4 = new SingleChoiceQuestion("SingleChoiceTest", choices1,1, Question.LEVEL_EASY,10 );
        q5 = new MultipleChoiceQuestion("MulChoiceTest",choices2, answers, Question.LEVEL_EASY,10 );				
	  
	}
	
	@Test
	public void testEquals() {
		
		String choices1_copy[] = {"uno","dos","tres"};
        String choices2_copy[] = {"choice1","choice2","choice3"};
        Integer answers_copy[] = {1,3};
		
		BooleanQuestion q1_copy = new BooleanQuestion("BooleanTest", true, Question.LEVEL_EASY,10);
		SimpleTextQuestion q2_copy = new SimpleTextQuestion("TextTest", "Peron", Question.LEVEL_EASY,10);
		SimpleNumberQuestion q3_copy = new SimpleNumberQuestion("NumberTest",455,Question.LEVEL_EASY,10);
		SingleChoiceQuestion q4_copy = new SingleChoiceQuestion("SingleChoiceTest", choices1_copy,1, Question.LEVEL_EASY,10 );
		MultipleChoiceQuestion q5_copy = new MultipleChoiceQuestion("MulChoiceTest",choices2_copy, answers_copy, Question.LEVEL_EASY,10 );
		
		Assert.assertTrue(this.q1.equals(q1_copy));
		Assert.assertTrue(this.q2.equals(q2_copy));
		Assert.assertTrue(this.q3.equals(q3_copy));
		Assert.assertTrue(this.q4.equals(q4_copy));
		Assert.assertTrue(this.q5.equals(q5_copy));
		
		Assert.assertFalse(this.q1.equals(q2_copy));
		Assert.assertFalse(this.q1.equals(q3_copy));
		Assert.assertFalse(this.q1.equals(q4_copy));
		Assert.assertFalse(this.q1.equals(q5_copy));
		
		Assert.assertFalse(this.q2.equals(q1_copy));
		Assert.assertFalse(this.q2.equals(q3_copy));
		Assert.assertFalse(this.q2.equals(q4_copy));
		Assert.assertFalse(this.q2.equals(q5_copy));
		
		Assert.assertFalse(this.q3.equals(q2_copy));
		Assert.assertFalse(this.q3.equals(q1_copy));
		Assert.assertFalse(this.q3.equals(q4_copy));
		Assert.assertFalse(this.q3.equals(q5_copy));
		
		Assert.assertFalse(this.q4.equals(q2_copy));
		Assert.assertFalse(this.q4.equals(q3_copy));
		Assert.assertFalse(this.q4.equals(q1_copy));
		Assert.assertFalse(this.q4.equals(q5_copy));
		
		Assert.assertFalse(this.q5.equals(q2_copy));
		Assert.assertFalse(this.q5.equals(q3_copy));
		Assert.assertFalse(this.q5.equals(q4_copy));
		Assert.assertFalse(this.q5.equals(q1_copy));		
	}
	
	@Test
	public void testIsCorrect() {
	
		Assert.assertTrue(this.q1.isCorrect(q1.getAnswer()));
		Assert.assertTrue(this.q2.isCorrect(q2.getAnswer()));
		Assert.assertTrue(this.q3.isCorrect(q3.getAnswer()));
		Assert.assertTrue(this.q4.isCorrect(q4.getAnswer()));
		Assert.assertTrue(this.q5.isCorrect(q5.getAnswers()));
		
	}
	
		
}

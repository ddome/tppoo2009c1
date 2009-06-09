package fileHandler;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import questions.BooleanQuestion;
import questions.LevelException;
import questions.MultipleChoiceQuestion;
import questions.Question;
import questions.SimpleNumberQuestion;
import questions.SimpleTextQuestion;
import questions.SingleChoiceQuestion;

public class QuestionSaver {
	private BufferedWriter outFile;
	
	public QuestionSaver(File output,Question[] easy_questions,Question[] medium_questions,Question[]  hard_questions) throws IOException{
		int level=Question.LEVEL_EASY;
		boolean exit=false;
		outFile = new BufferedWriter(new FileWriter(output));
		Question[] questions=null;
		while(!exit){
			switch(level) {
				case(Question.LEVEL_EASY ):
					questions=easy_questions;
					level=Question.LEVEL_MEDIUM;
					break;
				case(Question.LEVEL_MEDIUM):
					questions=medium_questions;
					level=Question.LEVEL_HARD;
					break;
				case(Question.LEVEL_HARD):
					questions=hard_questions;
					exit=true;
					break;
				default: 
					throw new LevelException("Nivel incorrecto");		
			}
			SaveQuestionsLevel(questions);
		}
		outFile.close();
	}
	
	private void SaveQuestionsLevel(Question[] questions)throws IOException{
		int qLen=questions.length,i=0;
		Question q;
		while(i<qLen){
			//questions[i].WriteToFile(outFile);
			q=questions[i];
			if( q instanceof SimpleTextQuestion)
				((SimpleTextQuestion)q).WriteToFile(outFile);
			else if( q instanceof SimpleNumberQuestion)
				((SimpleNumberQuestion)q).WriteToFile(outFile);
			else if( q instanceof SingleChoiceQuestion)
				((SingleChoiceQuestion)q).WriteToFile(outFile);
			else if( q instanceof MultipleChoiceQuestion)
				((MultipleChoiceQuestion)q).WriteToFile(outFile);
			else if( q instanceof BooleanQuestion)
				((BooleanQuestion)q).WriteToFile(outFile);
			
			outFile.write("####");
			//System.out.println(questions[i].getClass());
			i++;
		}
		
	}
	
	/*private void WriteToFile(SimpleTextQuestion q) throws IOException{
		outFile.write("1");	
		outFile.write(q.getLevel());
		outFile.write("1");
		outFile.write("1");
		outFile.write(q.getQuestion());
		outFile.write(q.getAnswer());
		outFile.write(q.getAnswer());
		outFile.write(q.getScore());
	}*/
	
	/*private void WriteToFile(SimpleNumberQuestion q) throws IOException{
		outFile.write("2");
		outFile.write(q.getLevel());
		outFile.write("1");
		outFile.write("1");
		outFile.write(q.getQuestion());
		outFile.write(q.getAnswer().toString());
		outFile.write(q.getAnswer().toString());
		outFile.write(q.getScore());
	}*/
	

	
	/*private void WriteToFile(SingleChoiceQuestion q) throws IOException{
		int i;
		String[] choices = q.getChoices();
		outFile.write("3");
		outFile.write(q.getLevel());
		outFile.write(choices.length);
		outFile.write("1");
		outFile.write(q.getQuestion());
		for(i=0;i<choices.length;i++)
			outFile.write(choices[i]);
		outFile.write(choices[q.getAnswer()]);
		outFile.write(q.getScore());
	}*/
	
	/*private void WriteToFile(MultipleChoiceQuestion q) throws IOException{
		int i;
		String[] choices = q.getChoices();
		Integer[] answers = q.getAnswers();
		outFile.write("4");
		outFile.write(q.getLevel());
		outFile.write(choices.length);
		outFile.write(answers.length);
		outFile.write(q.getQuestion());
		for(i=0;i<choices.length;i++)
			outFile.write(choices[i]);
		for(i=0;i<answers.length;i++)
			outFile.write(choices[answers[i]]);
		outFile.write(q.getScore());
	}*/
	
	

	/*private void WriteToFile(BooleanQuestion q) throws IOException{
		outFile.write("5");
		outFile.write(q.getLevel());
		outFile.write("2");
		outFile.write("1");
		outFile.write(q.getQuestion());
		outFile.write("Verdadero");
		outFile.write("Falso");
		if(q.getAnswer())
			outFile.write("Verdadero");
		else
			outFile.write("Falso");
		outFile.write(q.getScore());
	}*/
		
}

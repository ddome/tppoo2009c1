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

/**
 * Tipo de pregunta con respuesta verdadero o falso.
 * @author Grupo 4 de Programacion Orientada a Objetos
 *
 */
public class QuestionSaver {
	BufferedWriter outFile;
	
	public QuestionSaver(File ouput){
		try{
			outFile = new BufferedWriter(new FileWriter(ouput));
		}catch(Exception e){
			//throw new QuestionSaverException("Se produjo un error al intentar abrir el archivo.");
		}
	}
	
	public void close(){
		try{
			outFile.close();
		}catch(Exception e){
			//throw new QuestionSaverException("Se produjo un error al intentar cerrar el archivo.");
		}
	}
	
	public void Save(Question[] easy_questions,Question[] medium_questions,Question[]  hard_questions){
		int level=Question.LEVEL_EASY;
		boolean exit=false;
		
		try{
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
		}catch(Exception e){
			
		}
	}
	
	private void SaveQuestionsLevel(Question[] questions)throws QuestionSaverException{
		int i=0;
		Question q;
		try{
			while(i<questions.length){
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
				outFile.newLine();
				i++;
			}
		}catch(IOException e){
			throw new QuestionSaverException("Se produjo un error al intentar guardar los cambios.");
		}
		
	}
		
}

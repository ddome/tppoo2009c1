package questions;

import java.io.BufferedWriter;
import java.io.IOException;


/**
 * Tipo de pregunta de varias opciones con unica respuesta.
 * @author Grupo 4 de Programacion Orientada a Objetos
 *
 */
public class SingleChoiceQuestion extends ChoiceQuestion{
	
	private String answer;
	
	/**
	 * Devuelve una instancia nueva.
	 * @param question La pregunta a responder
	 * @param choices Las opciones posibles
	 * @param answer Las respuestas a la pregunta
	 * @param level El nivel de dificultad
	 * @param score El puntaje de la pregunta
	 */
	public SingleChoiceQuestion(String question,String choices[],String answer, int level,int score){
		super(question,choices,level,score);
		
		this.setAnswer(answer);
	}
	
	/**
	 * Si la respuesta coincide con alguna de las opciones, la guarda.
	 * @param answer La nueva respuesta
	 */
	public void setAnswer(String answer){
		
		if( super.choices.contains(answer))
			this.answer = answer;
	}
	
	@Override
	public boolean isCorrect(Object answer){
		return this.answer.equals(answer);
	}
	
	public boolean isCorrect(Integer answer){
		return this.answer.equals(answer);
	}
	
	/**
	 * 
	 * @return La respuesta asociada
	 */
	public String getAnswer(){
		return answer;
	}
	
	/**
	 * Guarda la pregunta en forma de texto en un archivo
	 * @param outFile El archivo a ser escrito
	 * @throws IOException Error al escribir la pregunta
	 */
	public void WriteToFile(BufferedWriter outFile) throws IOException{
		int i;
		String[] choices = this.getChoices();
		outFile.write("3");
		outFile.newLine();
		outFile.write(Integer.valueOf(this.getLevel()).toString());
		outFile.newLine();
		outFile.write(Integer.valueOf(choices.length).toString());
		outFile.newLine();
		outFile.write("1");
		outFile.newLine();
		outFile.write(this.getQuestion());
		outFile.newLine();
		for(i=0;i<choices.length;i++){
			outFile.write(choices[i]);
			outFile.newLine();
		}
		outFile.write(this.getAnswer());
		outFile.newLine();
		outFile.write(Integer.valueOf(this.getScore()).toString());
		outFile.newLine();
	}
}

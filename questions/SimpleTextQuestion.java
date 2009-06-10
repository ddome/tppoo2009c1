package questions;

import java.io.BufferedWriter;
import java.io.IOException;

/**
 * Tipo de pregunta con respuesta de texto.
 * @author Grupo 4 de Programacion Orientada a Objetos
 *
 */
public class SimpleTextQuestion extends Question {

	private String answer;
	
	/**
	 * Devuelve una nueva instancia.
	 * @param question La pregunta a responder
	 * @param answer La respuesta de texto
	 * @param level El nivel de dificultad
	 * @param score El puntaje de la pregunta
	 */
	public SimpleTextQuestion(String question, String answer, int level,int score){
		super(question,level,score);
		this.answer = answer;
	}
	
	/**
	 * Setea cual es la respuesta a la pregunta.
	 * @param answer La nueva respuesta
	 */
	public void setAnswer(String answer){
		this.answer = answer;
	}
	
	/**
	 * 
	 * @return La respuesta asociada a la pregunta
	 */
	public String getAnswer(){
		return new String(this.answer);
	}
	
	/**
	 * Devuelve true si la respuesta dada era correcta
	 * @param answer La respuesta a verificar
	 * @return Retorna true si la respuesta era correcta, false en caso contrario.
	 */
	@Override
	public boolean isCorrect(Object answer){
		if( answer instanceof String ) 
			return this.answer.toLowerCase().equals(((String)answer).toLowerCase());
		else
			return false;
	}
	
	/**
	 * Devuelve true si la respuesta dada era correcta
	 * @param answer La respuesta a verificar
	 * @return Retorna true si la respuesta era correcta, false en caso contrario.
	 */
	public boolean isCorrect(String answer){
		return this.answer.toLowerCase().equals(answer.toLowerCase());
	}
	
	/**
	 * Guarda la pregunta en forma de texto en un archivo
	 * @param outFile El archivo a ser escrito
	 * @throws IOException Error al escribir la pregunta
	 */
	public void WriteToFile(BufferedWriter outFile) throws IOException{
		outFile.write("1");
		outFile.newLine();
		outFile.write(Integer.valueOf(this.getLevel()).toString());
		outFile.newLine();
		outFile.write("1");
		outFile.newLine();
		outFile.write("1");
		outFile.newLine();
		outFile.write(this.getQuestion());
		outFile.newLine();
		outFile.write(this.getAnswer());
		outFile.newLine();
		outFile.write(this.getAnswer());
		outFile.newLine();
		outFile.write(Integer.valueOf(this.getScore()).toString());
		outFile.newLine();
	}
}

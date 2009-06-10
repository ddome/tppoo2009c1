package questions;

import java.io.BufferedWriter;
import java.io.IOException;

/**
 * Tipo de pregunta con respuesta numerica.
 * @author Grupo 4 de Programacion Orientada a Objetos
 *
 */
public class SimpleNumberQuestion extends Question {

	private Number answer;
	
	/**
	 * Devuelve una nueva instancia.
	 * @param question La pregunta a responder
	 * @param answer La respuesta numerica
	 * @param level El nivel de dificultad
	 * @param score El puntaje de la pregunta
	 */
	public SimpleNumberQuestion(String question, Number answer, int level, int score){
		super(question,level,score);
		this.answer = truncate(answer);
	
	}
	/**
	 * Setea la respuesta correspondiente a la pregunta.
	 * @param answer La nueva respuesta
	 */
	public void setAnswer(Number answer){
		this.answer = answer;
	}
	/**
	 * Devuelve la respuesta correspondiente a la pregunta.
	 * @return La respuesta asociada
	 */
	public Number getAnswer(){
		return this.answer;
	}
	
	/**
	 * Devuelve true si la respuesta dada era correcta
	 * @param answer La respuesta a verificar
	 * @return Retorna true si la respuesta era correcta, false en caso contrario.
	 */
	@Override
	public boolean isCorrect(Object answer){
		if( answer instanceof Number  )
			return this.answer.equals(answer);
		else
			return false;
	}
	
	/**
	 * Devuelve true si la respuesta dada era correcta
	 * @param answer La respuesta a verificar
	 * @return Retorna true si la respuesta era correcta, false en caso contrario.
	 */
	public boolean isCorrect(Number answer){
		return this.answer.equals(truncate(answer));
	}
	
	/**
	 * Guarda la pregunta en forma de texto en un archivo
	 * @param outFile El archivo a ser escrito
	 * @throws IOException Error al escribir la pregunta
	 */
	public void WriteToFile(BufferedWriter outFile) throws IOException{
		outFile.write("2");
		outFile.newLine();
		outFile.write(Integer.valueOf(this.getLevel()).toString());
		outFile.newLine();
		outFile.write("1");
		outFile.newLine();
		outFile.write("1");
		outFile.newLine();
		outFile.write(this.getQuestion());
		outFile.newLine();
		outFile.write(this.getAnswer().toString());
		outFile.newLine();
		outFile.write(this.getAnswer().toString());
		outFile.newLine();
		outFile.write(Integer.valueOf(this.getScore()).toString());
		outFile.newLine();
	}
	
	private double truncate(Number num){
		
		double aux = (long)(num.doubleValue() * 10000);
		return aux/10000;
		
	}
	
}

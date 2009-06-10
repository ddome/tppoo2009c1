package questions;

import java.io.BufferedWriter;
import java.io.IOException;

/**
 * Tipo de pregunta con respuesta verdadero o falso.
 * @author Grupo 4 de Programacion Orientada a Objetos
 *
 */
public class BooleanQuestion extends Question{
	
	private Boolean answer;
	
	/**
	 * Crea una instancia de BooleanQuestion.
	 * @param question La pregunta a responder
	 * @param answer La respuesta verdadero o falso
	 * @param level El nivel de dificultad
	 * @param score El puntaje obtenido al ser respondida correctamente
	 */
	public BooleanQuestion(String question, Boolean answer, int level,int score){
		super(question,level,score);
		this.answer = answer;	
	}
	/**
	 * Setea cual es la respuesta correcta
	 * @param answer La nueva respuesta
	 */
	public void setAnswer(Boolean answer){
		this.answer = answer;
	}
	/**
	 * Devuelve cual es la respuesta correcta
	 * @return La respuesta a la pregunta
	 */
	public Boolean getAnswer(){
		return this.answer;
	}
	
	/**
	 * Devuelve true si la respuesta ingresada es correcta.
	 * @param answer La respuesta que se quiere ver si es correcta
	 */
	@Override
	public boolean isCorrect(Object answer){
		if( answer instanceof Boolean )
			return this.answer.equals(answer);
		else
			return false;
	}
	
	/**
	 * Devuelve true si la respuesta ingresada es correcta.
	 * @param answer La respuesta que se quiere ver si es correcta
	 */
	public boolean isCorrect(Boolean answer){
		return this.answer.equals(answer);
	}
	
	/**
	 * Guarda la pregunta en forma de texto en un archivo
	 * @param outFile El archivo a ser escrito
	 * @throws IOException Error al escribir la pregunta
	 */
	public void WriteToFile(BufferedWriter outFile) throws IOException{
		outFile.write("5");
		outFile.newLine();
		outFile.write(Integer.valueOf(this.getLevel()).toString());
		outFile.newLine();
		outFile.write("2");
		outFile.newLine();
		outFile.write("1");
		outFile.newLine();
		outFile.write(this.getQuestion());
		outFile.newLine();
		outFile.write("Verdadero");
		outFile.newLine();
		outFile.write("Falso");
		outFile.newLine();
		if(this.getAnswer())
			outFile.write("Verdadero");
		else
			outFile.write("Falso");
		outFile.newLine();
		outFile.write(Integer.valueOf(this.getScore()).toString());
		outFile.newLine();
	}
}

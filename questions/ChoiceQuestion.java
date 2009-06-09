package questions;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Clase abstracta que distingue a las preguntas con varias
 * opciones de respuesta.
 * @author Grupo 4 de Programacion Orientada a Objetos
 *
 */
public abstract class ChoiceQuestion extends Question {
	
	protected HashSet<String> choices = new HashSet<String>();

	/**
	 * Devuelve una nueva instancia
	 * @param question La pregunta a responder
	 * @param choices Las opciones a responder
	 * @param level El nivel de dificultad 
	 * @param score El puntaje de la pregunta
	 */
	public ChoiceQuestion(String question, String choices[], int level,int score){
		super(question,level,score);
		
		for( String choice: choices) {		
			this.choices.add(choice);
		}		
	}
	@Override
	public boolean equals(Object o) {
		
		String[] choices = new String[this.choices.size()];
		choices = this.choices.toArray(choices);
			
		if( !(o instanceof ChoiceQuestion) )
			return false;
		if( !Arrays.equals(choices,((ChoiceQuestion)o).getChoices()) )
			return false;
		return super.equals(o);
	}
	
	/**
	 *
	 * @return Un arreglo con las opciones a responder
	 */
	public String[] getChoices(){
		
		String[] choices = new String[this.choices.size()];
		choices = this.choices.toArray(choices);
		
		return choices;
	}
	
}

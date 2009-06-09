package questions;

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
	 * 
	 * @param answer La nueva respuesta
	 */
	public void setAnswer(Boolean answer){
		this.answer = answer;
	}
	/**
	 * 
	 * @return La respuesta a la pregunta
	 */
	public Boolean getAnswer(){
		return this.answer;
	}
	
	public boolean isCorrect(Object answer){
		if( answer instanceof Boolean )
			return this.answer.equals(answer);
		else
			return false;
	}
	
	public boolean isCorrect(Boolean answer){
		return this.answer.equals(answer);
	}
	
}

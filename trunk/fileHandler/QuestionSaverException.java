package fileHandler;

/**
 * Tipo de pregunta con respuesta verdadero o falso.
 * @author Grupo 4 de Programacion Orientada a Objetos
 *
 */
public class QuestionSaverException extends Exception{
	private static final long serialVersionUID = 1L;

	public QuestionSaverException(){
		
	}
	
	public QuestionSaverException(String message){
		super(message);
	}
}

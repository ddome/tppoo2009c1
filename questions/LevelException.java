package questions;

/**
 * Clase que administra el ranking de maximos puntajes de usuarios
 * @author Grupo 4 de Programacion Orientada a Objetos
 *
 */
public class LevelException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public LevelException() {

	}
	public LevelException(String message) {

		super(message);
	}
}

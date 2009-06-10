package player;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;


/**
 * Contiene informacion a cerca de un juego terminado de un usuario.
 * @author Grupo 4 de Programacion Orientada a Objetos
 *
 */
public class Game {
	private String user;
	private int score;
	private int level;
	public Game(){		
	}
	/**
	 * Crea una nueva instancia de Game. Se utiliza para guardar informacion de
	 * un determinado juego determinado.
	 * 
	 * @param user Nombre del usuario
	 * @param level Nivel del usuario 
	 */
	public Game(String user,int level) {
		this.user = user;
		this.level = level;	
	}
	
	/**
	 * Devuelve el nombre del usuario asociado a ese juego.
	 * @return Nombre del usuario.
	 */
	public String getUser() {
		return user;
	}

	/**
	 * Setea el numbre de usuario del que realizo el juego.
	 * @param user Nombre del usuario.
	 * */
	public void setUser(String user) {
		this.user = user;
	}

	/**
	 * Devuelve el puntaje del usuario asociado a ese juego.
	 * @return Puntaje del usuario.
	 */
	public int getScore() {
		return score;
	}

	/**
	 * Setea el puntaje obtenido por el usuario.
	 * @param score Puntaje obtenido
	 */
	public void setScore(int score) {
		this.score = score;
	}

	/**
	 * Devuelve el nivel correspondiente al juego.
	 * @return Nivel correspondiente al juego.
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * Setea el nivel en el que jugo el usuario.
	 * @param level Nivel en el que fue jugado el juego.
	 */
	public void setLevel(int level) {
		this.level = level;
	}
}

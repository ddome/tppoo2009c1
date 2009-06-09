package player;


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
	
	public Game(String user,int level) {
		this.user = user;
		this.level = level;	
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
}

package questions;

/**
 *  
 * Clase abstracta que representa una pregunta.
 * @author Grupo 4 de Programaci—n Orientada a Objetos
 */

public abstract class Question{
	
	private String question;
	private int level;
	private int score;
	
	public static final int LEVEL_EASY   = 0;
	public static final int LEVEL_MEDIUM = 1;
	public static final int LEVEL_HARD   = 2;
	
	/**
	 * MŽtodo utilizado por las subclases para crear instancias
	 * 
	 * @param question La pregunta asociada
	 * @param level    El nivel de dificultad
	 * @param score	   El puntaje obtenido al responder correctamente
	 * @throws LevelException Nivel de dificultad incorrecto
	 */
	public Question(String question, int level,int score) throws LevelException {
		this.question = question;
		this.score = score;
		
		if( level == LEVEL_EASY || level == LEVEL_MEDIUM || level == LEVEL_HARD )
			this.level = level;
		else
			throw new LevelException("Nivel incorrecto");
	}
	
	/**
	 * Metodo a implementar por cada subclase pregunta.
	 * 
	 * @param answer Respuesta a la pregunta. Depende de cada tipo de pregunta
	 * @return Verdadero si la respuesta es correcta. Falso en caso contrario
	 */
	public abstract boolean isCorrect(Object answer);
	
	/**
	 * Hashcode de la clase Question.	
	 */
	public int hashCode(){
		return question.hashCode();
	}
	
	/**
	 * Equals de la clase Question.	
	 */
	public boolean equals(Object q){
		if( !(q instanceof Question) )
			return false;
		else {
			if( !((Question)q).question.equals(this.question) )
				return false;
			else
				return true;
		}
	}
	
	
	/**
	 * 
	 * @return La pregunta asociada
	 */
	public String getQuestion() {
		return question;
	}
	/**
	 * 
	 * @param question La pregunta asociada
	 */
	public void setQuestion(String question) {
		this.question = question;
	}
	/**
	 * 
	 * @return El nivel de dificultad
	 */
	public int getLevel() {
		return level;
	}
	/**
	 * 
	 * @param level El nivel de dificultad
	 */
	public void setLevel(int level) {
		if( level == LEVEL_EASY || level == LEVEL_MEDIUM || level == LEVEL_HARD )
			this.level = level;
		else
			throw new LevelException("Nivel incorrecto");
	}
	/**
	 * 
	 * @return El puntaje de la pregunta
	 */
	public int getScore() {
		return score;
	}
	/**
	 * 
	 * @param score El puntaje de la pregunta
	 */
	public void setScore(int score) {
		this.score = score;
	}
	
	/**
	 * Devuelve la pregunta asociada como un String
	 */
	public String toString(){
		return this.question;
	}
	
}

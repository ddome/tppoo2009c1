package questions;

public abstract class Question{

	private String question;
	private int level;
	private int score;
	
	public static final int LEVEL_EASY   = 0;
	public static final int LEVEL_MEDIUM = 1;
	public static final int LEVEL_HARD   = 2;
	
	public Question(String question, int level,int score) throws LevelException {
		this.question = question;
		this.score = score;
		
		if( level == LEVEL_EASY || level == LEVEL_MEDIUM || level == LEVEL_HARD )
			this.level = level;
		else
			throw new LevelException("Nivel incorrecto");
	}
	
	/* Metodo a implementar, depende de cada tipo de pregunta */
	public abstract boolean isCorrect(Object answer);
	
	public int hashCode(){
		return question.hashCode();
	}
	
	public boolean equals(Object q){
		if( !(q instanceof Question) )
			return false;
		else {
			if( ((Question)q).question == this.question )
				return true;
			else
				return false;
		}
	}
	
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		if( level == LEVEL_EASY || level == LEVEL_MEDIUM || level == LEVEL_HARD )
			this.level = level;
		else
			throw new LevelException("Nivel incorrecto");
	}
	
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	public String toString(){
		return this.question;
	}
	
}

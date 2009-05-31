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
			this.level    = level;
		else
			throw new LevelException("Nivel incorrecto");
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
	
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	public void setLevel(int level) {
		this.level = level;
	}
	
	public abstract boolean isCorrect(Object answer);
}

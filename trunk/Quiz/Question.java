package Quiz;

public abstract class Question<T> {

	private String question;
	private int level;
	public int id;
	
	public Question(String question, int level, int id) {
		this.question = question;
		this.level    = level;
		this.id       = id;
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
		this.level = level;
	}
	
	public abstract boolean isCorrect(T answer);
}

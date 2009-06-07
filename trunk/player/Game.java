package player;

public class Game {
	private String user;
	private int score;
	private int level;

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
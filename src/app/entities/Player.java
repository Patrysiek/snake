package app.entities;

public class Player {

	String name;
	private int score;
	private boolean isAlive;
	public Player(String name ){
		this.name = name;
		score = 0;
		setAlive(true);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}
	
	
	
	
}

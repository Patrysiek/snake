package app.entities;

import javafx.scene.text.Text;

public class Score extends Text {

	private int score;
	private String name;
	public Text text;

	public Score(String name, int score) {
		this.name = name;
		this.score = score;
		this.text = new Text(name + " " + score);
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int compareTo(Score s) {
		if (s.getScore() - score < 0)
			return -1;
		else if (s.getScore() - score > 0)
			return 1;
		else
			return 0;
	}

}

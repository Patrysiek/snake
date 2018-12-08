package app.control;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class HighScoresFile {
	public static HighScoresFile highScoresFile = new HighScoresFile();

	private int score;
	private String fileName = "HighScores.txt",playerName;
	private HighScoresFile() {
		

	}
	
	
	public void appendScore() throws IOException {
		try(FileWriter fw = new FileWriter(fileName, true);
			    BufferedWriter bw = new BufferedWriter(fw);
			    PrintWriter out = new PrintWriter(bw))
			{
			
			    bw.write(playerName+" "+Integer.toString(score));
			    bw.newLine();
			} catch (IOException e) {
			    e.printStackTrace();
			}
	}


	public int getScore() {
		return score;
	}


	public void setScore(int score) {
		this.score = score;
	}


	public String getFileName() {
		return fileName;
	}


	public String getPlayerName() {
		return playerName;
	}


	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	
	
	
	
}

package app.scenes;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import app.Main;
import app.buttons.ExecuteStrategyButton;
import app.buttons.MainMenuButton;
import app.control.HighScoresFile;
import app.entities.Score;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

public class HighScorePane extends Pane {

	private List<Score> highScores;
	private Scanner input;
	ExecuteStrategyButton button;
	private Rectangle frame;
	public HighScorePane() {
		frame = new Rectangle(296,500);
		Main.scene.getStylesheets().remove(0);
		Main.scene.getStylesheets().add("app/scenes/highScoresPane.css");	
		initHighScoresList();
		sortScores();
		showScores();
		initButton();
		Pane.positionInArea(frame, 0.0, 0.0, (double) Main.WIDTH, (double) Main.HEIGHT, 0.0,
				new Insets(0, 0, 120, 46), HPos.CENTER, VPos.BOTTOM, false);
		this.getChildren().addAll(button,frame);
		setCache(true);
	}

	private void sortScores() {
			highScores.sort((s1,s2) -> s1.compareTo(s2));		
	}

	private void showScores() {
		int i = 0;
		for (Score score : highScores) {
			i++;
			if (i < 10) {
				this.getChildren().add(score.text);
				Pane.positionInArea(score.text, 0.0, 0.0, (double) Main.WIDTH, (double) Main.HEIGHT, 0.0,
						new Insets(50 * i, 20, 10, 20), HPos.CENTER, VPos.TOP, false);
			}
		}

	}

	private void initHighScoresList() {
		highScores = new ArrayList<>();
		try (FileReader fileReader = new FileReader(HighScoresFile.highScoresFile.getFileName())) {
			input = new Scanner(fileReader);
			while (input.hasNext()) {
				highScores.add(new Score(input.next(),input.nextInt()));
			}
		} catch (FileNotFoundException e) {
			System.out.println("Nie mozna znalezc pliku");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private void initButton() {
		button = new ExecuteStrategyButton.ButtonBuilder(new MainMenuButton())
				.name("OK")
				.width(500)
				.height(100)
				.build();
		Pane.positionInArea(button, 0.0, 0.0, (double) Main.WIDTH, (double) Main.HEIGHT, 0.0,
				new Insets(0, 250, 100, 0), HPos.CENTER, VPos.BOTTOM, false);
	}

}

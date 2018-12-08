package app.scenes;

import java.io.IOException;

import app.Main;
import app.buttons.ExecuteStrategyButton;
import app.buttons.MainMenuButton;
import app.control.HighScoresFile;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class GameOverPane extends VBox{
ExecuteStrategyButton button;
	public GameOverPane() throws IOException {
		this.setSpacing(10);
		Text text = new Text("Przegrales ! \nTwoj wynik to: "+HighScoresFile.highScoresFile.getScore());
		HighScoresFile.highScoresFile.appendScore();
		Main.scene.getStylesheets().remove(0);
		Main.scene.getStylesheets().add("app/scenes/gameOverPane.css");
		initButton();
		this.getChildren().add(text);
		this.getChildren().add(button);
	}
	private void initButton() {
		button = new ExecuteStrategyButton.ButtonBuilder(new MainMenuButton())
				.name("OK")
				.coordX(Main.WIDTH/2-300)
				.coordY(Main.HEIGHT/2-200)
				.width(400)
				.height(300)
				.build();
	}
}

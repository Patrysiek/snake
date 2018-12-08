package app.buttons;

import app.Main;
import app.scenes.HighScorePane;
import javafx.scene.control.Button;


public class HighScoresButton extends Button implements IButtonStrategy {

	@Override
	public void doOperation() {
		Main.scene.setRoot(new HighScorePane());

	}

}

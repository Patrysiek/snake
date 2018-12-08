package app.buttons;

import app.Main;
import app.scenes.GamePane;
import app.scenes.NamePane;
import javafx.scene.control.Button;


public class GamePaneButton extends Button implements IButtonStrategy {
 public GamePaneButton() {
	}
	@Override
	public void doOperation() {
		Main.scene.setRoot(new GamePane(NamePane.getTextField().getText()));
	}

}

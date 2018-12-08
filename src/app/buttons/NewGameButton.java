package app.buttons;

import app.Main;
import app.scenes.NamePane;
import javafx.scene.control.Button;


public class NewGameButton extends Button implements IButtonStrategy {

	@Override
	public void doOperation() {
		Main.scene.setRoot(new NamePane());
	}

}

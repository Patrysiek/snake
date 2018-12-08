package app.buttons;

import app.Main;
import app.scenes.MenuPane;
import javafx.scene.control.Button;

public class MainMenuButton extends Button implements IButtonStrategy{

	@Override
	public void doOperation() {
		Main.scene.setRoot(new MenuPane());
	}

}

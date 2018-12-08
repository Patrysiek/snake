package app.buttons;

import javafx.application.Platform;
import javafx.scene.control.Button;

//////////////////////////PRZYCISK Z KONKRETNYM DZIALANIEM//////////////////////
public class ExitButton extends Button implements IButtonStrategy {

	@Override
	public void doOperation() {
		Platform.exit();
	}

}

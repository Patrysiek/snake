package app.control;

import app.Main;
import app.entities.Snake;
import javafx.scene.input.KeyCode;

public class SnakeController {
	
	private static SnakeController controller = new SnakeController();
	private SnakeController() {
	}
	public void control(Snake snake) {
		Main.scene.setOnKeyPressed(event -> {
			if (KeyCode.A == event.getCode()&&snake.getDx()==0) {
				snake.setDx(-1);
				snake.setDy(0);
			}
			if (KeyCode.D == event.getCode()&&snake.getDx()==0) {
				snake.setDx(1);
				snake.setDy(0);
			}
			if (KeyCode.S == event.getCode()&&snake.getDy()==0) {
				snake.setDy(1);
				snake.setDx(0);
			}
			if (KeyCode.W == event.getCode()&&snake.getDy()==0) {
				snake.setDy(-1);
				snake.setDx(0);
			}
		});

	}
	public static SnakeController getController() {
		return controller;
	}
	
	
	
}

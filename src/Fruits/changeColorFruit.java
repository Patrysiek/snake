package Fruits;

import app.Main;
import app.scenes.GamePane;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;

public class changeColorFruit extends Fruit {

	public changeColorFruit() {
		super();
		
		this.setFill(Color.CHOCOLATE);
	}
	@Override
	public void makeDifference() {
		GamePane.change = true;
	}

}

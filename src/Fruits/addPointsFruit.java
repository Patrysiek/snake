package Fruits;

import app.scenes.GamePane;
import javafx.scene.paint.Color;

public class addPointsFruit extends Fruit{

	public addPointsFruit() {
		super();
		
		this.setFill(Color.YELLOW);
	}
	@Override
	public void makeDifference() {
		GamePane.player.setScore(GamePane.player.getScore()+20);

	}

}

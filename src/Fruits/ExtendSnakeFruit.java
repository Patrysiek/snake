package Fruits;

import java.util.Random;

import app.scenes.GamePane;
import javafx.scene.paint.Color;

public class ExtendSnakeFruit extends Fruit implements doAction{

	
	public ExtendSnakeFruit() {
		super();
		
		this.setFill(Color.BLACK);
	}

	@Override
	public void makeDifference() {
		Random rand = new Random();
		for(int i=0; i<rand.nextInt(10); i++  )
		GamePane.snake.extend();
	}
	
	
}

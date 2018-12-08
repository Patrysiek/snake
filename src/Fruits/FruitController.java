package Fruits;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FruitController {
	private List<Fruit> fruits;
	public FruitController() {
		fruits = new ArrayList<>();
		fruits.add(new ExtendSnakeFruit());
		fruits.add(new changeColorFruit());
		fruits.add(new addPointsFruit());
		
	}
	public Fruit getElementFromList() {
		return fruits.get(new Random().nextInt(fruits.size()));
	}
	

}

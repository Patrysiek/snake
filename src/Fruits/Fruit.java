package Fruits;

import app.Main;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public abstract class Fruit extends Circle implements doAction{
	private boolean isOnScene;
	private double coordX;
	private double coordY;
	private static double radius = 17;


	public Fruit() {
		super(radius,Color.CRIMSON);
		coordX = Math.random()*1000%Main.WIDTH;
		coordY = Math.random()*1000%Main.HEIGHT;
		this.setTranslateX(coordX);
		this.setTranslateY(coordY);
		
		isOnScene = false;
	}

	public boolean isOnScene() {
		return isOnScene;
	}
	public void setOnScene(boolean isOnScene) {
		this.isOnScene = isOnScene;
	}

	public double getCoordX() {
		return coordX;
	}

	public double getCoordY() {
		return coordY;
	}
	
	public boolean ifcontains(double coordX, double coordY, double width, double height){
		if(this.coordX-radius<coordX && this.coordX+radius>coordX && this.coordY-radius<coordY&&this.coordY+radius>coordY) 
			return true;
		else if( this.coordX-radius<coordX+width && this.coordX+radius>coordX+width && this.coordY-radius<coordY+height && this.coordY+radius>coordY+height)
			return true;
		
		return false;
		
	}

	public void setNewCoordX() {
		this.coordX = Math.random()*1000%Main.WIDTH;
	}

	public void setNewCoordY() {
		this.coordY = Math.random()*1000%Main.WIDTH;
	}

	
}

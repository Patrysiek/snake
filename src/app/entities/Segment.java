package app.entities;

import app.Main;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Segment extends Rectangle {

	private double width;
	private double height;
	private double posY;
	private double posX;
	private Rectangle collider;

	public Segment(double height, double width) {
		super(Main.WIDTH / 2, Main.HEIGHT / 2, width, height);
		this.width = width;
		this.height = height;
		collider = new Rectangle(Main.WIDTH / 2+1,Main.HEIGHT / 2+1,width-1,height-1);
		init();
	}

	public Segment(double posX, double posY, double width, double height) {
		super(posX, posY, width, height);
		collider = new Rectangle(posX+1,posY+1,width-1,height-1);
		this.width = width;
		this.height = height;
		this.posX = posX;
		this.posY = posY;
		init();
	}
	private void init() {
		this.setFill(Color.GREENYELLOW);
		this.setStroke(Color.GREEN);
		this.setStrokeWidth(1);
	}

	public double getSegmentWidth() {
		return width;
	}

	public double getSegmentHeight() {
		return height;
	}

	public double getPosY() {
		return posY;
	}

	public double getPosX() {
		return posX;
	}

	public Rectangle getCollider() {
		return collider;
	}

}

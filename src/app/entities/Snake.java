package app.entities;


import java.util.ArrayList;
import java.util.List;

import app.Main;

public class Snake {

	private Segment header;
	private List<Segment> wholeSnake;
	private int dx = 0, dy = 0;
	private double coordX;
	private double coordY;
	private double width = 20;
	private double height = 20;

	public Snake() {
		
		wholeSnake = new ArrayList<>();
		wholeSnake.add(new Segment(width, height));
		header = wholeSnake.get(wholeSnake.size() - 1);

	}

	private void newSegment() {

		coordX = header.getX() + (header.getWidth() * dx);
		coordY = header.getY() + (header.getHeight() * dy);
		checkForBounds();
		Segment segment = new Segment(coordX, coordY, width, height);
		wholeSnake.add(segment);
		header = wholeSnake.get(wholeSnake.size() - 1);
	}

	private void checkForBounds() {
		if (coordY > Main.HEIGHT)
			coordY = 0;
		if (coordY < 0)
			coordY = Main.HEIGHT-height;
		if (coordX > Main.WIDTH)
			coordX = 0;
		if (coordX < 0)
			coordX = Main.WIDTH-width;
	}

	public boolean failByEaten()  {
		for(int i=0; i<wholeSnake.size()-2; i++) {
			if(header.contains(wholeSnake.get(i).getCollider().getX()+5*dx,wholeSnake.get(i).getCollider().getY()+5*dy)) {
				return true;
			}
			
		}
		return false;
	}

	public void move() {
		newSegment();
		wholeSnake.remove(wholeSnake.get(0));
		
	}

	public void extend() {
		newSegment();
	}

	///////////////////////////////////////////////////////////////// GETTERS &&
	///////////////////////////////////////////////////////////////// SETTERS///////////////////////////////////////////////////////////////////////////
	public int getDx() {
		return dx;
	}

	public void setDx(int dx) {
		this.dx = dx;
	}

	public int getDy() {
		return dy;
	}

	public void setDy(int dy) {
		this.dy = dy;
	}

	public Segment getHeader() {
		return header;
	}

	public double getHeaderTranslateX() {
		return header.getTranslateX();
	}

	public void setHeader(Segment header) {
		this.header = header;
	}

	public double getCoordX() {
		return coordX;
	}

	public double getCoordY() {
		return coordY;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public List<Segment> getWholeSnake() {
		return wholeSnake;
	}

}

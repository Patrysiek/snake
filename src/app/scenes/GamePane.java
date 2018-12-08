package app.scenes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Fruits.Fruit;
import Fruits.FruitController;
import app.Main;
import app.control.HighScoresFile;
import app.control.SnakeController;
import app.entities.Player;
import app.entities.Snake;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.util.Duration;

public class GamePane extends Pane {
	public static Snake snake;
	String playerName;
	public static Timeline timeline;
	FruitController fruitController;
	List<Fruit> fruit;
	public static Player player;
	Text textScore;
	KeyFrame keyFrame;
	public static double duration = 100;
	public static boolean change = false;

	public GamePane(String playerName) {
		Main.scene.getStylesheets().remove(0);
		Main.scene.getStylesheets().add("app/scenes/gamePane.css");
		player = new Player(playerName);
		initTextScore();
		snake = new Snake();
		fruitController = new FruitController();
		fruit = new ArrayList<>();
		fruit.add(fruitController.getElementFromList());
		initTimeline();
		this.getChildren().add(textScore);

	}

	private void initTextScore() {
		textScore = new Text(Integer.toString(player.getScore()));
		textScore.setWrappingWidth(Main.WIDTH);
		textScore.setTextAlignment(TextAlignment.CENTER);
		GamePane.positionInArea(textScore, 0, 0, (double) Main.WIDTH, (double) Main.HEIGHT, Main.WIDTH,
				new Insets(0, 0, 0, 0), HPos.CENTER, VPos.CENTER, false);
	}

	private void initTimeline() {
		timeline = new Timeline(keyFrame = new KeyFrame(Duration.millis(duration), event -> action()));
		timeline.setCycleCount(Animation.INDEFINITE);
		timeline.play();

	}

	private void action() {
		if (!snake.failByEaten()) {
			addFruitOnScene();
			handleFruitEating();
			animateSnake();

		} else {
			timeline.stop();
			savePointsToFile();
			initGameOverPane();

		}
	}


	private void savePointsToFile() {
		HighScoresFile.highScoresFile.setScore(player.getScore());
		HighScoresFile.highScoresFile.setPlayerName(player.getName());
		
	}

	private void initGameOverPane() {
		try {
			Main.scene.setRoot(new GameOverPane());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	private void animateSnake() {
		SnakeController.getController().control(snake);
		snake.move();
		this.getChildren().addAll(snake.getWholeSnake());
		
	}

	private void handleFruitEating() {
		if (fruit.get(0).ifcontains(snake.getCoordX(), snake.getCoordY(), snake.getWidth(), snake.getHeight())) {
			snake.extend();

			fruit.get(0).makeDifference();
			setNewFruit();
			player.setScore(player.getScore() + 1);
			textScore.setText(Integer.toString(player.getScore()));
			makeGameFaster();
			if(change == true ) {
				changeBackground();
			}
		}
		
	}

	private void addFruitOnScene() {
		this.getChildren().removeAll(snake.getWholeSnake());
		if (!fruit.get(0).isOnScene()) {
			this.getChildren().addAll(fruit);
			fruit.get(0).setOnScene(true);
		}
		
	}
	
	private void makeGameFaster() {
		timeline.stop();
		duration=duration-2;
		initTimeline();
		
	}

	private void setNewFruit() {
		this.getChildren().removeAll(fruit);
		fruit.get(0).setScaleY(0);
		fruit.get(0).setScaleX(0);
		fruitController = new FruitController();
		this.getChildren().add(fruit.set(0,fruitController.getElementFromList() ));
	}
	private void changeBackground() {
		this.setBackground(Background.EMPTY);
		  String style = "-fx-background-color: rgba("+new Random().nextInt(256)+", "+new Random().nextInt(256)+", "+new Random().nextInt(256)+", 1);";
		  this.setStyle(style);
		  change = false;
	}


}

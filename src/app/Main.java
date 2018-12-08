package app;

import app.scenes.MenuPane;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class Main extends Application {
	public static Scene scene;
	public static final int WIDTH = 800;
	public static final int HEIGHT = 640;

	@Override
	public void start(Stage primaryStage) {

		scene = new Scene(new Pane(), WIDTH, HEIGHT);
		scene.getStylesheets().add("app/application.css");
		MenuPane menuPane = new MenuPane();
		scene.setRoot(menuPane);
		primaryStage.setTitle("Snake");
		primaryStage.centerOnScreen();
		primaryStage.setResizable(false);
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}

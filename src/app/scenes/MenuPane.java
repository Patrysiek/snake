package app.scenes;


import app.Main;
import app.buttons.ExecuteStrategyButton;
import app.buttons.ExitButton;
import app.buttons.HighScoresButton;
import app.buttons.NewGameButton;
import javafx.geometry.Insets;
import javafx.scene.layout.VBox;

public class MenuPane extends VBox {

	ExecuteStrategyButton newGameButton, highScoresButton,exitGameButton;
	public MenuPane() {
		initNewGameButton();
		initHighScoresButton();
		initExitButton(); 
		Main.scene.getStylesheets().remove(0);
		Main.scene.getStylesheets().add("app/scenes/menuPane.css");
		this.setSpacing(10);
		this.setPadding(new Insets(0, 20, 10, 20));
		this.getChildren().addAll(newGameButton, highScoresButton,exitGameButton);
		setCache(true);
	}
	private void initNewGameButton() {
		newGameButton = new ExecuteStrategyButton.ButtonBuilder(new NewGameButton())
				.coordX(Main.WIDTH/2-200)
				.coordY(Main.HEIGHT/2-200)
				.name("Nowa Gra")
				.build();
		
	}
	private void initHighScoresButton() {
		highScoresButton = new ExecuteStrategyButton.ButtonBuilder(new HighScoresButton())
				.coordX(Main.WIDTH/2-200)
				.coordY(Main.HEIGHT/2-200)
				.name("Najlepsze wyniki")
				.build();
		
	}
	private void initExitButton() {
		exitGameButton = new ExecuteStrategyButton.ButtonBuilder(new ExitButton())
				.coordX(Main.WIDTH/2-200)
				.coordY(Main.HEIGHT/2-200)
				.name("Wyjscie")
				.build();
		
	}

}

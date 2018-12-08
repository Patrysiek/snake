package app.scenes;



import app.Main;
import app.buttons.ExecuteStrategyButton;
import app.buttons.GamePaneButton;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.VBox;

public class NamePane extends VBox{
	
	
	private static TextField textField;
	Label nameLabel;
	ExecuteStrategyButton button;
	public NamePane() {
		Main.scene.getStylesheets().remove(0);
		Main.scene.getStylesheets().add("app/scenes/namePane.css");
		 
		nameLabel = new Label("Wpisz swoje imie:");
		nameLabel.setMaxWidth(300);
		nameLabel.setTranslateX(Main.WIDTH/2-nameLabel.getMaxWidth()/4);
		textField = new TextField();
		textField.setMaxWidth(300);
		textField.setTranslateX(Main.WIDTH/2-textField.getMaxWidth()/2);
		initButton();
		this.getChildren().addAll(nameLabel,textField,button);
	}
	private void initButton() {
		button = new ExecuteStrategyButton.ButtonBuilder(new GamePaneButton())
				.name("GRAJ !")
				.width(50)
				.height(100)
				.coordX(Main.WIDTH/2)
				.build();
		
	}
	public static TextField getTextField() {
		return textField;
	}
	
	

}

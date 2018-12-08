package app.buttons;

import javafx.scene.control.Button;

//////////////////////////PRZYCISK WYWOLUJACY INNE PRZYCISKI//////////////////////
public class ExecuteStrategyButton extends Button {

	private IButtonStrategy strategy;

	public IButtonStrategy getStrategy() {
		return strategy;
	}

	private ExecuteStrategyButton(final ButtonBuilder builder) {
		this.strategy = builder.strategy;
		this.setText(builder.name);
		this.setTranslateX(builder.coordX);
		this.setTranslateY(builder.coordY);
		this.setMaxWidth(builder.width);
		this.setMaxHeight(builder.height);
		this.setOnMouseClicked(event -> executeStrategy());
	}

	public void executeStrategy() {
		strategy.doOperation();
	}

	///////////// STATYCZNA KLASA KTORA BUDUJE NAM PRZYCISK/////////////////
	public static class ButtonBuilder {
		private final IButtonStrategy strategy;
		private String name;
		private double coordY;
		private double coordX;
		private int height;
		private int width;

		public ButtonBuilder(IButtonStrategy strategy) {
			this.strategy = strategy;
		}

		public ButtonBuilder height(int height) {
			this.height = height;
			return this;
		}

		public ButtonBuilder width(int width) {
			this.width = width;
			return this;
		}

		public ButtonBuilder coordY(double coordY) {
			this.coordY = coordY;
			return this;
		}

		public ButtonBuilder coordX(double coordX) {
			this.coordX = coordX;
			return this;
		}

		public ButtonBuilder name(String name) {
			this.name = name;
			return this;
		}

		public ExecuteStrategyButton build() {
			return new ExecuteStrategyButton(this);
		}

	}
}

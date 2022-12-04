package application.utilities;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import de.jensd.fx.glyphs.materialicons.MaterialIconView;
import de.jensd.fx.glyphs.octicons.OctIconView;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class MeniuButtonsStyle {

	public void styleButtons(Button button, FontAwesomeIconView buttonIcon, Circle buttonCircle) {
		
		button.setOnMouseEntered(new EventHandler<Event>() {

			@Override
			public void handle(Event arg0) {
				button.setStyle("-fx-background-color: white; -fx-background-radius: 15px;"
						+ " -fx-border-radius: 15px; -fx-border-color: rgba(255,255,255,0.2);");
				button.setTextFill(Color.web("#5283E9"));
				buttonCircle.setFill(Color.web("#DDDDDD"));
				buttonIcon.setFill(Color.web("#5283E9"));
			}
		});
		button.setOnMouseExited(new EventHandler<Event>() {

			@Override
			public void handle(Event arg0) {
				button.setStyle("-fx-background-color: transparent; -fx-background-radius: 15px;"
						+ " -fx-border-radius: 15px; -fx-border-color: rgba(255,255,255,0.2);");
				button.setTextFill(Color.WHITE);
				buttonCircle.setFill(Color.web("#2E4EB8"));
				buttonIcon.setFill(Color.WHITE);
			}
		});
	}
	
public void styleButtons(Button button, OctIconView buttonIcon, Circle buttonCircle) {
		
	button.setOnMouseEntered(new EventHandler<Event>() {

		@Override
		public void handle(Event arg0) {
			button.setStyle("-fx-background-color: white; -fx-background-radius: 15px;"
					+ " -fx-border-radius: 15px; -fx-border-color: rgba(255,255,255,0.2);");
			button.setTextFill(Color.web("#5283E9"));
			buttonCircle.setFill(Color.web("#DDDDDD"));
			buttonIcon.setFill(Color.web("#5283E9"));
		}
	});
	button.setOnMouseExited(new EventHandler<Event>() {

		@Override
		public void handle(Event arg0) {
			button.setStyle("-fx-background-color: transparent; -fx-background-radius: 15px;"
					+ " -fx-border-radius: 15px; -fx-border-color: rgba(255,255,255,0.2);");
			button.setTextFill(Color.WHITE);
			buttonCircle.setFill(Color.web("#2E4EB8"));
			buttonIcon.setFill(Color.WHITE);
		}
	});
	}
	
	public void styleButtons(Button button, MaterialIconView buttonIcon, Circle buttonCircle) {
		button.setOnMouseEntered(new EventHandler<Event>() {

			@Override
			public void handle(Event arg0) {
				button.setStyle("-fx-background-color: white; -fx-background-radius: 15px;"
						+ " -fx-border-radius: 15px; -fx-border-color: rgba(255,255,255,0.2);");
				button.setTextFill(Color.web("#5283E9"));
				buttonCircle.setFill(Color.web("#DDDDDD"));
				buttonIcon.setFill(Color.web("#5283E9"));
			}
		});
		button.setOnMouseExited(new EventHandler<Event>() {

			@Override
			public void handle(Event arg0) {
				button.setStyle("-fx-background-color: transparent; -fx-background-radius: 15px;"
						+ " -fx-border-radius: 15px; -fx-border-color: rgba(255,255,255,0.2);");
				button.setTextFill(Color.WHITE);
				buttonCircle.setFill(Color.web("#2E4EB8"));
				buttonIcon.setFill(Color.WHITE);
			}
		});
	}

}

package dad.APP;

import java.io.IOException;

import dad.GUI.Controller;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class App extends Application {

	public static Stage primaryStage;
	private Controller control;

	@Override
	public void start(Stage primaryStage) throws Exception {
		control = new Controller();
		App.primaryStage = primaryStage;
		primaryStage.setTitle("Calendario");
		primaryStage.setScene(new Scene(control.getViewRoot()));
		primaryStage.getIcons().add(new Image("/images/calendar-64x64.png"));
		primaryStage.show();
	}

	public static void main(String[] args) throws IOException {

		launch(args);
	}
}

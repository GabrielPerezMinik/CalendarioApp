package dad.GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class Controller implements Initializable {


    @FXML
    private GridPane ViewRoot;

    @FXML
    private Label anosLabel;

    public Controller() throws IOException {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/BaseCalendario.fxml"));
			loader.setController(this);
			loader.load();
    
    }
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}

    @FXML
    void onAdelanteButton(ActionEvent event) {

    }

    @FXML
    void onAtrasButton(ActionEvent event) {

    }

	public GridPane getViewRoot() {
		return ViewRoot;
	}
    
}

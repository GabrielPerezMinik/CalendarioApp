package dad.GUI;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

import dad.calendario.Calendario;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class Controller implements Initializable {
		
		private IntegerProperty anio = new SimpleIntegerProperty();
		private ArrayList<Calendario> meses = new ArrayList<>();

	    @FXML
	    private Label anosLabel;
	    
	    @FXML
	    private GridPane calendarioGrid;

	    
	    @FXML
	    private BorderPane ViewRoot;
	    
	    public Controller() {
	    	try {
	    		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/BaseCalendario.fxml"));
	        	loader.setController(this);
				loader.load();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		@Override
		public void initialize(URL location, ResourceBundle resources) {
			for(int i = 0; i < 12; i++) {
				Calendario calendarioController = new Calendario();
				calendarioController.setMes(i+1);
				calendarioController.anioProperty().bind(anio);
				meses.add(calendarioController);
				calendarioGrid.add(calendarioController, i%4, i/4);
			}
			anosLabel.textProperty().bind(anio.asString());
			anio.set(LocalDate.now().getYear());
			
		}
		
		  @FXML
		    void onAdelanteButton(ActionEvent event) {

			  sumarAno(event);
			  
		    }

		    @FXML
		    void onAtrasButton(ActionEvent event) {

		    	restarAno(event);
		    }
		
		private void sumarAno(ActionEvent e) {
			anio.set(anio.get()+1);
		}

		private void restarAno(ActionEvent e) {
			anio.set(anio.get()-1);
		}
		
		

		public BorderPane getRoot() {
			return ViewRoot;
		}
		
}

package dad.calendario;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class Calendario extends GridPane implements Initializable {

		private IntegerProperty anio = new SimpleIntegerProperty();
		private IntegerProperty mes = new SimpleIntegerProperty();

		
		@FXML
		private Label domingoLabel;

		@FXML
		private Label juevesLabel;
		
	    @FXML
	    private Label lunesLabel;

	    @FXML
	    private Label martesLabel;

	    @FXML
	    private Label miercolesLabel;

	    @FXML
	    private Label sabadoLabel;

	    @FXML
	    private Label viernesLabel;
		
	    @FXML
	    private Label labelMes;

		public Calendario() {
			super();
			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Calendario.fxml"));
				loader.setRoot(this);
				loader.setController(this);
				loader.load();
			} catch (IOException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}

		@Override
		public void initialize(URL location, ResourceBundle resources) {
			
			anio.addListener((o,ov,nv)->cambiar(o,ov,nv));
			mes.addListener((o,ov,nv)->cambiar(o,ov,nv));
		}

		private void cambiar(ObservableValue<? extends Number> o, Number ov, Number nv) {
			int primerDia = GeneradorDeDias.conseguirPrimerDia(getAnio(), getMes()-1);
			int ultimoDia = GeneradorDeDias.conseguirUltimoDia(getAnio(), getMes()) ;				
			int fila = 2;
			
			getChildren().clear();
			
			
			lunesLabel.getStyleClass().add("weekday");
			
			
			martesLabel.getStyleClass().add("weekday");
			
			
			miercolesLabel.getStyleClass().add("weekday");
			
		
			juevesLabel.getStyleClass().add("weekday");
			
			
			viernesLabel.getStyleClass().add("weekday");
			
			
			sabadoLabel.getStyleClass().add("weekday");
			
			domingoLabel.getStyleClass().addAll("weekday","sunday");
			
			
			add(lunesLabel, 0, 1);
			add(martesLabel, 1, 1);
			add(miercolesLabel, 2, 1);
			add(juevesLabel, 3, 1);
			add(viernesLabel, 4, 1);
			add(sabadoLabel, 5, 1);
			add(domingoLabel, 6, 1);
			
			for(int i = 0, j = 1; i < ultimoDia; i++, j++, primerDia++) {

				int col = primerDia%7;
				if(col == 0) {
					fila++;
				}
				
				Label dia = new Label(j+"");
				dia.getStyleClass().add("day");
				
				if(col==6) {
					dia.getStyleClass().add("sunday");
				}
				
				if(LocalDate.of(anio.get(), mes.get(), j).equals(LocalDate.now())) {
					dia.getStyleClass().add("today");
				}
				
				add(dia, col, fila);
			}

			Date date = GeneradorDeDias.Fecha(getAnio(), getMes(), 1);
			labelMes.setText(new SimpleDateFormat("MMM").format(date));
			add(labelMes, 3, 0);
		}

		public final IntegerProperty anioProperty() {
			return this.anio;
		}
		

		public final int getAnio() {
			return this.anioProperty().get();
		}
		

		public final void setAnio(final int anio) {
			this.anioProperty().set(anio);
		}
		

		public final IntegerProperty mesProperty() {
			return this.mes;
		}
		

		public final int getMes() {
			return this.mesProperty().get();
		}
		

		public final void setMes(final int mes) {
			this.mesProperty().set(mes);
		}
		

	}

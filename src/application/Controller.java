package application;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;


// TODO: Auto-generated Javadoc
/**
 *  Clase controlador, esta clase implementa los métodos necesarios
 * para aplicar la lógica.
 *
 * @author Cristobal Revelles
 */
public class Controller implements Initializable {

	/** The pane 1. */
	@FXML
	private AnchorPane pane1;

	/** The pane 2. */
	@FXML
	private AnchorPane pane2;

	/** The pane 3. */
	@FXML
	private AnchorPane pane3;
	
	/** The pane 4. */
	@FXML
	private AnchorPane pane4;
	
	/** The pane 5. */
	@FXML
	private AnchorPane pane5;

	/** The count label. */
	@FXML
	private Label countLabel;
	
	/** The btn atras. */
	@FXML
	private JFXButton btnAtras;
	
	/** The btn adelante. */
	@FXML
	private JFXButton btnAdelante;
	
	/** The show slide. */
	int showSlide = 0;


	/**
	 * Translate animation.
	 *
	 * @param duration  - Duración que tarda en pasar de una ventana a otro
	 * @param node the node
	 * @param byX  - Coordenadas donde se posiciona
	 */
	public void translateAnimation(double duration, Node node, double byX) {
		TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(duration), node);
		translateTransition.setByX(byX);
		translateTransition.play();

	}

	
	/* (non-Javadoc)
	 * @see javafx.fxml.Initializable#initialize(java.net.URL, java.util.ResourceBundle)
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		translateAnimation(0.5, pane2, 600);
		translateAnimation(0.5, pane3, 600);
		translateAnimation(0.5, pane4, 600);
		translateAnimation(0.5, pane5, 600);
		btnAtras.setVisible(false);
		
	}

	

	
	/**
	 * metodo para pasar a la siguiente ventana.
	 *
	 * @param event -  recibe el evento que es el click
	 */
	@FXML
	void nextAction(ActionEvent event) {

		if (showSlide == 0) {
			translateAnimation(0.5, pane2, -600);
			showSlide++; // showSlide=1
			countLabel.setText("2/5");
		} else if (showSlide == 1) {
			translateAnimation(0.5, pane3, -600);
			showSlide++; // showSlide=2
			countLabel.setText("3/5");
		} else if (showSlide == 2) {
			translateAnimation(0.5, pane4, -600);
			showSlide++; // showSlide=3
			countLabel.setText("4/5");
		} else if (showSlide == 3) {
			translateAnimation(0.5, pane5, -600);
			showSlide++; // showSlide=4
			countLabel.setText("5/5");
		} 
	}

	
	/**
	 * Back action - Vuelve atrás
	 *
	 * @param event the event
	 */
	@FXML
	void backAction(ActionEvent event) {

		if (showSlide == 0) {
			System.out.println("No more slide");
		} else if (showSlide == 1) {
			translateAnimation(0.5, pane2, 600);
			showSlide--; // showSlide=0
			countLabel.setText("1/5");
		} else if (showSlide == 2) {
			translateAnimation(0.5, pane3, 600);
			showSlide--; // showSlide=1
			countLabel.setText("2/5");
		}  else if (showSlide == 3) {
			translateAnimation(0.5, pane4, 600);
			showSlide--; // showSlide=1
			countLabel.setText("3/5");
		} else if (showSlide == 4) {
			translateAnimation(0.5, pane5, 600);
			showSlide--; // showSlide=1
			countLabel.setText("4/5");
		}

	}
	
	/**
	 * Handle close --> cierra la APP
	 */
	@FXML

	private void handleClose() {
			Platform.exit();
	}

}

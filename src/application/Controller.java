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

public class Controller implements Initializable {

	@FXML
	private AnchorPane pane1;

	@FXML
	private AnchorPane pane2;

	@FXML
	private AnchorPane pane3;
	
	@FXML
	private AnchorPane pane4;
	
	@FXML
	private AnchorPane pane5;

	@FXML
	private Label countLabel;
	
	@FXML
	private JFXButton btnAtras;
	
	@FXML
	private JFXButton btnAdelante;
	


	public void translateAnimation(double duration, Node node, double byX) {

		TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(duration), node);
		translateTransition.setByX(byX);
		translateTransition.play();

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		translateAnimation(0.5, pane2, 600);
		translateAnimation(0.5, pane3, 600);
		translateAnimation(0.5, pane4, 600);
		translateAnimation(0.5, pane5, 600);
		btnAtras.setVisible(false);
		
	}

	int showSlide = 0;

	
	/**
	 * Este método recibe el evento del click. Al pulsar
	 * nos llevará a la siguiente ventana
	 * @param event 
	 * 
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
	 * @param event
	 * * El método backAction sirve para avanzar en la APP
	 * Recibe un parámetro que será el evento del click
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
	@FXML
	/**
	 * Método cierra la APP
	 */
	private void handleClose() {
			Platform.exit();
	}

}

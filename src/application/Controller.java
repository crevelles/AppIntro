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
		btnAtras.setVisible(false);
	}

	int showSlide = 0;

	@FXML
	void nextAction(ActionEvent event) {

		if (showSlide == 0) {
			btnAtras.setVisible(true);
			translateAnimation(0.5, pane2, -600);
			showSlide++; // showSlide=1
			countLabel.setText("2/3");
		} else if (showSlide == 1) {
			
			translateAnimation(0.5, pane3, -600);
			showSlide++; // showSlide=2
			countLabel.setText("3/3");
			btnAdelante.setVisible(false);
		} else {
			System.out.println("No more slides");
		}

	}

	@FXML
	void backAction(ActionEvent event) {

		if (showSlide == 0) {
			System.out.println("No more slide");
		} else if (showSlide == 1) {
			translateAnimation(0.5, pane2, 600);
			showSlide--; // showSlide=0
			countLabel.setText("1/3");
			btnAdelante.setVisible(true);
			btnAtras.setVisible(false);
		} else if (showSlide == 2) {
			translateAnimation(0.5, pane3, 600);
			showSlide--; // showSlide=1
			countLabel.setText("2/3");
			btnAdelante.setVisible(true);
		}

	}
	
	@FXML
	private void handleClose() {
			Platform.exit();
	}

}

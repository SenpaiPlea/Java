package application.controller;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import application.Main;


/*
 * Starts a new game
 * 
 * Switches scenes to the game screen
 * 
 * Opens the history view
 */
public class MainMenuController extends BaseController {

	
	private Main mainApp;
	
	public void setMainApp(Main main) {
		this.mainApp = main;
	}
	
	
	
	@FXML private Button startButton;
	@FXML private Button historyButton;
	@FXML private Button exitButton;
	
	@FXML private TextField player1NameField;
	@FXML private TextField player2NameField;

	private boolean vsComputer = false;
	
	
	@FXML
	public void initialize() {
		System.out.println("Main Menu loaded!");
		
		javafx.application.Platform.runLater(() -> exitButton.requestFocus());
	}
	

	@FXML private void onStartTwoPlayerClick() {
	    String p1 = player1NameField.getText().isEmpty() ? "Player 1" : player1NameField.getText();
	    String p2 = player2NameField.getText().isEmpty() ? "Player 2" : player2NameField.getText();
	    mainApp.showGame(p1, p2, false);  // false = not computer
	}

	@FXML private void onStartVsComputerClick() {
	    String p1 = player1NameField.getText().isEmpty() ? "Player 1" : player1NameField.getText();
	    mainApp.showGame(p1, "Computer", true); // true = computer player
	}

	
	
	@FXML private void onHistoryButtonClick() {
		System.out.println("History clicked");
		mainApp.showHistory();
	}
	
	
	@FXML private void onExitButtonClick() {
		System.exit(0);
	}
	
	
	
	
	
	
}

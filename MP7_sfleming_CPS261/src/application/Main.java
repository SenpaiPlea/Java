package application;
	
import java.io.IOException;

import application.controller.BaseController;
import application.controller.GameController;
import application.controller.HistoryController;
import application.controller.MainMenuController;
import application.model.Dice;
import application.model.Game;
import application.view.GameView;
import application.view.HistoryView;
import application.view.MainMenuView;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


/**
 * launching the application
 * initializing the root scene
 * switching between screens (Menus/Game/History)
 * Keep the Scene object reused (switch only root)
 */
public class Main extends Application {
	
	private Stage primaryStage;
	private Scene scene;
	
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		
		try {
			FXMLLoader loader = new FXMLLoader(
				    getClass().getResource("/application/resources/MainMenuView.fxml")
				);
			Parent root = loader.load();
			
			
			BaseController controller =loader.getController();
			controller.setMainApp(this);
			
			
			this.scene = new Scene(root, 640, 480);
			primaryStage.setTitle("Game of Pig");
			primaryStage.setScene(scene);
			primaryStage.show();
			
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	private void switchView(String fxmlPath) {
	    try {
	        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
	        Parent root = loader.load();

	        
	        BaseController controller = loader.getController();
	        controller.setMainApp(this);

	        
	        scene.setRoot(root);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}

	
	
	
	public void showMenu() {
	    switchView("/application/resources/MainMenuView.fxml");
	}

	public void showGame(String player1Name, String player2Name, boolean isPlayer2Computer) {
	    try {
	        FXMLLoader loader = new FXMLLoader(getClass().getResource("resources/GameView.fxml"));
	        Parent root = loader.load();

	        GameController controller = loader.getController();
	        Game game = new Game(player1Name, player2Name, isPlayer2Computer);
	        controller.setGame(game);
	        controller.setMainApp(this);

	        scene.setRoot(root);
	        primaryStage.show();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}


	public void showHistory() {
	    switchView("/application/resources/HistoryView.fxml");
	}

	
	
	
	public static void main(String[] args) {
		launch(args);
		

		
		
		
	}
}

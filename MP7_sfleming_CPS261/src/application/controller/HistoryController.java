package application.controller;

import java.util.List;

import application.Main;
import application.model.HistoryManager;
import application.model.HistoryManager.MatchRecord;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;


/*
 * HistoryController handles the UI for viewing match history.
 * 
 * Responsibilities:
 * - Display match records in a TableView
 * - Sort records by columns (Game Result, Date, Total Points, Player)
 * - Display total wins for each player
 * - Navigate back to main menu
 */

public class HistoryController extends BaseController {

	private Main mainApp;
	
	public void setMainApp(Main main) {
		this.mainApp = main;
	}
	
	
    @FXML private TableView<MatchRecord> historyTable;
    @FXML private TableColumn<MatchRecord, String> winnerColumn;
    @FXML private TableColumn<MatchRecord, String> dateColumn;
    @FXML private TableColumn<MatchRecord, Integer> player1ScoreColumn;
    @FXML private TableColumn<MatchRecord, Integer> player2ScoreColumn;
    @FXML private TableColumn<MatchRecord, String> player1Column;
    @FXML private TableColumn<MatchRecord, String> player2Column;

    @FXML private Button backButton;
    @FXML private Label player1WinsLabel;
    @FXML private Label player2WinsLabel;
    @FXML private javafx.scene.control.ListView<String> winsListView;



	
	
    @FXML
    public void initialize() {
        // Bind columns to MatchRecord fields
        winnerColumn.setCellValueFactory(new PropertyValueFactory<>("winner"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("dateTime"));
        player1ScoreColumn.setCellValueFactory(new PropertyValueFactory<>("player1Score"));
        player2ScoreColumn.setCellValueFactory(new PropertyValueFactory<>("player2Score"));
        player1Column.setCellValueFactory(new PropertyValueFactory<>("player1"));
        player2Column.setCellValueFactory(new PropertyValueFactory<>("player2"));

        loadHistory();
    }
    
    

    @FXML private void loadHistory() {
        List<HistoryManager.MatchRecord> records = HistoryManager.loadAllMatches();
        historyTable.setItems(FXCollections.observableArrayList(records));
        
        
        updateTotalWins();
    }
    
	
	@FXML private void onMenuPressed() {
		System.out.println("Back to main menu from history");
		mainApp.showMenu();
	}

	

	/*
	 * Updates the total wins labels dynamically based on the current player names.
	 * Uses Java Streams to count how many times each player appears as a winner in the history.
	 */
	private void updateTotalWins() {
	    List<HistoryManager.MatchRecord> matches = HistoryManager.loadAllMatches();

	    // Get all unique player names
	    var allPlayers = matches.stream()
	                            .flatMap(m -> java.util.stream.Stream.of(m.getPlayer1(), m.getPlayer2()))
	                            .distinct()
	                            .toList();

	    // Clear old labels
	    winsListView.getItems().clear();

	    // Add each player's win count
	    for (String player : allPlayers) {
	        long wins = matches.stream()
	                           .filter(m -> m.getWinner().equals(player))
	                           .count();
	        winsListView.getItems().add(player + " has " + wins + " wins.");
	    }
	}



	
	
	
	
	
}

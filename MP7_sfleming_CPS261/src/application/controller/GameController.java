package application.controller;



import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import application.Main;
import application.controller.BaseController;
import application.model.Dice;
import application.model.Game;
import application.model.HistoryManager;
import application.model.Player;

/*
 * GameController handles the UI interaction for the Game.
 * 
 * Responsibilities:
 * - Listens for Roll, Hold, New Game, and Menu button presses
 * - Updates Game model
 * - Updates UI to reflect scores, current player, and dice roll results
 */

public class GameController extends BaseController {

    private Main mainApp;
    private Game game;
    private Dice dice;
    private boolean uiReady = false;

    @FXML private Label resultLabel;
    @FXML private Label player1ScoreLabel;
    @FXML private Label player2ScoreLabel;
    @FXML private Label roundScoreLabel;
    @FXML private Label currentPlayerLabel;

    @FXML private Button newGame;
    @FXML private Button hold;
    @FXML private Button rollButton;

    @FXML private ImageView diceImageView;

    public void setMainApp(Main main) { this.mainApp = main; }

    public void setGame(Game game) {
        this.game = game;
        this.dice = game.getDice();
        if (uiReady) updateUI();
    }

    @FXML
    @Override
    public void initialize() {
        player1ScoreLabel.setText("0");
        player2ScoreLabel.setText("0");
        roundScoreLabel.setText("Round: 0");
        currentPlayerLabel.setText("Current Player: -");
        uiReady = true;
    }

    // Updates UI and enables/disables buttons based on turn
    private void updateUI() {
        if (game == null) return;

        player1ScoreLabel.setText(game.getPlayer1().getName() + ": " + game.getPlayer1().getTotalScore());
        player2ScoreLabel.setText(game.getPlayer2().getName() + ": " + game.getPlayer2().getTotalScore());
        roundScoreLabel.setText("Round: " + game.getCurrentPlayer().getRoundScore());
        currentPlayerLabel.setText("Current Player: " + game.getCurrentPlayer().getName());

        boolean isHumanTurn = !game.getCurrentPlayer().isComputer();
        rollButton.setDisable(!isHumanTurn);
        hold.setDisable(!isHumanTurn);
    }

    @FXML private void onRollPressed() {
        int rollResult = game.getDice().roll();
        diceImageView.setImage(getImageForRoll(rollResult));
        resultLabel.setText("Rolled a " + rollResult);
        game.processRoll(rollResult);
        updateUI();

        if (game.hasWinner()) {
            checkWin();
        } else if (game.getCurrentPlayer().isComputer()) {
            computerAction();
        }
    }

    @FXML private void onHoldPressed() {
        game.hold();
        updateUI();

        if (game.hasWinner()) {
            checkWin();
        } else if (game.getCurrentPlayer().isComputer()) {
            computerAction();
        }
    }

    @FXML private void onMenuPressed() {
        mainApp.showMenu();
    }

    // Checks for winner and saves match
    private void checkWin() {
        if (game.hasWinner()) {
            Player winner = (game.getPlayer1().getTotalScore() >= 100)
                            ? game.getPlayer1()
                            : game.getPlayer2();

            resultLabel.setText(winner.getName() + " wins!");

            rollButton.setDisable(true);
            hold.setDisable(true);

            if (winner == game.getPlayer1()) {
                player1ScoreLabel.setStyle("-fx-font-weight: bold; -fx-text-fill: green;");
            } else {
                player2ScoreLabel.setStyle("-fx-font-weight: bold; -fx-text-fill: green;");
            }

            // Save match to history
            HistoryManager.saveMatch(game);
        }
    }

    private void computerAction() {
        Player computer = game.getCurrentPlayer();
        while (computer.isComputer() && !game.hasWinner()) {
            int roll = game.getDice().roll();
            resultLabel.setText(computer.getName() + " rolled " + roll);
            game.processRoll(roll);
            updateUI();

            // If rolled 1, turn ends automatically
            if (roll == 1) break;

            // If roundScore >= threshold, hold and end turn
            if (computer.getRoundScore() >= 15) {
                game.hold();
                updateUI();
                break;
            }
        }

        if (game.hasWinner()) {
            checkWin();
        }
    }

    
    
    
    private Image getImageForRoll(int roll) {
        // Assuming dice images are in resources/images/dice1.png ... dice6.png
        return new Image(getClass().getResourceAsStream("/application/resources/images/d" + roll + ".png"));
    }
    
    
    
    

}

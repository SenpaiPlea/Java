package application.model;

/*
 * Game class represents a single game of dice between two players.
 * 
 * Attributes:
 * - player1, player2: the two players
 * - currentPlayer: the player whose turn it is
 * - dice: the Dice object for rolling
 * - WINNING_SCORE: score needed to win
 * 
 * Methods:
 * - processRoll(int): adds roll to current round or switches turn if 1 rolled
 * - hold(): adds round score to total score and switches turn
 * - switchTurn(): switches currentPlayer
 * - hasWinner(): checks if any player reached WINNING_SCORE
 * - getPlayerScore(int): returns total score for player 1 or 2
 */

public class Game {

    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Dice dice;

    private final int WINNING_SCORE = 100;

    public Game(String player1Name, String player2Name, boolean isPlayer2Computer) {
        this.player1 = new Player(player1Name);
        if (isPlayer2Computer) {
            this.player2 = new Player(player2Name, true); // new Player constructor with isComputer flag
        } else {
            this.player2 = new Player(player2Name);
        }
        this.currentPlayer = player1;
        this.dice = new Dice();
    }
    

    public Player getPlayer1() { return player1; }
    public Player getPlayer2() { return player2; }
    public Player getCurrentPlayer() { return currentPlayer; }
    public Dice getDice() { return dice; }

    public int getPlayerScore(int i) {
        if (i == 0) return player1.getTotalScore();
        if (i == 1) return player2.getTotalScore();
        return 0;
    }

    public void processRoll(int roll) {
        if (roll == 1) {
            currentPlayer.resetRoundScore();
            switchTurn();
        } else {
            currentPlayer.addToRoundScore(roll);
        }
    }

    public void hold() {
        currentPlayer.setTotalScore(currentPlayer.getTotalScore() + currentPlayer.getRoundScore());
        currentPlayer.resetRoundScore();
        switchTurn();
    }

    private void switchTurn() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    public boolean hasWinner() {
        return player1.getTotalScore() >= WINNING_SCORE || player2.getTotalScore() >= WINNING_SCORE;
    }
    
    
    
    /*
     * Simple AI: rolls until roundScore >= 15, then holds.
     * If it rolls a 1, roundScore resets and turn passes.
     */
    public void computerTurn() {
        if (!currentPlayer.isComputer()) return;

        while (currentPlayer.getRoundScore() < 15) {
            int roll = dice.roll();
            System.out.println(currentPlayer.getName() + " rolled " + roll);
            processRoll(roll);
            if (roll == 1) return; // turn ends automatically
        }
        hold(); // hold when round score >= 15
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}

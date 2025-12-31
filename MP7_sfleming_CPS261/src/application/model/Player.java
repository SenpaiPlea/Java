package application.model;

/*
 * Player class represents a player in the game.
 * 
 * Attributes:
 * - name: player's name
 * - totalScore: accumulated score for the game
 * - roundScore: points accumulated in the current turn
 * 
 * Methods:
 * - get/set totalScore
 * - get/set/add roundScore
 * - reset roundScore
 */

public class Player {

    private String name;
    private int totalScore = 0;
    private int roundScore = 0;

    public Player(String name) {
        this.name = name;
    }

    public String getName() { return name; }

    public int getTotalScore() { return totalScore; }
    public void setTotalScore(int totalScore) { this.totalScore = totalScore; }

    public int getRoundScore() { return roundScore; }
    public void setRoundScore(int roundScore) { this.roundScore = roundScore; }
    public void addToRoundScore(int points) { this.roundScore += points; }
    public void resetRoundScore() { this.roundScore = 0; }
    
    
    
    private boolean isComputer = false;

    public Player(String name, boolean isComputer) {
        this.name = name;
        this.isComputer = isComputer;
    }

    public boolean isComputer() {
        return isComputer;
    }

    
    
    
    
    
    
    
    
}

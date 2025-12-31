package application.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class HistoryRecord {
	
	
	/*
	 * Attributes: player, date/time, points, result.
	 * 
	 * Methods: load history from file, save record to file, sort records.
	 */	
	

	    private String result; // "Win" or "Lose"
	    private String dateTime; // formatted string of date/time
	    private int totalPoints;
	    private String playerName;

	    public HistoryRecord(String result, LocalDateTime dateTime, int totalPoints, String playerName) {
	        this.result = result;
	        this.dateTime = dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
	        this.totalPoints = totalPoints;
	        this.playerName = playerName;
	    }

	    // Getters
	    public String getResult() { return result; }
	    public String getDateTime() { return dateTime; }
	    public int getTotalPoints() { return totalPoints; }
	    public String getPlayerName() { return playerName; }
	}

	
	
	
	
}

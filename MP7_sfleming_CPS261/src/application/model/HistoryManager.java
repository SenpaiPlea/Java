package application.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/*
 * HistoryManager handles all data-related operations for match history.
 * 
 * Responsibilities:
 * - Save a completed match to a history file
 * - Load all match records from file
 * - Calculate total wins per player
 * - Provide data for display and analysis
 */
public class HistoryManager {

    private static final String HISTORY_FILE = "history.txt";
    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    // Observable list so TableView updates automatically
    private static final ObservableList<MatchRecord> matchHistory = FXCollections.observableArrayList();

    public static ObservableList<MatchRecord> getMatchHistory() {
        return matchHistory;
    }

    // Represents a single match record
    public static class MatchRecord {

        private final String player1;
        private final String player2;
        private final int player1Score;
        private final int player2Score;
        private final String winner;
        private final LocalDateTime dateTime;

        public MatchRecord(String player1, String player2, int player1Score, int player2Score, String winner, LocalDateTime dateTime) {
            this.player1 = player1;
            this.player2 = player2;
            this.player1Score = player1Score;
            this.player2Score = player2Score;
            this.winner = winner;
            this.dateTime = dateTime;
        }

        // Public getters for PropertyValueFactory
        public String getPlayer1() { return player1; }
        public String getPlayer2() { return player2; }
        public int getPlayer1Score() { return player1Score; }
        public int getPlayer2Score() { return player2Score; }
        public String getWinner() { return winner; }
        public LocalDateTime getDateTime() { return dateTime; }

        @Override
        public String toString() {
            return String.format("%s | Winner: %s | %s: %d | %s: %d",
                    dtf.format(dateTime), winner, player1, player1Score, player2, player2Score);
        }
    }

    // Save match to both observable list and history file
    public static void saveMatch(Game game) {
        String winnerName;
        if (game.getPlayer1().getTotalScore() >= 100) {
            winnerName = game.getPlayer1().getName();
        } else if (game.getPlayer2().getTotalScore() >= 100) {
            winnerName = game.getPlayer2().getName();
        } else {
            winnerName = "No Winner";
        }

        MatchRecord record = new MatchRecord(
                game.getPlayer1().getName(),
                game.getPlayer2().getName(),
                game.getPlayer1().getTotalScore(),
                game.getPlayer2().getTotalScore(),
                winnerName,
                LocalDateTime.now()
        );

        // Add to observable list
        matchHistory.add(record);

        // Build CSV line for saving
        String recordLine = String.format("%s,%s,%d,%s,%d,%s%n",
                dtf.format(record.getDateTime()),
                record.getPlayer1(),
                record.getPlayer1Score(),
                record.getPlayer2(),
                record.getPlayer2Score(),
                record.getWinner()
        );

        // Append to history file
        try (FileWriter writer = new FileWriter(HISTORY_FILE, true)) {
            writer.write(recordLine);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Load all matches from file into a list
    public static List<MatchRecord> loadAllMatches() {
        List<MatchRecord> matches = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(HISTORY_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 6) {
                    LocalDateTime dt = LocalDateTime.parse(parts[0], dtf);
                    String player1 = parts[1];
                    int player1Score = Integer.parseInt(parts[2]);
                    String player2 = parts[3];
                    int player2Score = Integer.parseInt(parts[4]);
                    String winner = parts[5];
                    matches.add(new MatchRecord(player1, player2, player1Score, player2Score, winner, dt));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Update observable list so TableView can bind to it
        matchHistory.setAll(matches);

        return matches;
    }

    // Get total wins per player using streams
    public static long getTotalWins(String playerName) {
        return matchHistory.stream()
                .filter(m -> m.getWinner().equals(playerName))
                .count();
    }
}

package hockeyStats;

import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.Label;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MainController {

    @FXML
    private VBox chartBox;

    private List<String[]> data;
    private int maxGoals;

    @FXML
    public void initialize() {
        data = readData("/mp3_hockey_stats.txt");
        if (data != null) {
            maxGoals = data.stream().mapToInt(a -> Integer.parseInt(a[1])).max().orElse(1);
            buildChart();
        }
    }

    private List<String[]> readData(String resourcePath) {
        List<String[]> data = new ArrayList<>();
        try (InputStream input = getClass().getResourceAsStream(resourcePath);
             BufferedReader reader = new BufferedReader(new InputStreamReader(input))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    data.add(parts);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return data;
    }

    private void buildChart() {
        chartBox.getChildren().clear();

        for (String[] entry : data) {
            String team = entry[0];
            int goals = Integer.parseInt(entry[1]);

            HBox row = new HBox(5);
            Label nameLabel = new Label(team);
            nameLabel.setPrefWidth(100);

            Rectangle bar = new Rectangle();
            bar.setHeight(20);
            bar.setFill(Color.BLUE);

            // Bind width proportionally
            bar.widthProperty().bind(chartBox.widthProperty().subtract(120).multiply((double) goals / maxGoals));

            row.getChildren().addAll(nameLabel, bar);
            chartBox.getChildren().add(row);
        }
    }
}

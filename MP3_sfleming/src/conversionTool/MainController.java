package conversionTool;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;

public class MainController {

    @FXML private RadioButton tempRadio;
    @FXML private RadioButton weightRadio;
    @FXML private RadioButton distanceRadio;
    @FXML private Label label1;
    @FXML private Label label2;
    @FXML private TextField field1;
    @FXML private TextField field2;
    @FXML private Label statusLabel;

    @FXML
    public void initialize() {
        // Group radio buttons
        ToggleGroup group = new ToggleGroup();
        tempRadio.setToggleGroup(group);
        weightRadio.setToggleGroup(group);
        distanceRadio.setToggleGroup(group);

        distanceRadio.setSelected(true);
        updateLabels();

        // When a new conversion type is selected
        group.selectedToggleProperty().addListener((obs, old, val) -> updateLabels());

        // Handle Enter key in each field
        field1.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) convert(true);
        });
        field2.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) convert(false);
        });
    }

    private void updateLabels() {
        if (tempRadio.isSelected()) {
            label1.setText("Celsius");
            label2.setText("Fahrenheit");
        } else if (weightRadio.isSelected()) {
            label1.setText("Pounds");
            label2.setText("Kilograms");
        } else {
            label1.setText("Miles");
            label2.setText("Kilometers");
        }
        field1.clear();
        field2.clear();
        statusLabel.setText("");
    }

    private void convert(boolean fromFirst) {
        try {
            double input = Double.parseDouble(fromFirst ? field1.getText() : field2.getText());
            double result = 0;

            if (tempRadio.isSelected()) {
                result = fromFirst ? cToF(input) : fToC(input);
            } else if (weightRadio.isSelected()) {
                result = fromFirst ? poundsToKg(input) : kgToPounds(input);
            } else if (distanceRadio.isSelected()) {
                result = fromFirst ? milesToKm(input) : kmToMiles(input);
            }

            if (fromFirst) field2.setText(String.format("%.2f", result));
            else field1.setText(String.format("%.2f", result));

            statusLabel.setText("");

        } catch (NumberFormatException e) {
            statusLabel.setText("Enter a valid number.");
        }
    }

    // Conversion formulas
    private double cToF(double c) { return (c * 9 / 5) + 32; }
    private double fToC(double f) { return (f - 32) * 5 / 9; }

    private double poundsToKg(double lb) { return lb * 0.45359237; }
    private double kgToPounds(double kg) { return kg / 0.45359237; }

    private double milesToKm(double mi) { return mi * 1.609344; }
    private double kmToMiles(double km) { return km / 1.609344; }
}

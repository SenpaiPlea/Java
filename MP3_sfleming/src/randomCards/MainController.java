package randomCards;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.*;

public class MainController {

    @FXML
    private Button refreshButton;

    @FXML
    private ImageView card1, card2, card3, card4;

    private ImageView[] cards;
    private List<Integer> currentDeck; // IDs of dealt cards
    private final Image backImage = new Image(getClass().getResourceAsStream("/image/card/back.png"));

    @FXML
    public void initialize() {
        cards = new ImageView[]{card1, card2, card3, card4};
        setupCardClickHandlers();
        refreshButton.setOnAction(e -> dealCards());
        dealCards(); // Initial deal
    }

    private void setupCardClickHandlers() {
        for (int i = 0; i < cards.length; i++) {
            int index = i;
            cards[i].setOnMouseClicked(e -> revealCard(index));
        }
    }

    private void dealCards() {
        currentDeck = new ArrayList<>();
        Random rand = new Random();
        while (currentDeck.size() < 4) {
            int cardNumber = rand.nextInt(52) + 1; // 1 to 52
            if (!currentDeck.contains(cardNumber)) {
                currentDeck.add(cardNumber);
            }
        }

        // Set all to back image
        for (ImageView card : cards) {
            card.setImage(backImage);
        }
    }

    private void revealCard(int index) {
        int cardNumber = currentDeck.get(index);
        String path = "/image/card/" + cardNumber + ".png";
        Image img = new Image(getClass().getResourceAsStream(path));
        cards[index].setImage(img);
    }
}

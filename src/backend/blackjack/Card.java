package backend.blackjack;

import javax.swing.*;
import java.awt.*;

/**
 * This class represents a Card of black jack extending a JLabel
 */
public class Card extends JLabel {
    private String segno;
    private final int value;
    private final int number;
    private final int suit;

    /**
     * This constructor generates a card with suit and number
     */
    public Card() {
        super();
        number = (int) ((Math.random() * 13) + 1);
        suit = (int) ((Math.random() * 4) + 1);

        switch (suit){
            case 1 ->{
                segno = "cuori";
            }

            case 2 ->{
                segno = "quadri";
            }

            case 3 ->{
                segno = "fiori";
            }

            case 4 ->{
                segno = "picche";
            }
        }

        value = Math.min(number, 10);

        this.setSize(100, 120);
        this.setPreferredSize(new Dimension(120, 120));
        this.setBackground(Color.red);

        ImageIcon img = new ImageIcon(getClass().getClassLoader().getResource(segno+"/"+number+".png"));
        Image image = img.getImage();
        Image imgScaled = image.getScaledInstance(100, 120, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScaled);
        this.setIcon(scaledIcon);
    }

    /**
     * This method returns a value of card
     *
     * @return value of card
     */
    public int getValue() {
        return value;
    }

    /**
     * This returns a number of cards
     *
     * @return number of cards
     */
    public int getNumber() {
        return number;
    }

    /**
     * This returns a suit of card
     *
     * @return suit of card
     */
    public int getSuit() {
        return suit;
    }
}
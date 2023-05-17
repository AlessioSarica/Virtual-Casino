package backend.corsaCavalli;

import javax.swing.*;
import java.awt.*;

/**
 * This class represents a Horse extending JLabel
 */
public class Cavallo extends JLabel implements Runnable {
    private int speed;
    private int position;
    private final int reactionTime;
    private final ImageIcon[] icons = new ImageIcon[6];

    /**
     * This constructor prepares a Horse setting an image and position and another parameter
     */
    public Cavallo() {
        speed = (int) (Math.random() * 10) + 1;
        position = 10;
        reactionTime = (int) (Math.random() * 25) + 1;

        this.setSize(150, 120);
        this.setPreferredSize(new Dimension(120, 120));
        this.setBackground(Color.red);

        for (int i = 0; i < icons.length; i++) {
            int j = i + 1;
            ImageIcon img = new ImageIcon(getClass().getClassLoader().getResource("HorseAnimation/Horse"+ j + ".gif"));
            Image image = img.getImage();
            Image imgScaled = image.getScaledInstance(150, 120, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(imgScaled);
            icons[i] = scaledIcon;
        }
        this.setIcon(icons[0]);
        this.repaint();
        this.revalidate();
    }

    /**
     * This is a method for thread that execute clinically chance the image for simulating running to end
     */
    public void run() {
        int counter = 0;
        int imageCounter = 0;
        try {
            Thread.sleep(reactionTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while (position < 850) {
            if (counter == 3) {
                speed();
                counter = 0;
            }
            position += speed;
            this.setLocation(position, this.getY());
            this.setIcon(icons[imageCounter % 6]);
            this.repaint();
            this.revalidate();
            try {
                Thread.sleep(40);
                counter++;
                imageCounter++;
            } catch (Exception ignored) {
            }
        }
    }

    /**
     * This method generates a custom speed for horse
     */
    public void speed() {
        speed = (int) (Math.random() * 15) + 1;
    }
}


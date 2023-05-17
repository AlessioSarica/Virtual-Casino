package shopPage;

import backend.json.JsonEdit;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.util.Objects;

/**
 * This custom component manage Shop of fish
 */
public class Shop extends JPanel {
    private int isSelected = 0;
    public String[] userData;
    public JLabel saldo;
    private JPanel pacchetto1, pacchetto2, pacchetto3;

    /**
     * This constructor create a basic setting of this component and delegate style to init() method
     */
    public Shop() {
        setSize(1050, 800);
        setLocation(250, 0);
        setLayout(null);
        setBackground(Color.white);

        init();
    }

    /**
     * This method manages the style of internal components
     */
    private void init() {
        // Title
        JLabel titolo = new JLabel("Seleziona un pacchetto");
        titolo.setBounds(0, 10, 1050, 800);
        titolo.setFont(new Font("Arial", Font.PLAIN, 30));
        titolo.setHorizontalAlignment(JLabel.CENTER);
        titolo.setVerticalAlignment(JLabel.TOP);
        add(titolo);

        saldo = new JLabel("Saldo: ");
        saldo.setBounds(10, 700, 290, 50);
        saldo.setFont(new Font("Arial", Font.PLAIN, 20));
        saldo.setHorizontalAlignment(JLabel.LEFT);
        saldo.setForeground(Color.black);
        add(saldo);

        // Pacchetto 1
        pacchetto1 = new JPanel();
        pacchetto1.setBounds(20, 100, 290, 400);
        pacchetto1.setLayout(null);
        pacchetto1.setBackground(new Color(21, 25, 28));
        pacchetto1.addMouseListener(new MouseListener() {
            @Override
            public void mouseReleased(java.awt.event.MouseEvent e) {
            }

            @Override
            public void mousePressed(java.awt.event.MouseEvent e) {
                isSelected = 1;
                pacchetto1.setBackground(Color.gray);
                pacchetto2.setBackground(new Color(21, 25, 28));
                pacchetto3.setBackground(new Color(21, 25, 28));
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {

            }

            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {

            }

            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
            }
        });

        // Titolo pacchetto
        JLabel titoloPacchetto = new JLabel("Starter");
        titoloPacchetto.setBounds(30, 40, 290, 50);
        titoloPacchetto.setFont(new Font("Arial", Font.PLAIN, 20));
        titoloPacchetto.setHorizontalAlignment(JLabel.LEFT);
        titoloPacchetto.setVerticalAlignment(JLabel.TOP);
        titoloPacchetto.setForeground(Color.white);
        pacchetto1.add(titoloPacchetto);

        // Icon pacchetto
        JLabel iconPacchetto = new JLabel();
        iconPacchetto.setBounds(20, 50, 250, 250);
        try {
            Image img = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResource("starter.png"))).getScaledInstance(200, 200, Image.SCALE_SMOOTH);
            iconPacchetto.setIcon(new ImageIcon(img));
        } catch (Exception ignored) {
        }
        pacchetto1.add(iconPacchetto);

        // quantity
        JLabel quantity = new JLabel("30 Fish");
        quantity.setBounds(30, 300, 290, 50);
        quantity.setFont(new Font("Arial", Font.PLAIN, 20));
        quantity.setHorizontalAlignment(JLabel.LEFT);
        quantity.setVerticalAlignment(JLabel.TOP);
        quantity.setForeground(Color.white);
        pacchetto1.add(quantity);

        // Prezzo pacchetto
        JLabel prezzoPacchetto = new JLabel("€ 10.99");
        prezzoPacchetto.setBounds(30, 350, 290, 50);
        prezzoPacchetto.setFont(new Font("Arial", Font.PLAIN, 20));
        prezzoPacchetto.setHorizontalAlignment(JLabel.LEFT);
        prezzoPacchetto.setForeground(Color.white);
        pacchetto1.add(prezzoPacchetto);
        add(pacchetto1);

        // Pacchetto 2
        pacchetto2 = new JPanel();
        pacchetto2.setBounds(350, 100, 290, 400);
        pacchetto2.setLayout(null);
        pacchetto2.setBackground(new Color(21, 25, 28));
        pacchetto2.addMouseListener(new MouseListener() {
            @Override
            public void mouseReleased(java.awt.event.MouseEvent e) {
            }

            @Override
            public void mousePressed(java.awt.event.MouseEvent e) {
                isSelected = 2;
                pacchetto1.setBackground(new Color(21, 25, 28));
                pacchetto2.setBackground(Color.gray);
                pacchetto3.setBackground(new Color(21, 25, 28));
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {

            }

            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {

            }

            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
            }
        });

        // Titolo pacchetto
        JLabel titoloPacchetto2 = new JLabel("Pro");
        titoloPacchetto2.setBounds(30, 40, 290, 50);
        titoloPacchetto2.setFont(new Font("Arial", Font.PLAIN, 20));
        titoloPacchetto2.setHorizontalAlignment(JLabel.LEFT);
        titoloPacchetto2.setVerticalAlignment(JLabel.TOP);
        titoloPacchetto2.setForeground(Color.white);
        pacchetto2.add(titoloPacchetto2);

        // Icon pacchetto
        JLabel iconPacchetto2 = new JLabel();
        iconPacchetto2.setBounds(20, 50, 250, 250);
        try {
            Image img = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResource("pro.png"))).getScaledInstance(250, 250, Image.SCALE_SMOOTH);
            iconPacchetto2.setIcon(new ImageIcon(img));
        } catch (Exception ignored) {
        }
        pacchetto2.add(iconPacchetto2);

        // Quantity
        JLabel quantity2 = new JLabel("100 Fish");
        quantity2.setBounds(30, 300, 290, 50);
        quantity2.setFont(new Font("Arial", Font.PLAIN, 20));
        quantity2.setHorizontalAlignment(JLabel.LEFT);
        quantity2.setVerticalAlignment(JLabel.TOP);
        quantity2.setForeground(Color.white);
        pacchetto2.add(quantity2);

        // Prezzo pacchetto
        JLabel prezzoPacchetto2 = new JLabel("€ 29.99");
        prezzoPacchetto2.setBounds(30, 350, 290, 50);
        prezzoPacchetto2.setFont(new Font("Arial", Font.PLAIN, 20));
        prezzoPacchetto2.setHorizontalAlignment(JLabel.LEFT);
        prezzoPacchetto2.setForeground(Color.white);
        pacchetto2.add(prezzoPacchetto2);
        add(pacchetto2);

        // Pacchetto 3
        pacchetto3 = new JPanel();
        pacchetto3.setBounds(670, 100, 290, 400);
        pacchetto3.setLayout(null);
        pacchetto3.setBackground(new Color(21, 25, 28));
        pacchetto3.addMouseListener(new MouseListener() {
            @Override
            public void mouseReleased(java.awt.event.MouseEvent e) {
            }

            @Override
            public void mousePressed(java.awt.event.MouseEvent e) {
                isSelected = 3;
                pacchetto1.setBackground(new Color(21, 25, 28));
                pacchetto2.setBackground(new Color(21, 25, 28));
                pacchetto3.setBackground(Color.gray);
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
            }

            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {

            }

            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
            }
        });

        // Titolo pacchetto
        JLabel titoloPacchetto3 = new JLabel("Premium");
        titoloPacchetto3.setBounds(30, 40, 290, 50);
        titoloPacchetto3.setFont(new Font("Arial", Font.PLAIN, 20));
        titoloPacchetto3.setHorizontalAlignment(JLabel.LEFT);
        titoloPacchetto3.setVerticalAlignment(JLabel.TOP);
        titoloPacchetto3.setForeground(Color.white);
        pacchetto3.add(titoloPacchetto3);

        // Icon pacchetto
        JLabel iconPacchetto3 = new JLabel();
        iconPacchetto3.setBounds(20, 50, 250, 250);
        try {
            Image img = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResource("premium.png"))).getScaledInstance(200, 200, Image.SCALE_SMOOTH);
            iconPacchetto3.setIcon(new ImageIcon(img));
        } catch (Exception ignored) {
        }
        pacchetto3.add(iconPacchetto3);

        // Quantity
        JLabel quantity3 = new JLabel("300 Fish");
        quantity3.setBounds(30, 300, 290, 50);
        quantity3.setFont(new Font("Arial", Font.PLAIN, 20));
        quantity3.setHorizontalAlignment(JLabel.LEFT);
        quantity3.setVerticalAlignment(JLabel.TOP);
        quantity3.setForeground(Color.white);
        pacchetto3.add(quantity3);

        // Prezzo pacchetto
        JLabel prezzoPacchetto3 = new JLabel("€ 49.99");
        prezzoPacchetto3.setBounds(30, 350, 290, 50);
        prezzoPacchetto3.setFont(new Font("Arial", Font.PLAIN, 20));
        prezzoPacchetto3.setHorizontalAlignment(JLabel.LEFT);
        prezzoPacchetto3.setForeground(Color.white);
        pacchetto3.add(prezzoPacchetto3);
        add(pacchetto3);

        // Buy button
        JButton acquista = new JButton("Acquista");
        acquista.setBounds(350, 550, 290, 50);
        acquista.setFont(new Font("Arial", Font.PLAIN, 20));
        acquista.setBackground(new Color(21, 25, 28));
        acquista.setForeground(Color.white);
        acquista.setBorder(BorderFactory.createLineBorder(Color.white));
        acquista.addActionListener(e -> {
            double saldoAttuale = JsonEdit.readSaldo(userData[0], userData[1]);
            switch (isSelected) {
                case 1 -> {
                    JsonEdit.writeSaldo(userData[0], userData[1], saldoAttuale + Double.parseDouble(quantity.getText().split(" ")[0]));
                    saldo.setText("Saldo: " + JsonEdit.readSaldo(userData[0], userData[1]) + " Fish");
                }
                case 2 -> {
                    JsonEdit.writeSaldo(userData[0], userData[1], saldoAttuale + Double.parseDouble(quantity2.getText().split(" ")[0]));
                    saldo.setText("Saldo: " + JsonEdit.readSaldo(userData[0], userData[1]) + " Fish");
                }
                case 3 -> {
                    JsonEdit.writeSaldo(userData[0], userData[1], saldoAttuale + Double.parseDouble(quantity3.getText().split(" ")[0]));
                    saldo.setText("Saldo: " + JsonEdit.readSaldo(userData[0], userData[1]) + " Fish");
                }
            }
        });
        add(acquista);
    }
}
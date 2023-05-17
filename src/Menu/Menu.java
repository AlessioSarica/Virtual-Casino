package Menu;

import App.VirtualCasino;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.util.Objects;

/**
 * This custom component contains a menu section of app it connected to Virtual Casino
 */
public class Menu extends JPanel {
    private final VirtualCasino istanceApp;
    public JLabel user = new JLabel("");

    /**
     * This constructor create a basic setting of component and delegate style to method init()
     *
     * @param istanceApp is a reference to Virtual Casino file and used to manage another component
     */
    public Menu(VirtualCasino istanceApp) {
        this.istanceApp = istanceApp;
        setSize(250, 900);
        setLayout(null);
        setBackground(new Color(34, 40, 44));

        init();
    }

    /**
     * This method creates a style of internal component
     */
    public void init() {
        // App Logo
        JLabel logo = new JLabel();
        try {
            Image img = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResource("logo.png"))).getScaledInstance(200, 200, Image.SCALE_SMOOTH);
            logo.setIcon(new ImageIcon(img));
        } catch (Exception ignored) {
        }
        logo.setBounds(20, 20, 200, 200);
        add(logo);

        // User
        user.setBounds(20, 200, 200, 50);
        user.setForeground(Color.white);
        user.setFont(new Font("Arial", Font.PLAIN, 18));
        user.setHorizontalAlignment(JLabel.CENTER);
        add(user);

        // Slot machine button
        JButton slotMachine = new JButton("Slot Machine");
        try {
            Image img = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResource("slot-machine.png"))).getScaledInstance(40, 40, Image.SCALE_SMOOTH);
            slotMachine.setIcon(new ImageIcon(img));
        } catch (Exception ignored) {
        }

        slotMachine.setBounds(0, 320, 250, 50);
        slotMachine.setForeground(Color.white);
        slotMachine.setBorder(null);
        slotMachine.setBackground(new Color(21, 25, 28));
        slotMachine.setContentAreaFilled(false);
        slotMachine.setFocusPainted(false);
        slotMachine.setFont(new Font("Arial", Font.PLAIN, 18));
        slotMachine.setHorizontalAlignment(JLabel.LEFT);
        add(slotMachine);

        // Corsa cavalli button
        JButton corsaCavalli = new JButton("Corsa Cavalli");
        try {
            Image img = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResource("corsa-cavalli.png"))).getScaledInstance(40, 40, Image.SCALE_SMOOTH);
            corsaCavalli.setIcon(new ImageIcon(img));
        } catch (Exception ignored) {
        }

        corsaCavalli.setBounds(0, 380, 250, 50);
        corsaCavalli.setForeground(Color.white);
        corsaCavalli.setBorder(null);
        corsaCavalli.setBackground(new Color(21, 25, 28));
        corsaCavalli.setContentAreaFilled(false);
        corsaCavalli.setFocusPainted(false);
        corsaCavalli.setFont(new Font("Arial", Font.PLAIN, 18));
        corsaCavalli.setHorizontalAlignment(JLabel.LEFT);
        add(corsaCavalli);

        // Black Jack button
        JButton blackJack = new JButton("Black Jack");
        try {
            Image img = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResource("blackjack.png"))).getScaledInstance(40, 40, Image.SCALE_SMOOTH);
            blackJack.setIcon(new ImageIcon(img));
        } catch (Exception ignored) {
        }

        blackJack.setBounds(0, 440, 250, 50);
        blackJack.setForeground(Color.white);
        blackJack.setBorder(null);
        blackJack.setBackground(new Color(21, 25, 28));
        blackJack.setContentAreaFilled(false);
        blackJack.setFocusPainted(false);
        blackJack.setFont(new Font("Arial", Font.PLAIN, 18));
        blackJack.setHorizontalAlignment(JLabel.LEFT);
        add(blackJack);

        // Shop button
        JButton shop = new JButton("Shop");
        try {
            Image img = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResource("shop.png"))).getScaledInstance(40, 40, Image.SCALE_SMOOTH);
            shop.setIcon(new ImageIcon(img));
        } catch (Exception ignored) {
        }

        shop.setBounds(0, 260, 250, 50);
        shop.setForeground(Color.white);
        shop.setBorder(null);
        shop.setBackground(new Color(21, 25, 28));
        shop.setContentAreaFilled(false);
        shop.setFocusPainted(false);
        shop.setFont(new Font("Arial", Font.PLAIN, 18));
        shop.setHorizontalAlignment(JLabel.LEFT);
        shop.addActionListener(e -> {
            istanceApp.setShop();
            if (Objects.equals(istanceApp.getIsSelected(), "shop")) {
                shop.setContentAreaFilled(true);
                slotMachine.setContentAreaFilled(false);
                corsaCavalli.setContentAreaFilled(false);
                blackJack.setContentAreaFilled(false);
            }
        });
        add(shop);

        // Logout button
        JButton logout = new JButton("Logout");
        try {
            Image img = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResource("logout.png"))).getScaledInstance(40, 40, Image.SCALE_SMOOTH);
            logout.setIcon(new ImageIcon(img));
        } catch (Exception ignored) {
        }

        logout.setBounds(0, 500, 250, 50);
        logout.setForeground(Color.white);
        logout.setBorder(null);
        logout.setContentAreaFilled(false);
        logout.setFocusPainted(false);
        logout.setFont(new Font("Arial", Font.PLAIN, 18));
        logout.setHorizontalAlignment(JLabel.LEFT);
        add(logout);

        // Action listener
        blackJack.addActionListener(e -> {
            istanceApp.setBlackJack();
            if (Objects.equals(istanceApp.getIsSelected(), "blackJack")) {
                shop.setContentAreaFilled(false);
                slotMachine.setContentAreaFilled(false);
                corsaCavalli.setContentAreaFilled(false);
                blackJack.setContentAreaFilled(true);
            }
        });

        slotMachine.addActionListener(e -> {
            istanceApp.setSlotMachine();
            if (Objects.equals(istanceApp.getIsSelected(), "slotMachine")) {
                shop.setContentAreaFilled(false);
                slotMachine.setContentAreaFilled(true);
                corsaCavalli.setContentAreaFilled(false);
                blackJack.setContentAreaFilled(false);
            }
        });

        corsaCavalli.addActionListener(e -> {
            istanceApp.setCorsaCavalli();
            if (Objects.equals(istanceApp.getIsSelected(), "corsaCavalli")) {
                shop.setContentAreaFilled(false);
                slotMachine.setContentAreaFilled(false);
                corsaCavalli.setContentAreaFilled(true);
                blackJack.setContentAreaFilled(false);
            }
        });

        logout.addActionListener(e -> istanceApp.logout());
    }
}
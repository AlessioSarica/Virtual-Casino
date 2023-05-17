package auth;

import App.VirtualCasino;
import backend.auth.Autenticazione;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Objects;

/**
 * This custom component used to authenticate user with an email and password this is 1 part of Virtual Casino
 */
public class Access extends JPanel {
    private final VirtualCasino istanceApp;
    private String nomeVar, cognomeVar, emailVar, passwordVar, CVVVar, scadenzaVar, numeroCartaVar, intestatarioCartaVar;

    /**
     * This constructor create a base of component Es. with, height, Layout...
     *
     * @param istanceApp is a reference to Virtual Casino file
     */
    public Access(VirtualCasino istanceApp) {
        this.istanceApp = istanceApp;
        setSize(new Dimension(1300, 800));
        setBackground(Color.white);
        setLayout(null);
        init();
    }

    /**
     * This method setting a style of internal component
     */
    private void init() {
        // Setting background image
        JLabel Background = new JLabel("");
        try {
            Image img = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResource("bg-access.jpg"))).getScaledInstance(600, 600, Image.SCALE_SMOOTH);
            Background.setIcon(new ImageIcon(img));
        } catch (Exception ignored) {
        }
        Background.setBounds(0, 20, 600, 600);
        add(Background);

        // Data panel
        JPanel data = new JPanel();
        data.setBounds(640, 30, 500, 650);
        data.setBackground(new Color(34, 40, 44));
        data.setLayout(null);
        add(data);

        // Type of access
        JLabel textMode = new JLabel("Registrazione");
        textMode.setFont(new Font("Arial", Font.PLAIN, 21));
        textMode.setHorizontalAlignment(SwingConstants.LEFT);
        textMode.setForeground(Color.white);
        textMode.setBounds(90, 40, 280, 35);
        data.add(textMode);

        // Username
        JLabel nome = new JLabel("Nome");
        nome.setForeground(Color.white);
        nome.setBounds(90, 130, 100, 35);
        nome.setFont(new Font("Arial", Font.PLAIN, 15));
        data.add(nome);

        // Area username
        JTextField nomeArea = new JTextField("Es. Mario");
        nomeArea.setLocation(90, 170);
        nomeArea.setSize(300, 35);
        nomeArea.setBackground(new Color(34, 40, 44));
        nomeArea.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 0, Color.white));
        nomeArea.setForeground(Color.white);
        nomeArea.setFont(new Font("Arial", Font.PLAIN, 15));
        nomeArea.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
                if (nomeArea.getText().equals("Es. Mario") || nomeArea.getText().equals("Es. Mario Rossi")) {
                    nomeArea.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (nomeArea.getText().equals("")) {
                    if (textMode.getText().equals("Metodo di pagamento")) {
                        nomeArea.setText("Es. Mario Rossi");
                    } else {
                        nomeArea.setText("Es. Mario");
                    }
                }
            }
        });
        data.add(nomeArea);

        // Surname user
        JLabel cognome = new JLabel("Cognome");
        cognome.setForeground(Color.white);
        cognome.setBounds(90, 230, 100, 35);
        cognome.setFont(new Font("Arial", Font.PLAIN, 15));
        data.add(cognome);

        // Area Surname user
        JTextField cognomeArea = new JTextField("Es. Rossi");
        cognomeArea.setLocation(90, 270);
        cognomeArea.setSize(300, 35);
        cognomeArea.setBackground(new Color(34, 40, 44));
        cognomeArea.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 0, Color.white));
        cognomeArea.setForeground(Color.white);
        cognomeArea.setFont(new Font("Arial", Font.PLAIN, 15));
        cognomeArea.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
                if (cognomeArea.getText().equals("Es. Rossi") || cognomeArea.getText().equals("Es. 123456789")) {
                    cognomeArea.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (cognomeArea.getText().equals("")) {
                    if (textMode.getText().equals("Metodo di pagamento")) {
                        cognomeArea.setText("Es. 123456789");
                    } else {
                        cognomeArea.setText("Es. Rossi");
                    }
                }
            }
        });
        data.add(cognomeArea);

        // Email user
        JLabel email = new JLabel("Email");
        email.setForeground(Color.white);
        email.setBounds(90, 330, 100, 35);
        email.setFont(new Font("Arial", Font.PLAIN, 15));
        data.add(email);

        // Area email user
        JTextField emailArea = new JTextField("Es. mario.rossi@example.com");
        emailArea.setLocation(90, 370);
        emailArea.setSize(300, 35);
        emailArea.setBackground(new Color(34, 40, 44));
        emailArea.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 0, Color.white));
        emailArea.setForeground(Color.white);
        emailArea.setFont(new Font("Arial", Font.PLAIN, 15));
        emailArea.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
                if (emailArea.getText().equals("Es. mario.rossi@example.com") || emailArea.getText().equals("Es. 12/24")) {
                    emailArea.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (emailArea.getText().equals("")) {
                    if (textMode.getText().equals("Metodo di pagamento")) {
                        emailArea.setText("Es. 12/24");
                    } else {
                        emailArea.setText("Es. mario.rossi@example.com");
                    }
                }
            }
        });
        data.add(emailArea);

        // Password user
        JLabel password = new JLabel("Password");
        password.setForeground(Color.white);
        password.setBounds(90, 430, 100, 35);
        password.setFont(new Font("Arial", Font.PLAIN, 15));
        data.add(password);

        // Area password user
        JPasswordField passwordArea = new JPasswordField("123456");
        passwordArea.setLocation(90, 470);
        passwordArea.setSize(300, 35);
        passwordArea.setBackground(new Color(34, 40, 44));
        passwordArea.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 0, Color.white));
        passwordArea.setForeground(Color.white);
        passwordArea.setFont(new Font("Arial", Font.PLAIN, 15));
        passwordArea.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
                if (String.valueOf(passwordArea.getPassword()).equals("123456") || String.valueOf(passwordArea.getPassword()).equals("Es. 123")) {
                    passwordArea.setText("");
                    passwordArea.setEchoChar('*');
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (String.valueOf(passwordArea.getPassword()).equals("")) {
                    if (textMode.equals("Metodo di pagamento")) {
                        passwordArea.setText("Es. 123");
                    } else {
                        passwordArea.setText("123456");
                        passwordArea.setEchoChar((char) 0);
                    }
                }
            }
        });
        data.add(passwordArea);

        JButton access = new JButton("Registrati");
        // Button to switch mode
        JButton switchLogin = new JButton("Hai già un account? Accedi");
        switchLogin.setBounds(90, 580, 300, 35);
        switchLogin.setBackground(new Color(21, 25, 28));
        switchLogin.setForeground(Color.white);
        switchLogin.setFont(new Font("Arial", Font.PLAIN, 15));
        switchLogin.setFocusPainted(false);
        switchLogin.setBorder(null);
        switchLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (switchLogin.getText().equals("Non hai un account? Registrati")) {
                    textMode.setText("Registrazione");
                    access.setText("Registrati");
                    nome.setVisible(true);
                    nomeArea.setVisible(true);
                    cognome.setVisible(true);
                    cognomeArea.setVisible(true);
                    switchLogin.setText("Hai già un account? Accedi");
                } else {
                    textMode.setText("Accesso");
                    access.setText("Accedi");
                    nome.setVisible(false);
                    nomeArea.setVisible(false);
                    cognome.setVisible(false);
                    cognomeArea.setVisible(false);
                    switchLogin.setText("Non hai un account? Registrati");
                }
            }
        });
        data.add(switchLogin);

        // Button of access
        access.setBounds(90, 530, 300, 35);
        access.setBackground(new Color(21, 25, 28));
        access.setForeground(Color.white);
        access.setFont(new Font("Arial", Font.PLAIN, 15));
        access.setFocusPainted(false);
        access.setBorder(null);
        access.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (access.getText().equals("Registrati")) {
                    nomeVar = nomeArea.getText();
                    cognomeVar = cognomeArea.getText();
                    emailVar = emailArea.getText();
                    passwordVar = String.valueOf(passwordArea.getPassword());

                    textMode.setText("Metodo di pagamento");
                    nome.setText("Intestatario carta");
                    nomeArea.setText("Es. Mario Rossi");
                    cognome.setText("Numero carta");
                    cognomeArea.setText("Es. 123456789");
                    email.setText("Data di scadenza");
                    emailArea.setText("Es. 12/24");
                    password.setText("CVV");
                    passwordArea.setText("123");
                    access.setText("Aggiungi metodo");
                    switchLogin.setVisible(false);

                } else if (access.getText().equals("Aggiungi metodo")) {
                    intestatarioCartaVar = nomeArea.getText();
                    numeroCartaVar = cognomeArea.getText();
                    scadenzaVar = emailArea.getText();
                    CVVVar = String.valueOf(passwordArea.getPassword());

                    if (Autenticazione.register(nomeVar, cognomeVar, emailVar, passwordVar, intestatarioCartaVar, CVVVar, scadenzaVar, numeroCartaVar, 0)) {
                        istanceApp.setEmail(emailVar);
                        istanceApp.login();
                    } else {
                        JOptionPane.showMessageDialog(null, "Errore durante la registrazione o utente gia registrato", "Errore", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    if (Autenticazione.login(emailArea.getText(), String.valueOf(passwordArea.getPassword()))) {
                        istanceApp.setEmail(emailArea.getText());
                        istanceApp.login();
                    } else {
                        JOptionPane.showMessageDialog(null, "Email o password errata", "Errore", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        data.add(access);
    }
}
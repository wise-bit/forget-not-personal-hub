import javax.swing.*;
import java.awt.*;

/**
 * Author: Satrajit
 */

/*

Spare code:

new LineBorder(Color.BLACK,0)

 */

public class Dashboard extends Screen {

    Font nameFont = new Font("Ariel", Font.BOLD, 18);
    JTextField nameInputField = new JTextField("");

    JLabel welcomeText = new JLabel("Welcome, ", SwingConstants.RIGHT);

    JPanel content = new JPanel();

    public Dashboard() {

        super("Dashboard", 500, 500);

        welcomeText.setFont(nameFont);
        welcomeText.setBounds(150, 100, 100, 50);

        nameInputField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));
        nameInputField.setFont(nameFont);
        nameInputField.setBounds(250, 101, 100, 50);
        nameInputField.setColumns(15);

        // content.setBounds(250, 100, 100, 50);

        content.setLayout(null);

        content.add(welcomeText);
        content.add(nameInputField);

        this.getContentPane().add(content, BorderLayout.CENTER);

        otherFeatures();
        this.setVisible(true);

    }

    @Override
    public void otherFeatures() {

        this.getContentPane().setBackground(Color.WHITE);
        content.setBackground(Color.WHITE);

    }

}

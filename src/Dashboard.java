import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Author: Satrajit
 */

/*

Spare code:

new LineBorder(Color.BLACK,0)

 */

public class Dashboard extends Screen implements ActionListener {

    Font nameFont = new Font("Ariel", Font.BOLD, 18);
    JTextField nameInputField = new JTextField("");

    JLabel welcomeText = new JLabel("Welcome, ", SwingConstants.RIGHT);

    JPanel content = new JPanel();

    // JPanel graphic_line;

    // TODO: Figure out how to add paintComponent to JPanel

    public void paintComponent(Graphics g) {
        Color c = (Color.RED);
        g.setColor(c);
        g.fillRect(10, 10, 10, 10);
    }

    public Dashboard() {

        super("Dashboard", 500, 500);

        welcomeText.setFont(nameFont);
        welcomeText.setBounds(150, 100, 100, 50);

        nameInputField.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.BLACK));
        nameInputField.setFont(nameFont);
        nameInputField.setBounds(250, 100, 100, 50);
        nameInputField.setColumns(15);

        // graphic_line = new GPanel();
        // graphic_line.setVisible(true);

        // content.setBounds(250, 100, 100, 50);

        content.setLayout(null);

        content.add(welcomeText);
        content.add(nameInputField);
        // content.add(graphic_line);

        this.getContentPane().add(content, BorderLayout.CENTER);

        otherFeatures();
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        content.remove(graphic_line);
//        graphic_line = new GPanel();
//        graphic_line.setVisible(true);
//        content.add(graphic_line);
    }

    @Override
    public void otherFeatures() {

        this.getContentPane().setBackground(Color.WHITE);
        content.setBackground(Color.WHITE);

    }

//    class GPanel extends JPanel {
//        public GPanel() {
//            this.setPreferredSize(new Dimension(300, 300));
//        }
//
//        @Override
//        public void paintComponent(Graphics g) {
//            g.drawLine(250, 101, 260 + 10 * nameInputField.getText().length(), 101);
//        }
//
//    }

}

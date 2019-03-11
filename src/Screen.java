/**
 * Author: Satrajit
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public abstract class Screen extends JFrame {

    private String definedTitle;
    private int definedLength;
    private int definedWidth;

    public Screen(String title, int length, int width) {

        setDefinedTitle(title);
        setDefinedLength(length);
        setDefinedWidth(width);

        this.setLayout(new BorderLayout());

        setTitle(definedTitle);
        setSize(this.definedLength, this.definedWidth);

        // Removes title bar
        // setUndecorated(true);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        JLabel titleLabel = new JLabel(title, SwingConstants.CENTER);
        titleLabel.setBackground(Color.WHITE);
        titleLabel.setForeground(Color.BLACK);
        titleLabel.setFont(new Font("Ariel", Font.BOLD, 24));
        titleLabel.setVisible(true);
        this.add(titleLabel, BorderLayout.PAGE_START);

    }

    // Necessary Getters and Setters

    public String getDefinedTitle() {
        return definedTitle;
    }

    public void setDefinedTitle(String definedTitle) {
        this.definedTitle = definedTitle;
    }

    public int getDefinedLength() {
        return definedLength;
    }

    public void setDefinedLength(int definedLength) {
        this.definedLength = definedLength;
    }

    public int getDefinedWidth() {
        return definedWidth;
    }

    public void setDefinedWidth(int definedWidth) {
        this.definedWidth = definedWidth;
    }


    // This is for any other features specific to each of the screens
    public abstract void otherFeatures();

}

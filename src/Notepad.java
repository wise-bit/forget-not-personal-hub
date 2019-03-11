/**
 * Author: Satrajit
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Notepad extends Screen {

    public Notepad() throws IOException {

        super("Notepad", 500, 500);
        otherFeatures();

        // Class-specific instructions begin here

        File file = new File("Forget-not-content");
        file.createNewFile();

        JPanel textSpace = new JPanel();
        textSpace.setBackground(Color.WHITE);
        textSpace.setLayout(new BoxLayout(textSpace, BoxLayout.PAGE_AXIS));

        textSpace.add(Box.createRigidArea(new Dimension(5,10)));

        JTextArea writingSpace = new JTextArea();
        writingSpace.setEditable(true);

        JScrollPane space = new JScrollPane(writingSpace);

        space.setFont(new Font("Ariel", Font.PLAIN, 14));
        space.setBorder(BorderFactory.createMatteBorder(0, 4, 1, 4, Color.LIGHT_GRAY));

        textSpace.add(space);

        this.add(textSpace, BorderLayout.CENTER);

        BufferedReader in = new BufferedReader(new FileReader(file));
        String line = in.readLine();
        while(line != null){
            writingSpace.append(line + "\n");
            line = in.readLine();
        }
        in.close();

        ActionListener save = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                PrintWriter stream = null;
                try {
                    stream = new PrintWriter("Forget-not-content");
                    stream.write(writingSpace.getText());
                    stream.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };

        new Timer(1000, save).start();

        // Class information ends here

        this.setVisible(true);

    }

    @Override
    public void otherFeatures() {

        this.getContentPane().setBackground(Color.WHITE);

    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        File file = new File("Forget-not-content");
        file.createNewFile();

        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());

        frame.setTitle("Forget Not by wise-bit");

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        frame.setSize(500, 500);

        JLabel title = new JLabel("Jot Down Your Thoughts", SwingConstants.CENTER);
        title.setBackground(Color.WHITE);
        title.setForeground(Color.BLACK);
        title.setFont(new Font("Ariel", Font.BOLD, 24));
        title.setVisible(true);
        frame.add(title, BorderLayout.PAGE_START);

        JPanel textSpace = new JPanel();
        textSpace.setBackground(Color.WHITE);
        textSpace.setLayout(new BoxLayout(textSpace, BoxLayout.PAGE_AXIS));

        textSpace.add(Box.createRigidArea(new Dimension(5,10)));

        JTextArea writingSpace = new JTextArea();

        JScrollPane space = new JScrollPane(writingSpace);

        space.setFont(new Font("Ariel", Font.PLAIN, 14));
        space.setBorder(BorderFactory.createMatteBorder(0, 4, 1, 4, Color.LIGHT_GRAY));

        textSpace.add(space);

        frame.add(textSpace, BorderLayout.CENTER);

        BufferedReader in = new BufferedReader(new FileReader(file));
        String line = in.readLine();
        while(line != null){
            writingSpace.append(line + "\n");
            line = in.readLine();
        }
        in.close();

        frame.getContentPane().setBackground(Color.WHITE);

        frame.setVisible(true);

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

    }
}

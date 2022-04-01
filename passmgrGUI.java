import javax.swing.*; // JFrame is a class of the library swing
import java.awt.Font;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class passmgrGUI {
    public static void main(String[] args) {
        JFrame mainFrame = new JFrame("Lock256"); // init frame and set name of window

        JLabel welcomeLabel = new JLabel("Welcome to Lock256!");
        welcomeLabel.setBounds(10,10,400,20);
        welcomeLabel.setFont(new Font("Verdana", Font.PLAIN, 20));
        mainFrame.add(welcomeLabel);

        JLabel explanationLabel = new JLabel("Lock256 is an advanced password manager that features AES-256 encryption.");
        explanationLabel.setBounds(10,40,800,20);
        welcomeLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
        mainFrame.add(explanationLabel);

        JLabel copyrightLabel = new JLabel("© OmnipotentBlade 2022. All rights reserved.");
        copyrightLabel.setBounds(500,400,800,100);
        mainFrame.add(copyrightLabel);

        JLabel getStartedLabel = new JLabel("Get Started");
        getStartedLabel.setBounds(10,150,800,100);
        getStartedLabel.setFont(new Font("Verdana", Font.PLAIN, 22));
        mainFrame.add(getStartedLabel);


        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // allows the program to be closed just by clicking the "X" button at the top of the window
        mainFrame.setSize(800, 500); // set size of frame
        mainFrame.setLayout(null);
        mainFrame.setResizable(false); // disables resizing of window (ex: fullscreening)
        /* try {
            mainFrame.setIconImage(ImageIO.read(new File("/Users/ahmed/Downloads/index.png")));
        } catch (IOException e) {
            e.printStackTrace();
        } */
        mainFrame.setVisible(true);
    }
}

//TO-DO: 1) Create graphics for the program and implement them in labels using the icon constructor.
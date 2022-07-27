package src;

import src.FileMgmt;

import java.awt.Component;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class StartupFrame extends JFrame implements ActionListener {
    
    JButton createNewPassFileButton, creditsButton;
    JLabel welcomeLabel, explanationLabel, copyrightLabel, getStartedLabel, masterKeyPromptLabel, masterKeyExplanationLabel0, masterKeyExplanationLabel1, masterKeyExplanationLabel2, masterKeyEnterLabel, usernameLabel, passwordLabel;
    JPanel nPanel, sPanel, wPanel, ePanel, cPanel;
    JTextField masterUsernameTextField, masterUsernameConfTextField;
    JPasswordField masterPasswordField, masterConfPasswordField;
    static Component rigidConst0, rigidConst1, rigidConst2;

    StartupFrame() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {}

        welcomeLabel = new JLabel("Welcome to Lock256!");
        //welcomeLabel.setBounds(10,10,400,20);
        welcomeLabel.setFont(new Font("Verdana", Font.PLAIN, 20));

        explanationLabel = new JLabel("Lock256 is an advanced password manager that features AES-256 encryption.");
        //explanationLabel.setBounds(10,40,800,20);
        welcomeLabel.setFont(new Font("Verdana", Font.PLAIN, 18));

        copyrightLabel = new JLabel("© OmnipotentBlade 2022. All rights reserved.");
        copyrightLabel.setAlignmentX(RIGHT_ALIGNMENT);
        //copyrightLabel.setBounds(500,400,800,100);

        getStartedLabel = new JLabel("Get Started");
        //getStartedLabel.setBounds(10,130,800,100);
        getStartedLabel.setFont(new Font("Verdana", Font.PLAIN, 22));
        //getStartedLabel.setAlignmentX(CENTER_ALIGNMENT);

        createNewPassFileButton = new JButton("Create New Storage File");
        createNewPassFileButton.setMaximumSize(new Dimension(440,80));
        //createNewPassFileButton.setBounds(10,200,500,100);
        createNewPassFileButton.setFocusable(false);
        createNewPassFileButton.addActionListener(this);

        creditsButton = new JButton("Credits");
        creditsButton.setMaximumSize(new Dimension(380,40));
        creditsButton.setFocusable(false);
        creditsButton.addActionListener(this);

        masterKeyPromptLabel = new JLabel("Master Key Generation");
        masterKeyPromptLabel.setFont(new Font("Verdana", Font.PLAIN, 22));

        masterKeyExplanationLabel0 = new JLabel("Creating master credentials is crucial to the security of your Lock256 experience. The");
        masterKeyExplanationLabel1 = new JLabel("master credentials you choose will be required to be entered every time you access");
        masterKeyExplanationLabel2 = new JLabel("the program, and for any other administrative tasks within the program.");

        masterKeyEnterLabel = new JLabel("Please enter a new secure username and password.");
        masterKeyEnterLabel.setFont(new Font("Verdana", Font.PLAIN, 15));

        masterUsernameTextField = new JTextField("", 15);
        masterUsernameTextField.setMaximumSize(new Dimension(440,25));
        masterUsernameTextField.setAlignmentX(CENTER_ALIGNMENT);
        masterUsernameTextField.addActionListener(this);
        
        masterPasswordField = new JPasswordField("", 15);
        masterPasswordField.setMaximumSize(new Dimension(440,25));
        masterPasswordField.setActionCommand("OK");
        masterPasswordField.addActionListener(this);

        usernameLabel = new JLabel("Username:");
        passwordLabel = new JLabel("Password:");

        nPanel = new JPanel();
        nPanel.setPreferredSize(new Dimension(800,100));
        nPanel.setLayout(new BorderLayout());
        //nPanel.setPreferredSize(new Dimension(100,100));
        nPanel.add(welcomeLabel, BorderLayout.NORTH);
        nPanel.add(explanationLabel, BorderLayout.SOUTH);

        sPanel = new JPanel();
        sPanel.setLayout(new BoxLayout(sPanel, BoxLayout.PAGE_AXIS));
        sPanel.add(copyrightLabel);

        wPanel = new JPanel();
        wPanel.setPreferredSize(new Dimension(180,100));
        //wPanel.setBackground(Color.blue);
        
        ePanel = new JPanel();
        ePanel.setLayout(new BorderLayout());
        //ePanel.setLayout(new BoxLayout(ePanel, BoxLayout.PAGE_AXIS));
        ePanel.setPreferredSize(new Dimension(180,100));
        //ePanel.setBackground(Color.red);

        rigidConst0 = Box.createRigidArea(new Dimension(0,60));
        rigidConst1 = Box.createRigidArea(new Dimension(0,20));
        rigidConst2 = Box.createRigidArea(new Dimension(0,10));
        
        cPanel = new JPanel();
        cPanel.setLayout(new BoxLayout(cPanel, BoxLayout.PAGE_AXIS));
        cPanel.add(rigidConst0);
        cPanel.add(getStartedLabel);
        cPanel.add(rigidConst1);
        cPanel.add(createNewPassFileButton);
        cPanel.add(rigidConst2);
        cPanel.add(creditsButton);

        this.add(nPanel, BorderLayout.NORTH);
        this.add(sPanel, BorderLayout.SOUTH);
        this.add(wPanel, BorderLayout.WEST);
        this.add(ePanel, BorderLayout.EAST);
        this.add(cPanel, BorderLayout.CENTER);

        this.setTitle("Lock256 Setup");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // allows the program to be closed just by clicking the "X" button at the top of the window
        this.setSize(800, 500); // set size of frame
        //this.setLayout(new BorderLayout());
        this.setResizable(false); // disables resizing of window (ex: fullscreening)
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == createNewPassFileButton) {
            createNewPassFileButton.setEnabled(false);
            src.FileMgmt.createFile("passfile", FileMgmt.FILEPATH);
            JOptionPane.showMessageDialog(this, "Password database file created!\n(" + FileMgmt.FILEPATH + ")");

            // hide all components
            //nPanel.setVisible(false); sPanel.setVisible(false); wPanel.setVisible(false); ePanel.setVisible(false); cPanel.setVisible(false);
            cPanel.remove(createNewPassFileButton); cPanel.remove(getStartedLabel); cPanel.remove(creditsButton);
            cPanel.remove(rigidConst1); cPanel.remove(rigidConst2);
            cPanel.revalidate();
            cPanel.repaint(); // allows deleted components to be redrawn, allowing them to actually be physically removed
            cPanel.add(masterKeyPromptLabel);
            cPanel.add(Box.createRigidArea(new Dimension(0,20)));
            cPanel.add(masterKeyExplanationLabel0); cPanel.add(masterKeyExplanationLabel1); cPanel.add(masterKeyExplanationLabel2);
            cPanel.add(Box.createRigidArea(new Dimension(0,20)));
            cPanel.add(masterKeyEnterLabel);

            // Username + Password entry section
            cPanel.add(Box.createRigidArea(new Dimension(0,15)));
            cPanel.add(usernameLabel);
            cPanel.add(masterUsernameTextField);
            cPanel.add(Box.createRigidArea(new Dimension(0,5)));
            cPanel.add(passwordLabel);
            cPanel.add(masterPasswordField);

            masterPasswordField.setVisible(false);
            passwordLabel.setVisible(false);
            masterKeyPromptLabel.setVisible(true);
            masterKeyExplanationLabel0.setVisible(true); masterKeyExplanationLabel1.setVisible(true); masterKeyExplanationLabel2.setVisible(true);

            

            /*
            this.dispose(); // dispose of setup frame and only allow mainframe to be displayed
            try {
                TimeUnit.SECONDS.sleep(2); // commented for debugging above code
            } catch (Exception ex) {}
            src.passmgrGUI.main(null); // call main to check for passfile again and load mainframe
            */
        }
        else if (e.getSource() == creditsButton) {
            System.out.println("Credits button is being pressed! cb");
            
            if (System.getProperty("os.name").equals("Windows 10")) {
                JOptionPane.showMessageDialog(this, "Lock256\n\nLead Developer: Ahmed Osman\nProgram Logo: Hisham Osman\nProgram Name: Timothy Kane\n\n© OmnipotentBlade 2022.");
            } else if (System.getProperty("os.name").equals("Mac OS X")) {
                JOptionPane.showMessageDialog(this, "\nLock256\n\nLead Developer: Ahmed Osman\nProgram Logo: Hisham Osman\nProgram Name: Timothy Kane\n\n© OmnipotentBlade 2022.");
            } else {
                JOptionPane.showMessageDialog(this, "\nLock256\n\nLead Developer: Ahmed Osman\nProgram Logo: Hisham Osman\nProgram Name: Timothy Kane\n\n© OmnipotentBlade 2022.");
            }
        }
        else if (e.getSource() == masterUsernameTextField) {
            String usernameInput = masterUsernameTextField.getText();
            System.out.println(usernameInput);
            
            // enable password to be entered after username + disable usernametextfield
            masterUsernameTextField.setEnabled(false);
            masterPasswordField.setVisible(true);
            passwordLabel.setVisible(true);
        }
        else if (e.getSource() == masterPasswordField) {
            char[] passwordInput = masterPasswordField.getPassword();
            System.out.println(passwordInput);

            // hide initial password field and show confirm password field
            masterPasswordField.setVisible(false);
            passwordLabel.setText("Retype Password:");

        }
    }
}


// TO-DO: 1) Add button to toggle dark mode background (located in downloads folder as "startupframedark.png")
//        2) WIP || Add part after passfile creation to create master username and password, then encrypt the credentials
//        3) Handle username and password (mastercredentials)
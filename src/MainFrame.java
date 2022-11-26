import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class MainFrame extends JFrame implements ActionListener {

    SideBarPanel sideBarPanel;

    MainFrame(Boolean startup) { // startup = whether mainframe was called from startupframe or not
        if (startup) {
            // add code if it requires condition above
        }

        sideBarPanel = new SideBarPanel();
        sideBarPanel.setPreferredSize(new Dimension(219, 650));
        
        this.add(sideBarPanel, BorderLayout.WEST);

        this.setTitle("Lock256");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // allows the program to be closed just by clicking the "X" button at the top of the window
        this.setSize(1050, 650); // set size of frame
        this.setResizable(false); // disables resizing of window (ex: fullscreening)
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == "") {

        }
    }
}

package src;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.Dimension;
import java.awt.RenderingHints;
import java.awt.GradientPaint;
import java.awt.GridBagLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Insets;

public class SideBarPanel extends JPanel {
    
    JLabel usernameLabel, userIconLabel;
    ImageIcon userImageIcon, favoritesImageIcon, recentsImageIcon, passwordsImageIcon, generateImageIcon, loginsImageIcon, reportImageIcon, settingsImageIcon;
    GridBagConstraints gbc;

    SideBarPanel() {
        this.setLayout(new GridBagLayout());

        userImageIcon = new ImageIcon(FileMgmt.ICON_PERSONCIRCLE);
        favoritesImageIcon = new ImageIcon(FileMgmt.ICON_STAR);
        loginsImageIcon = new ImageIcon(FileMgmt.ICON_PERSONCIRCLE); // TODO: Change image to actual login image once it is included in src/images/icons
        recentsImageIcon = new ImageIcon(FileMgmt.ICON_HISTORY);
        passwordsImageIcon = new ImageIcon(FileMgmt.ICON_ASTERISK);
        reportImageIcon = new ImageIcon(FileMgmt.ICON_FLAG);
        settingsImageIcon = new ImageIcon(FileMgmt.ICON_GEAR);

        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridheight = 2;
        gbc.gridwidth = 1;
        gbc.weightx = 0;
        gbc.weighty = 1;
        gbc.ipadx = 20;
        gbc.ipady = 15;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        userIconLabel = new JLabel(userImageIcon);
        usernameLabel = new JLabel("USERNAME");

        this.add(userIconLabel, gbc);

        gbc.gridx = 1;
        gbc.ipadx = 0;
        gbc.ipady = 31;
        gbc.weightx = 1;
        gbc.anchor = GridBagConstraints.PAGE_START;
        
        this.add(new GraphicsDrawString(), gbc);
    }

    @Override
    protected void paintComponent(Graphics g) {
        // CREDITS: Guillaume Polet https://stackoverflow.com/a/14364486 (edited)

        GradientPaint gp;
        Graphics2D g2d;
        Color color1, color2;
        int width, height;

        super.paintComponent(g);
        g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        width = getWidth(); height = getHeight();
        color2 = new Color(109,41,173);
        color1 = new Color(199,125,255);
        gp = new GradientPaint(0, 0, color1, width, height, color2);
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, width, height);
    }
}

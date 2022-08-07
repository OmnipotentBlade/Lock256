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
    
    JLabel usernameLabel, userLabel, favoritesLabel, loginsLabel, recentsLabel, passwordsLabel, reportLabel, settingsLabel;
    ImageIcon userImageIcon, favoritesImageIcon, recentsImageIcon, passwordsImageIcon, generateImageIcon, loginsImageIcon, reportImageIcon, settingsImageIcon;
    GridBagConstraints userGbc, usernameGbc, favoritesGbc, loginsGbc, recentsGbc, passwordsGbc, reportGbc, settingsGbc;

    SideBarPanel() {
        this.setLayout(new GridBagLayout());

        userImageIcon = new ImageIcon(FileMgmt.ICON_PERSONCIRCLE);
        favoritesImageIcon = new ImageIcon(FileMgmt.ICON_STAR);
        loginsImageIcon = new ImageIcon(FileMgmt.ICON_PERSONCIRCLE); // TODO: Change image to actual login image once it is included in src/images/icons
        recentsImageIcon = new ImageIcon(FileMgmt.ICON_HISTORY);
        passwordsImageIcon = new ImageIcon(FileMgmt.ICON_ASTERISK);
        reportImageIcon = new ImageIcon(FileMgmt.ICON_FLAG);
        settingsImageIcon = new ImageIcon(FileMgmt.ICON_GEAR);

        userLabel = new JLabel(userImageIcon);
        usernameLabel = new JLabel("USERNAME");
        favoritesLabel = new JLabel(favoritesImageIcon);
        loginsLabel = new JLabel(loginsImageIcon);
        recentsLabel = new JLabel(recentsImageIcon);
        passwordsLabel = new JLabel(passwordsImageIcon);
        reportLabel = new JLabel(reportImageIcon);
        settingsLabel = new JLabel(settingsImageIcon);

        userGbc = new GridBagConstraints();
        usernameGbc = new GridBagConstraints();
        favoritesGbc = new GridBagConstraints();
        loginsGbc = new GridBagConstraints();
        recentsGbc = new GridBagConstraints();
        passwordsGbc = new GridBagConstraints();
        reportGbc = new GridBagConstraints();
        settingsGbc = new GridBagConstraints();

        userGbc.gridx = 0;
        userGbc.gridy = 0;
        userGbc.gridheight = 2;
        userGbc.gridwidth = 1;
        userGbc.weightx = 0;
        userGbc.weighty = 1;
        userGbc.ipadx = 20;
        userGbc.ipady = 15;
        userGbc.anchor = GridBagConstraints.FIRST_LINE_START;
        userGbc.fill = GridBagConstraints.HORIZONTAL;

        this.add(userLabel, userGbc);

        usernameGbc.gridx = 1;
        usernameGbc.gridy = 0;
        usernameGbc.gridheight = 1;
        usernameGbc.gridwidth = 1;
        usernameGbc.weightx = 1;
        usernameGbc.weighty = 1;
        usernameGbc.ipadx = 0;
        usernameGbc.ipady = 31;
        usernameGbc.anchor = GridBagConstraints.PAGE_START;
        usernameGbc.fill = GridBagConstraints.HORIZONTAL;
        
        this.add(new GraphicsDrawString(), usernameGbc);

        favoritesGbc.gridx = 0;
        favoritesGbc.gridy = 2;
        favoritesGbc.gridheight = 1;
        favoritesGbc.gridwidth = 1;
        favoritesGbc.weightx = 0;
        favoritesGbc.weighty = 1;
        favoritesGbc.ipadx = 0;
        favoritesGbc.ipady = 0;
        favoritesGbc.anchor = GridBagConstraints.FIRST_LINE_START;
        favoritesGbc.fill = GridBagConstraints.HORIZONTAL;

        this.add(favoritesLabel, favoritesGbc);

        recentsGbc.gridx = 0;
        recentsGbc.gridy = 3;
        recentsGbc.gridheight = 4;
        recentsGbc.gridwidth = 1;
        recentsGbc.weightx = 0;
        recentsGbc.weighty = 1;
        recentsGbc.ipadx = 0;
        recentsGbc.ipady = 0;
        recentsGbc.anchor = GridBagConstraints.LINE_START;
        recentsGbc.fill = GridBagConstraints.HORIZONTAL;

        this.add(recentsLabel, recentsGbc);

        loginsGbc.gridx = 0;
        loginsGbc.gridy = 4;
        loginsGbc.gridheight = 4;
        loginsGbc.gridwidth = 1;
        loginsGbc.weightx = 0;
        loginsGbc.weighty = 1;
        loginsGbc.ipadx = 0;
        loginsGbc.ipady = 0;
        loginsGbc.anchor = GridBagConstraints.LAST_LINE_START;
        loginsGbc.fill = GridBagConstraints.HORIZONTAL;

        this.add(loginsLabel, loginsGbc);

        passwordsGbc.gridx = 0;
        passwordsGbc.gridy = 5;
        passwordsGbc.gridheight = 5;
        passwordsGbc.gridwidth = 1;
        passwordsGbc.weightx = 0;
        passwordsGbc.weighty = 0;
        passwordsGbc.ipadx = 0;
        passwordsGbc.ipady = 0;
        passwordsGbc.anchor = GridBagConstraints.LAST_LINE_START;
        passwordsGbc.fill = GridBagConstraints.HORIZONTAL;

        this.add(passwordsLabel, passwordsGbc);
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

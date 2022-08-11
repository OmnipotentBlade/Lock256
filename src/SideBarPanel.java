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
    
    JLabel usernameLabel, userLabel, favoritesLabel, favoritesTextLabel, loginsLabel, recentsLabel, passwordsLabel, reportLabel, settingsLabel;
    ImageIcon userImageIcon, favoritesImageIcon, favoritesTextImageIcon, recentsImageIcon, passwordsImageIcon, generateImageIcon, loginsImageIcon, reportImageIcon, settingsImageIcon;

    SideBarPanel() {
        GBCSideBar gSideBar = new GBCSideBar();
        this.setLayout(new GridBagLayout());

        userImageIcon = new ImageIcon(FileMgmt.ICON_PERSONCIRCLE);
        favoritesImageIcon = new ImageIcon(FileMgmt.ICON_STAR);
        favoritesTextImageIcon = new ImageIcon("src/images/text_favorites.png");
        loginsImageIcon = new ImageIcon(FileMgmt.ICON_PERSONCIRCLE); // TODO: Change image to actual login image once it is included in src/images/icons
        recentsImageIcon = new ImageIcon(FileMgmt.ICON_HISTORY);
        passwordsImageIcon = new ImageIcon(FileMgmt.ICON_ASTERISK);
        reportImageIcon = new ImageIcon(FileMgmt.ICON_FLAG);
        settingsImageIcon = new ImageIcon(FileMgmt.ICON_GEAR);

        userLabel = new JLabel(userImageIcon);
        usernameLabel = new JLabel("USERNAME");
        favoritesLabel = new JLabel(favoritesImageIcon);
        favoritesTextLabel = new JLabel(favoritesTextImageIcon);
        loginsLabel = new JLabel(loginsImageIcon);
        recentsLabel = new JLabel(recentsImageIcon);
        passwordsLabel = new JLabel(passwordsImageIcon);
        reportLabel = new JLabel(reportImageIcon);
        settingsLabel = new JLabel(settingsImageIcon);

        this.add(userLabel, gSideBar.getGbc("user"));
        this.add(new GraphicsDrawString(), gSideBar.getGbc("username"));
        this.add(favoritesLabel, gSideBar.getGbc("favorites"));
        //this.add(favoritesTextLabel, favoritesTextGbc);
        this.add(recentsLabel, gSideBar.getGbc("recents"));
        this.add(loginsLabel, gSideBar.getGbc("logins"));
        this.add(passwordsLabel, gSideBar.getGbc("passwords"));
        this.add(reportLabel, gSideBar.getGbc("report"));
        this.add(settingsLabel, gSideBar.getGbc("settings"));
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

package src;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.GradientPaint;

import javax.swing.JPanel;

public class SideBarPanel extends JPanel {
    
    SideBarPanel() {

        this.setLayout(null); // TODO: Figure out which layout manager to use for the sidebar (boxlayout.pageaxis?)
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

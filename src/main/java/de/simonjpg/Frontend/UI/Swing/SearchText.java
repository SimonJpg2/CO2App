package de.simonjpg.Frontend.UI.Swing;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 * Class SearchText.
 * <p>
 *     Search text field on top of the JFrame.
 * </p>
 * @author SimonJpg
 * @see javax.swing.JTextField
 */
public class SearchText extends JTextField {

    /**
     * Constructor SearchText.
     * <p>
     *     sets border around the search text field
     * </p>
     */
    public SearchText() {
        setBorder(new EmptyBorder(5, 5, 5, 5));
        setSelectionColor(new Color(220, 204, 182));
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (getText().isEmpty()) {
            int h = getHeight();
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            Insets ins = getInsets();
            FontMetrics fm = g.getFontMetrics();
            int c0 = getBackground().getRGB();
            int c1 = getForeground().getRGB();
            int m = 0xfefefefe;

            // >>> unsigned right shift operator
            int c2 = ((c0 & m) >>> 1) + ((c1 & m) >>> 1);
            g2.setColor(new Color(c2, true));
            g2.drawString("Search here ...", ins.left, h / 2 + fm.getAscent() / 2 - 2);
        }
    }
}


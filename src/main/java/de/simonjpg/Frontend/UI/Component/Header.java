package de.simonjpg.Frontend.UI.Component;

import de.simonjpg.Frontend.UI.Swing.SearchText;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import static javax.swing.BorderFactory.createEmptyBorder;
import static javax.swing.GroupLayout.*;
import static javax.swing.LayoutStyle.ComponentPlacement.*;

//TODO: Add Javadoc
public class Header extends javax.swing.JPanel {
    private JLabel jLabel1;
    private JLabel jLabel2;
    private SearchText searchText1;

    public Header() {
        initComponents();
        setOpaque(false);
    }

    private void initComponents() {
        jLabel1 = new JLabel();
        searchText1 = new SearchText();
        jLabel2 = new JLabel();

        setBackground(new Color(255, 255, 255));

        jLabel1.setIcon(new ImageIcon(getClass().getResource("/icon/search.png"))); // NOI18N

        jLabel2.setIcon(new ImageIcon(getClass().getResource("/icon/menu.png"))); // NOI18N
        jLabel2.setBorder(createEmptyBorder(5, 5, 5, 5));

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addPreferredGap(RELATED)
                                .addComponent(searchText1, DEFAULT_SIZE, 606, Short.MAX_VALUE)
                                .addPreferredGap(RELATED)
                                .addComponent(jLabel2)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(Alignment.LEADING)
                        .addComponent(jLabel1, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(searchText1, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        g2.fillRect(0, 0, 25, getHeight());
        g2.fillRect(getWidth() - 25, getHeight() - 25, getWidth(), getHeight());
        super.paintComponent(grphcs);
    }
}


package de.simonjpg.Frontend.UI.Component;

import de.simonjpg.Frontend.UI.Model.Model_Menu;
import de.simonjpg.Frontend.UI.Swing.ListMenu;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import static javax.swing.GroupLayout.*;
import static javax.swing.GroupLayout.Alignment.LEADING;

// TODO: Add Javadoc
public class Menu extends JPanel {
    private JLabel jLabel1;
    private ListMenu<String> listMenu1;
    private JPanel panelMoving;

    public Menu() {
        initComponents();
        setOpaque(false);
        listMenu1.setOpaque(false);
        init();
    }

    private void init() {
        listMenu1.addItem(new Model_Menu("1", "Dashboard", Model_Menu.MenuType.MENU));
        listMenu1.addItem(new Model_Menu("2", "1990", Model_Menu.MenuType.MENU));
        listMenu1.addItem(new Model_Menu("2", "1995", Model_Menu.MenuType.MENU));
        listMenu1.addItem(new Model_Menu("2", "2000", Model_Menu.MenuType.MENU));
        listMenu1.addItem(new Model_Menu("2", "2005", Model_Menu.MenuType.MENU));
        listMenu1.addItem(new Model_Menu("2", "2010", Model_Menu.MenuType.MENU));
        listMenu1.addItem(new Model_Menu("2", "2015", Model_Menu.MenuType.MENU));
        listMenu1.addItem(new Model_Menu("2", "2020", Model_Menu.MenuType.MENU));
        listMenu1.addItem(new Model_Menu("2", "2022", Model_Menu.MenuType.MENU));
        listMenu1.addItem(new Model_Menu("", " ", Model_Menu.MenuType.EMPTY));

        listMenu1.addItem(new Model_Menu("", "Optionen", Model_Menu.MenuType.TITLE));
        listMenu1.addItem(new Model_Menu("", " ", Model_Menu.MenuType.EMPTY));
        listMenu1.addItem(new Model_Menu("6", "Gesundheit", Model_Menu.MenuType.MENU));
        listMenu1.addItem(new Model_Menu("10", "Beenden", Model_Menu.MenuType.MENU));
        listMenu1.addItem(new Model_Menu("", "", Model_Menu.MenuType.EMPTY));
    }

    private void initComponents() {
        panelMoving = new JPanel();
        jLabel1 = new JLabel();
        listMenu1 = new ListMenu<>();

        panelMoving.setOpaque(false);

        jLabel1.setFont(new Font("sansserif", 1, 18)); // NOI18N
        jLabel1.setForeground(new Color(255, 255, 255));
        jLabel1.setIcon(new ImageIcon(getClass().getResource("/icon/logo.png"))); // NOI18N
        jLabel1.setText("CO2 App");

        GroupLayout panelMovingLayout = new GroupLayout(panelMoving);
        panelMoving.setLayout(panelMovingLayout);
        panelMovingLayout.setHorizontalGroup(
                panelMovingLayout.createParallelGroup(LEADING)
                        .addGroup(panelMovingLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1, DEFAULT_SIZE, 203, Short.MAX_VALUE)
                                .addContainerGap())
        );
        panelMovingLayout.setVerticalGroup(
                panelMovingLayout.createParallelGroup(LEADING)
                        .addGroup(Alignment.TRAILING, panelMovingLayout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(jLabel1)
                                .addContainerGap())
        );

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(LEADING)
                        .addComponent(panelMoving, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(listMenu1, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(panelMoving, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(listMenu1, DEFAULT_SIZE, 414, Short.MAX_VALUE))
        );
    }

    @Override
    protected void paintChildren(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint g = new GradientPaint(0, 0, Color.decode("#1CB5E0"), 0, getHeight(), Color.decode("#000046"));
        g2.setPaint(g);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        g2.fillRect(getWidth() - 20, 0, getWidth(), getHeight());
        super.paintChildren(grphcs);
    }

    private int x;
    private int y;

    public void initMoving(JFrame fram) {
        panelMoving.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                x = me.getX();
                y = me.getY();
            }

        });
        panelMoving.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent me) {
                fram.setLocation(me.getXOnScreen() - x, me.getYOnScreen() - y);
            }
        });
    }
}


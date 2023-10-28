package de.simonjpg.Frontend.UI.Component;

import de.simonjpg.Frontend.UI.Event.EventMenuSelected;
import de.simonjpg.Frontend.UI.Model.ModelMenu;
import de.simonjpg.Frontend.UI.Swing.ListMenu;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.Objects;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import static java.awt.Font.BOLD;
import static java.lang.Short.MAX_VALUE;
import static javax.swing.GroupLayout.*;
import static javax.swing.GroupLayout.Alignment.LEADING;
import static javax.swing.GroupLayout.Alignment.TRAILING;

// TODO: Add Javadoc
public class Menu extends JPanel {
    private JLabel jLabel1;
    private ListMenu<String> listMenu1;
    private JPanel panelMoving;
    private EventMenuSelected event;
    private static final Logger LOGGER = LogManager.getLogger(Menu.class);

    public Menu() {
        initComponents();
        setOpaque(false);
        listMenu1.setOpaque(false);
        init();
    }

    public void addEventMenuSelected(EventMenuSelected event) {
        this.event = event;
        listMenu1.addEventMenuSelected(event);
    }

    private void init() {
        LOGGER.info("Add MenuItem to Chart");
        listMenu1.addItem(new ModelMenu("1", "Dashboard", ModelMenu.MenuType.MENU));
        listMenu1.addItem(new ModelMenu("2", "1990", ModelMenu.MenuType.MENU));
        listMenu1.addItem(new ModelMenu("2", "1995", ModelMenu.MenuType.MENU));
        listMenu1.addItem(new ModelMenu("2", "2000", ModelMenu.MenuType.MENU));
        listMenu1.addItem(new ModelMenu("2", "2005", ModelMenu.MenuType.MENU));
        listMenu1.addItem(new ModelMenu("2", "2010", ModelMenu.MenuType.MENU));
        listMenu1.addItem(new ModelMenu("2", "2015", ModelMenu.MenuType.MENU));
        listMenu1.addItem(new ModelMenu("2", "2020", ModelMenu.MenuType.MENU));
        listMenu1.addItem(new ModelMenu("2", "2022", ModelMenu.MenuType.MENU));
        listMenu1.addItem(new ModelMenu("2", "Infos", ModelMenu.MenuType.MENU));
        listMenu1.addItem(new ModelMenu("", " ", ModelMenu.MenuType.EMPTY));

        listMenu1.addItem(new ModelMenu("", "Optionen", ModelMenu.MenuType.TITLE));
        listMenu1.addItem(new ModelMenu("", " ", ModelMenu.MenuType.EMPTY));
        listMenu1.addItem(new ModelMenu("6", "Gesundheit", ModelMenu.MenuType.MENU));
        listMenu1.addItem(new ModelMenu("10", "Beenden", ModelMenu.MenuType.MENU));
        listMenu1.addItem(new ModelMenu("", "", ModelMenu.MenuType.EMPTY));
    }

    private void initComponents() {
        panelMoving = new JPanel();
        jLabel1 = new JLabel();
        listMenu1 = new ListMenu<>();

        panelMoving.setOpaque(false);

        jLabel1.setFont(new Font("sansserif", BOLD, 18));
        jLabel1.setForeground(new Color(255, 255, 255));
        jLabel1.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/icon/co2-icon.png"))));
        jLabel1.setText("CO2 App");

        GroupLayout panelMovingLayout = new GroupLayout(panelMoving);
        panelMoving.setLayout(panelMovingLayout);
        panelMovingLayout.setHorizontalGroup(
                panelMovingLayout.createParallelGroup(LEADING)
                        .addGroup(panelMovingLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1, DEFAULT_SIZE, 203, MAX_VALUE)
                                .addContainerGap())
        );
        panelMovingLayout.setVerticalGroup(
                panelMovingLayout.createParallelGroup(LEADING)
                        .addGroup(TRAILING, panelMovingLayout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(jLabel1)
                                .addContainerGap())
        );

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(LEADING)
                        .addComponent(panelMoving, DEFAULT_SIZE, DEFAULT_SIZE, MAX_VALUE)
                        .addComponent(listMenu1, DEFAULT_SIZE, DEFAULT_SIZE, MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(panelMoving, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(listMenu1, DEFAULT_SIZE, 414, MAX_VALUE))
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


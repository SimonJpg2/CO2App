package de.simonjpg.Frontend.UI;

import de.simonjpg.Backend.Database.Database;
import de.simonjpg.Frontend.UI.Component.Header;
import de.simonjpg.Frontend.UI.Component.Menu;
import de.simonjpg.Frontend.UI.Form.*;
import de.simonjpg.Frontend.UI.Swing.PanelBorder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import java.awt.*;

import static java.awt.Font.PLAIN;
import static java.lang.Short.MAX_VALUE;
import static javax.swing.GroupLayout.Alignment.LEADING;
import static javax.swing.GroupLayout.DEFAULT_SIZE;
import static javax.swing.GroupLayout.PREFERRED_SIZE;
import static javax.swing.LayoutStyle.ComponentPlacement.RELATED;

/**
 * Class DataFrame.
 *
 * <p>
 *     The JFrame to display the CO2 data.
 *     This Class has been created with Netbeans IDE.
 * </p>
 *
 * @author SimonJpg
 * @see javax.swing.JFrame
 */
public class DataFrame extends JFrame {
    private Header header2;
    private Menu menu1;
    private PanelBorder panelBorder1;
    private JPanel mainPanel;
    private final Form1990 form1990;
    private final Form1995 form1995;
    private final Form2000 form2000;
    private final Form2005 form2005;
    private final Form2010 form2010;
    private final Form2015 form2015;
    private final Form2020 form2020;
    private final Form2022 form2022;
    private final FormDashboard formDashboard;
    private final FormGesundheit formGesundheit;
    private final FormInfos formInfos;
    private static final Logger LOGGER = LogManager.getLogger(DataFrame.class);

    /**
     * Creates new form DataFrame.
     */
    public DataFrame() {
        initComponents();
        setBackground(new Color(0, 0, 0, 0));

        // Forms
        formDashboard = new FormDashboard();
        form1990 = new Form1990();
        form1995 = new Form1995();
        form2000 = new Form2000();
        form2005 = new Form2005();
        form2010 = new Form2010();
        form2015 = new Form2015();
        form2020 = new Form2020();
        form2022 = new Form2022();
        formGesundheit = new FormGesundheit();
        formInfos = new FormInfos();

        menu1.initMoving(DataFrame.this);
        menu1.addEventMenuSelected(index -> {
            switch (index) {
                case 0: setForm(formDashboard); LOGGER.info("Selected FormDashboard"); break;
                case 1: setForm(form1990); LOGGER.info("Selected Form1990"); break;
                case 2: setForm(form1995); LOGGER.info("Selected Form1995"); break;
                case 3: setForm(form2000); LOGGER.info("Selected Form2000"); break;
                case 4: setForm(form2005); LOGGER.info("Selected Form2005"); break;
                case 5: setForm(form2010); LOGGER.info("Selected Form2010"); break;
                case 6: setForm(form2015); LOGGER.info("Selected Form2015"); break;
                case 7: setForm(form2020); LOGGER.info("Selected Form2020"); break;
                case 8: setForm(form2022); LOGGER.info("Selected Form2022"); break;
                case 9: setForm(formInfos); LOGGER.info("Selected FormInfos"); break;
                case 13: setForm(formGesundheit); LOGGER.info("Selected FormGesundheit"); break;
                case 14: LOGGER.info("Stopping tasks"); shutDown(); break;
                default: LOGGER.warn("Unexpected JItem value"); break;
            }
        });

        // Default form which is displayed after startup.
        setForm(formDashboard);
    }

    /**
     * Method shutDown.
     * <p>
     *     Initiates shutdown of application.
     * </p>
     */
    private void shutDown() {
        Database.instance().disconnect();
        System.exit(0);
    }

    private void setForm(JComponent com) {
        mainPanel.removeAll();
        mainPanel.add(com);
        mainPanel.repaint();
        mainPanel.revalidate();
    }

    private void initComponents() {
        LOGGER.info("Initializing JFrame components");
        panelBorder1 = new PanelBorder();
        menu1 = new Menu();
        header2 = new Header();
        mainPanel = new JPanel();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setUndecorated(true);

        panelBorder1.setBackground(new Color(242, 242, 242));

        header2.setFont(new Font("sansserif", PLAIN, 14));

        mainPanel.setOpaque(false);
        mainPanel.setLayout(new BorderLayout());

        GroupLayout panelBorder1Layout = new GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
                panelBorder1Layout.createParallelGroup(LEADING)
                        .addGroup(panelBorder1Layout.createSequentialGroup()
                                .addComponent(menu1, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                .addGroup(panelBorder1Layout.createParallelGroup(LEADING)
                                        .addComponent(header2, DEFAULT_SIZE, 965, MAX_VALUE)
                                        .addGroup(panelBorder1Layout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addComponent(mainPanel, DEFAULT_SIZE, DEFAULT_SIZE, MAX_VALUE)
                                                .addContainerGap())))
        );
        panelBorder1Layout.setVerticalGroup(
                panelBorder1Layout.createParallelGroup(LEADING)
                        .addComponent(menu1, DEFAULT_SIZE, 657, MAX_VALUE)
                        .addGroup(panelBorder1Layout.createSequentialGroup()
                                .addComponent(header2, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                .addPreferredGap(RELATED)
                                .addComponent(mainPanel, DEFAULT_SIZE, DEFAULT_SIZE, MAX_VALUE)
                                .addContainerGap())
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(LEADING)
                        .addComponent(panelBorder1, DEFAULT_SIZE, DEFAULT_SIZE, MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(LEADING)
                        .addComponent(panelBorder1, DEFAULT_SIZE, DEFAULT_SIZE, MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }
}


package de.simonjpg.Frontend.UI;

import de.simonjpg.Frontend.UI.Component.Header;
import de.simonjpg.Frontend.UI.Component.Menu;
import de.simonjpg.Frontend.UI.Event.EventMenuSelected;
import de.simonjpg.Frontend.UI.Form.Form1995;
import de.simonjpg.Frontend.UI.Form.FormDashboard;
import de.simonjpg.Frontend.UI.Form.FormGesundheit;
import de.simonjpg.Frontend.UI.Form.FormMain;
import de.simonjpg.Frontend.UI.Swing.PanelBorder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import java.awt.*;

/**
 * Class DataFrame.
 *
 * <p>
 *     The JFrame to display the CO2 data.
 * </p>
 *
 * @author SimonJpg
 * @see javax.swing.JFrame
 */

//TODO: Add Javadoc
public class DataFrame extends JFrame {
    private Header header2;
    private Menu menu1;
    private PanelBorder panelBorder1;
    private JPanel mainPanel;
    private FormMain home;
    private Form1995 form1995;
    private FormDashboard formDashboard;
    private FormGesundheit formGesundheit;
    private static final Logger LOGGER = LogManager.getLogger(DataFrame.class);

    /**
     * Creates new form Main
     */
    public DataFrame() {
        initComponents();
        setBackground(new Color(0, 0, 0, 0));

        home = new FormMain();
        formDashboard = new FormDashboard();
        form1995 = new Form1995();
        formGesundheit = new FormGesundheit();

        menu1.initMoving(DataFrame.this);
        menu1.addEventMenuSelected(new EventMenuSelected() {
            @Override
            public void selected(int index) {
                LOGGER.info("Selected index {}", index);
                switch (index) {
                    case 0: setForm(formDashboard); break;
                    case 1: setForm(form1995); break;
                    // TODO: Add other forms
                    default: break;
                }
            }
        });

        // Default form which is displayed after startup.
        setForm(home);
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panelBorder1.setBackground(new java.awt.Color(242, 242, 242));

        header2.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N

        mainPanel.setOpaque(false);
        mainPanel.setLayout(new BorderLayout());

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
                panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelBorder1Layout.createSequentialGroup()
                                .addComponent(menu1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(header2, javax.swing.GroupLayout.DEFAULT_SIZE, 965, Short.MAX_VALUE)
                                        .addGroup(panelBorder1Layout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addContainerGap())))
        );
        panelBorder1Layout.setVerticalGroup(
                panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(menu1, javax.swing.GroupLayout.DEFAULT_SIZE, 657, Short.MAX_VALUE)
                        .addGroup(panelBorder1Layout.createSequentialGroup()
                                .addComponent(header2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }
}


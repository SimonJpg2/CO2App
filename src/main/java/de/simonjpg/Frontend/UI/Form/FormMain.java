package de.simonjpg.Frontend.UI.Form;

import javax.swing.*;
import java.awt.Color;
import java.awt.Font;

import static java.lang.Short.*;
import static javax.swing.GroupLayout.Alignment.*;
import static javax.swing.GroupLayout.DEFAULT_SIZE;
import static javax.swing.SwingConstants.CENTER;

// TODO: Add Curve Line Chart
public class FormMain extends JPanel {
    private JLabel jLabel1;
    /*
     * Form Main is the main form which sits on top of the JPanel where the Chart should be placed at.
     * The other forms extends from this form to have the same size and chart
     * Only the values will need to be changed.
     */
    public FormMain() {
        initComponents();
    }

    private void initComponents() {

        jLabel1 = new JLabel();

        setBackground(new Color(242, 242, 242));

        jLabel1.setFont(new Font("sansserif", 0, 36)); // NOI18N
        jLabel1.setForeground(new Color(106, 106, 106));
        jLabel1.setHorizontalAlignment(CENTER);
        jLabel1.setText("Form 1");

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(LEADING)
                        .addGroup(TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1, DEFAULT_SIZE, 388, MAX_VALUE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(LEADING)
                        .addGroup(TRAILING, layout.createSequentialGroup()
                                .addGap(128, 128, 128)
                                .addComponent(jLabel1, DEFAULT_SIZE, DEFAULT_SIZE, MAX_VALUE)
                                .addGap(125, 125, 125))
        );
    }
}
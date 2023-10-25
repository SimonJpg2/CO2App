package de.simonjpg.Frontend.UI.Form;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;

import java.awt.Color;

import de.simonjpg.Frontend.UI.CurveLineChart.raven.chart.CurveLineChart;
import de.simonjpg.Frontend.UI.CurveLineChart.raven.chart.ModelChart;
import de.simonjpg.Frontend.UI.CurveLineChart.raven.panel.PanelShadow;

import static java.lang.Short.MAX_VALUE;
import static javax.swing.GroupLayout.Alignment.*;
import static javax.swing.GroupLayout.DEFAULT_SIZE;

/**
 *
 * @author SimonJpg
 */
//TODO: Add Javadoc
public class FormDashboard extends JPanel {
    private CurveLineChart chart;
    private PanelShadow panelShadow1;

    /** Creates new form NewJPanel */
    public FormDashboard() {
        initComponents();
        chart.setTitle("CO2 Daten");

        /*
         * RGB Color codes for legend
         *
         * Standard: color1: #7b4397 color2: #dc2430
         */

        chart.addLegend("Konzentration", Color.decode("#7b4397"), Color.decode("#dc2430"));
        chart.setTitleColor(Color.decode("#FFFFFF"));
        setData();
    }

    private void setData() {
        //TODO: Add loop as shown in video.
        chart.addData(new ModelChart("1990", new double[]{42.1241471898}));
        chart.addData(new ModelChart("1990", new double[]{43.1241471898}));
        chart.addData(new ModelChart("1990", new double[]{25.1241471898}));
        chart.addData(new ModelChart("1990", new double[]{15.1241471898}));
        chart.addData(new ModelChart("1995", new double[]{32.1241471898}));
        chart.addData(new ModelChart("1995", new double[]{25.1241471898}));
        chart.addData(new ModelChart("1995", new double[]{10.1241471898}));

        // startet Animation bei Mouseover
        chart.start();

        // füllt Fläche unterhalb Funktion in derselben Farbe, wie die Funktion
        chart.setFillColor(true);
    }

    private void initComponents() {

        panelShadow1 = new PanelShadow();
        chart = new CurveLineChart();

        /*
         * RGB Color codes for panel background
         *
         * R:45 G:93 B:117 Aqua
         * R:38 G:86 B:87 Standard
         * R:46 G:129 B:159 Light Blue
         *
         */
        panelShadow1.setBackground(new Color(46, 129, 159));
        panelShadow1.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelShadow1.setColorGradient(new Color(46, 129, 159));

        GroupLayout panelShadow1Layout = new GroupLayout(panelShadow1);
        panelShadow1.setLayout(panelShadow1Layout);
        panelShadow1Layout.setHorizontalGroup(
                panelShadow1Layout.createParallelGroup(LEADING)
                        .addGroup(panelShadow1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(chart, DEFAULT_SIZE, 600, MAX_VALUE))
        );
        panelShadow1Layout.setVerticalGroup(
                panelShadow1Layout.createParallelGroup(LEADING)
                        .addGroup(panelShadow1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(chart, DEFAULT_SIZE, 390, MAX_VALUE)
                                .addContainerGap())
        );

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(LEADING)
                        .addComponent(panelShadow1, DEFAULT_SIZE, DEFAULT_SIZE, MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(LEADING)
                        .addComponent(panelShadow1, DEFAULT_SIZE, DEFAULT_SIZE, MAX_VALUE)
        );
    }
}
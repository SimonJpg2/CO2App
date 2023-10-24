package de.simonjpg.Frontend.UI.Form;

import javax.swing.*;

import java.awt.Color;

import de.simonjpg.Frontend.UI.CurveLineChart.raven.chart.CurveLineChart;
import de.simonjpg.Frontend.UI.CurveLineChart.raven.chart.ModelChart;
import de.simonjpg.Frontend.UI.CurveLineChart.raven.panel.PanelShadow;

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
        chart.addLegend("Konzentration", Color.decode("#7b4397"), Color.decode("#dc2430"));
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

        panelShadow1.setBackground(new java.awt.Color(38, 86, 87));
        panelShadow1.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelShadow1.setColorGradient(new java.awt.Color(38, 86, 87));

        javax.swing.GroupLayout panelShadow1Layout = new javax.swing.GroupLayout(panelShadow1);
        panelShadow1.setLayout(panelShadow1Layout);
        panelShadow1Layout.setHorizontalGroup(
                panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelShadow1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(chart, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE))
        );
        panelShadow1Layout.setVerticalGroup(
                panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelShadow1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(chart, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
                                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }
}
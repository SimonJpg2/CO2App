package de.simonjpg.Frontend.UI.Form;

import javax.swing.*;

import java.awt.*;
import java.util.List;

import de.simonjpg.Backend.Backend;
import de.simonjpg.Backend.Database.Entities.CO2Entity;
import de.simonjpg.Backend.Database.Services.CO2Service;
import de.simonjpg.Backend.Exceptions.SelectStatementFailedException;
import de.simonjpg.Frontend.UI.CurveLineChart.raven.chart.CurveLineChart;
import de.simonjpg.Frontend.UI.CurveLineChart.raven.chart.ModelChart;
import de.simonjpg.Frontend.UI.CurveLineChart.raven.panel.PanelShadow;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static java.lang.Short.MAX_VALUE;
import static javax.swing.GroupLayout.Alignment.*;
import static javax.swing.GroupLayout.DEFAULT_SIZE;

/**
 * Class FormDashboard.
 * <p>
 *     JPanel which contains the Curved Line Chart.
 * </p>
 * @author Simon Balcke
 * @see javax.swing.JPanel
 */
public class FormDashboard extends JPanel implements FormMain {
    protected CurveLineChart chart;
    private PanelShadow panelShadow1;
    private static final Logger LOGGER = LogManager.getLogger(FormDashboard.class);

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

    /**
     * Method setData.
     * <p>
     *     Adds Co² data to chart
     * </p>
     */
    @Override
    public void setData() {
        Backend backend = Backend.instance();
        CO2Service service = CO2Service.instance(backend.getConnection());

        try {
            List<CO2Entity> entities = service.select();
            LOGGER.info("Adding Co2 data to chart");
            for (CO2Entity entity : entities) {
                chart.addData(new ModelChart("", new double[]{entity.getValue()}));
            }
        } catch (SelectStatementFailedException e) {
            LOGGER.error("Failed to add Co2 data to chart.\n{}", e.getMessage());
        }

        // startet Animation bei Mouseover
        chart.start();

        // füllt Fläche unterhalb Funktion in derselben Farbe, wie die Funktion
        // chart.setFillColor(true);
    }

    private void initComponents() {
        panelShadow1 = new PanelShadow() {
            // Smooth rounded corners
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                RenderingHints qualityHints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                qualityHints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                g2.setRenderingHints(qualityHints);
                g2.setPaint(new Color(46, 129, 159));
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 25, 25);
                g2.dispose();
            }
        };

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
    @Override
    protected void paintComponent(Graphics g) {
        // Smooth rounded corners
        Graphics2D g2 = (Graphics2D) g.create();
        RenderingHints qualityHints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        qualityHints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2.setRenderingHints(qualityHints);
        g2.setPaint(new Color(46, 129, 159));
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 25, 25);
        g2.dispose();
    }

}
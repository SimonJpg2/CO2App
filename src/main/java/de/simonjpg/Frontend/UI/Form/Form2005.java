package de.simonjpg.Frontend.UI.Form;

import de.simonjpg.Backend.Backend;
import de.simonjpg.Backend.Database.Entities.CO2Entity;
import de.simonjpg.Backend.Database.Services.CO2Service;
import de.simonjpg.Backend.Exceptions.SelectStatementFailedException;
import de.simonjpg.Frontend.UI.CurveLineChart.raven.chart.ModelChart;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

/**
 * Class Form2005.
 * <p>
 *     JPanel which contains Curved Line Chart to display co2 data of 2005.
 * </p>
 * @author Simon Balcke
 * @see de.simonjpg.Frontend.UI.Form.FormDashboard
 */

public class Form2005 extends FormDashboard {
    private static final Logger LOGGER = LogManager.getLogger(Form2005.class);

    /**
     * Method setData.
     * <p>
     *     Fills Curved Line Chart with Co2 data of 2005.
     * </p>
     */
    @Override
    public void setData() {
        Backend backend = Backend.instance();
        CO2Service service = CO2Service.instance(backend.getConnection());

        try {
            List<CO2Entity> entities = service.selectYear(2005);
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
        chart.setFillColor(true);
    }
}

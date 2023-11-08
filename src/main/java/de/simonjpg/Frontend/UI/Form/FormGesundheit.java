package de.simonjpg.Frontend.UI.Form;

import de.simonjpg.Frontend.UI.CurveLineChart.raven.chart.ModelChart;

/**
 * Class FormGesundheit.
 * <p>
 *     Die CO² Konzentration steigt pro jahr um ca. 2ppm.
 *     Es dauert hunderte Jahre, bis die Luft der Atmosphäre als verbraucht gilt (1400ppm).
 *     Es dauert 40.000 Jahre, bis die Luft der Atmosphäre tödlich für den Menschen werden würde (80000ppm).
 * </p>
 * <p>
 *     Das größere Problem ist der Treibhauseffekt. Bevor wir aufgrund der Co² Konzentration "ersticken", zerstören wir
 *     unseren Planeten, welcher für uns Menschen die Lebensgrundlage darstellt.
 * </p>
 * @author Simon Balcke
 * @see de.simonjpg.Frontend.UI.Form.FormDashboard
 */

public class FormGesundheit extends FormDashboard {
    @Override
    public void setData() {
        chart.setTitle("Es wird jahrtausende dauern bis CO² unsere Gesundheit gefährdet.");
        for (int i = 400; i < 1400; i++) {
            chart.addData(new ModelChart("", new double[]{i}));
        }
        chart.start();
        chart.setFillColor(true);
    }
}

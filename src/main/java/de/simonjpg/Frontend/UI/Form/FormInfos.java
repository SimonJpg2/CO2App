
package de.simonjpg.Frontend.UI.Form;

import javax.swing.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.Objects;

import static java.lang.Short.MAX_VALUE;
import static javax.swing.BorderFactory.createEmptyBorder;
import static javax.swing.GroupLayout.Alignment.LEADING;
import static javax.swing.GroupLayout.Alignment.TRAILING;
import static javax.swing.GroupLayout.DEFAULT_SIZE;
import static javax.swing.GroupLayout.PREFERRED_SIZE;
import static javax.swing.LayoutStyle.ComponentPlacement.RELATED;
import static javax.swing.LayoutStyle.ComponentPlacement.UNRELATED;

/**
 * Class FormInfos.
 *
 * <p>
 *     This class has been created with Netbeans IDE.
 * </p>
 *
 * @author SimonJpg
 * @see javax.swing.JPanel
 */
public class FormInfos extends JPanel {
    private JLabel CO2Label1;
    private JLabel CO2Label2;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JScrollPane jScrollPane1;
    private JTextArea jTextArea1;
    private JLabel labelIcon1;
    private JLabel labelIcon2;

    /*
    *
    * Textquelle: https://www.wissenschaft-im-dialog.de/projekte/wieso/artikel/beitrag/geht-uns-die-luft-zum-atmen-aus/
    *
    */
    private final String text = "Geht uns die Luft zum Atmen aus?\n" +
            "\n" +
            "Zum Atmen benötigen wir Sauerstoff. An Kohlenstoffdioxid in Reinform würden wir ersticken. Durch die Verbrennung fossiler Brennstoffe verbrauchen wir immer mehr Sauerstoff und stoßen gleichzeitig immer mehr Kohlenstoffdioxid aus. Nur etwa die Hälfte der pro Jahr ausgestoßenen Menge an Kohlenstoffdioxid kann von unseren natürlichen Speichern wie Regenwäldern, Erdböden und Ozeanen aufgenommen werden, der Rest verbleibt in der Atmosphäre und reichert sich dort an.\n\n Geht uns also bald die Luft zu Atmen aus?\n" +
            "\n" +
            "Unsere Atemluft besteht zu 21 Prozent aus Sauerstoff und 78 Prozent aus Stickstoff, einem Element, das als Baustein in unserem Erbgut und in Proteinen essentiell für alle Lebewesen ist.\n\n Im Vergleich dazu macht Kohlenstoffdioxid nur einen Bruchteil der verbleibenden 1 Prozent in der Luft aus. Der Kohlenstoffdioxidgehalt in der Luft lag vor der Nutzung fossiler Brennstoffe bei 280 ppm (parts per million) und ist auf aktuell 400 ppm angestiegen.\n\n Gleichzeitig ist die Sauerstoffkonzentration gesunken: jeweils um das Anderthalbfache der entstandenen Menge Kohlendioxid. Da unsere Luft aber so viel mehr Sauerstoff als Kohlendioxid hat, fällt die Sauerstoffabnahme in der Gesamtmischung kaum ins Gewicht. \n" +
            "\n" +
            "Unsere Gesundheit gefährde diese Entwicklung nicht, sagt der Physiker Thomas Leisner vom Institut für Meteorologie und Klimaforschung des KIT. „Wir können zwar erhöhte Konzentrationen des Gases schon ab 1.400 ppm als verbrauchte Luft wahrnehmen, beispielsweise in ‚schlecht‘ belüfteten Räumen, aber erst in sehr hohen Konzentrationen ab circa 80.000 ppm ist Kohlenstoffdioxid so giftig für den Körper, dass es tödlich wirkt.“\n\n Bliebe es bei einem Anstieg der Konzentration um circa 2 ppm pro Jahr, würde es Jahrhunderte dauern, bis es „dicke Luft“ gibt, und weitere Jahrtausende, bis Kohlenstoffdioxid unsere Gesundheit gefährdet. \n" +
            "\n" +
            "Dann können wir aufatmen, oder? Leider nicht, denn der erhöhte Kohlenstoffdioxidgehalt in der Atmosphäre hat heute schon verheerende Auswirkungen auf das Erdklima. Dabei hat Kohlenstoffdioxid grundsätzlich eine wichtige Aufgabe. Das Gas verteilt sich in der Atmosphäre und bildet eine schützende Decke, die verhindert, dass die Erde zu viel Wärme in den Weltraum abstrahlt.\n\n Dieser sogenannte Treibhauseffekt erzeugt ein optimales Klima für die Pflanzen und Tiere auf unserem Planeten. Aber: Mittlerweile sammeln sich immer größere Mengen des Spurengases in der Atmosphäre und verhindern, dass die Erde Wärme abgibt. Es kommt zum menschengemachten Treibhauseffekt.\n\n In der Folge verändert sich das Erdklima, das Wetter wird weltweit extremer und es entstehen Dürren, Überflutungen, extrem heiße Sommer, aber auch außergewöhnlich starke Stürme und Winter. Der menschengemachte Klimawandel bedroht ganze Lebensräume, Tier- und Pflanzenarten, die in komplexen Ökosystemen zusammenleben und damit auch unsere eigene Lebensgrundlage. \n" +
            "\n" +
            "Bevor uns also die Luft zum Atmen ausgeht, verlieren wir unseren Lebensraum durch extreme Klimaveränderungen. Das sieht auch Thomas Leisner so.\n" +
            "\n" +
            "Bei der Beantwortung der Frage hat uns Prof. Dr. Thomas Leisner unterstützt.\n\n Er ist Direktor des Institut für Meteorologie und Klimaforschung am Karlsruher Institut für Technologie und Professor für Umweltphysik an der Universität Heidelberg. ";
    /**
     * Creates new form TestForm
     */
    public FormInfos() {
        initComponents();
        jTextArea1.setEditable(false);
        jTextArea1.setText(text);
    }

    // Smooth rounded corners
    @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            RenderingHints qualityHints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            qualityHints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            g2.setRenderingHints(qualityHints);
            g2.setPaint(new Color(0, 83, 205));
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), 25, 25);
            g2.dispose();
        }

    private void initComponents() {
        jScrollPane1 = new JScrollPane();

        jTextArea1 = new JTextArea();

        jPanel1 = new JPanel() {
            // Smooth rounded corners
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                RenderingHints qualityHints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                qualityHints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                g2.setRenderingHints(qualityHints);
                g2.setPaint(new Color(51, 155, 188));
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 25, 25);
                g2.dispose();
            }
        };

        labelIcon1 = new JLabel();
        labelIcon1.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/icon/co2-icon.png"))));

        CO2Label1 = new JLabel();
        jLabel2 = new JLabel();

        jPanel2 = new JPanel() {
            // smooth rounded corners
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                RenderingHints qualityHints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                qualityHints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                g2.setRenderingHints(qualityHints);
                g2.setPaint(new Color(51, 155, 188));
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 25, 25);
                g2.dispose();
            }
        };

        labelIcon2 = new JLabel();
        labelIcon2.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/icon/co2-icon.png"))));

        CO2Label2 = new JLabel();
        jLabel1 = new JLabel();

        setBackground(new Color(0, 83, 205));
        setBorder(createEmptyBorder(10, 10, 10, 10));

        jTextArea1.setBackground(new Color(232, 232, 232));
        jTextArea1.setForeground(new Color(0,0,0));
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jPanel1.setBackground(new Color(51, 155, 188));
        jPanel1.setToolTipText("");

        CO2Label1.setForeground(new Color(255, 255, 255));
        CO2Label1.setText("CO² heute");

        jLabel2.setForeground(new Color(255, 255, 255));
        jLabel2.setText("400,00 ppm");

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelIcon1, PREFERRED_SIZE, 71, PREFERRED_SIZE)
                .addGap(84, 84, 84)
                .addGroup(jPanel1Layout.createParallelGroup(LEADING, false)
                    .addComponent(CO2Label1, DEFAULT_SIZE, 105, MAX_VALUE)
                    .addComponent(jLabel2, DEFAULT_SIZE, DEFAULT_SIZE, MAX_VALUE))
                .addContainerGap(124, MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(CO2Label1, PREFERRED_SIZE, 26, PREFERRED_SIZE)
                        .addPreferredGap(UNRELATED)
                        .addComponent(jLabel2, DEFAULT_SIZE, 24, MAX_VALUE)
                        .addGap(9, 9, 9))
                    .addComponent(labelIcon1, DEFAULT_SIZE, DEFAULT_SIZE, MAX_VALUE))
                .addContainerGap())
        );

        jPanel2.setBackground(new Color(51, 155, 188));

        CO2Label2.setForeground(new Color(255, 255, 255));
        CO2Label2.setText("CO² Zugspitze");

        jLabel1.setForeground(new Color(255, 255, 255));
        jLabel1.setText("417,838 ppm");

        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelIcon2, PREFERRED_SIZE, 71, PREFERRED_SIZE)
                .addGap(84, 84, 84)
                .addGroup(jPanel2Layout.createParallelGroup(LEADING, false)
                    .addComponent(CO2Label2, DEFAULT_SIZE, 105, MAX_VALUE)
                    .addComponent(jLabel1, DEFAULT_SIZE, DEFAULT_SIZE, MAX_VALUE))
                .addContainerGap(124, MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(LEADING)
                    .addComponent(labelIcon2, DEFAULT_SIZE, DEFAULT_SIZE, MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(CO2Label2, PREFERRED_SIZE, 26, PREFERRED_SIZE)
                        .addPreferredGap(UNRELATED)
                        .addComponent(jLabel1, DEFAULT_SIZE, 24, MAX_VALUE)
                        .addGap(9, 9, 9))))
        );

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(20, MAX_VALUE)
                .addComponent(jScrollPane1, PREFERRED_SIZE, 895, PREFERRED_SIZE)
                .addContainerGap(15, MAX_VALUE))
            .addGroup(TRAILING, layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jPanel1, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                .addPreferredGap(RELATED, DEFAULT_SIZE, MAX_VALUE)
                .addComponent(jPanel2, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(LEADING)
            .addGroup(TRAILING, layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(LEADING)
                    .addComponent(jPanel1, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                    .addComponent(jPanel2, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, PREFERRED_SIZE, 425, PREFERRED_SIZE)
                .addContainerGap(15, MAX_VALUE))
        );
    }
}
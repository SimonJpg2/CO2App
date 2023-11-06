
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
    private final String text = "Auch wenig CO2 reicht aus\n" +
            "Um zu verstehen, warum CO2 und andere Treibhausgase für unseren Planeten eine wichtige Rolle spielen, kann man sich beispielsweise die Erde ganz ohne Atmosphäre vorstellen.\n" +
            "\n" +
            "Unser Mond zum Beispiel hat keine Atmosphäre. Die Sonnenstrahlung heizt die Oberfläche tagsüber auf mehr als 100 Grad Celsius auf, nachts fällt sie auf etwa minus 160 Grad. Ohne die Atmosphäre würde auch auf der Erde ein viel größerer Temperaturunterschied herrschen. Forschende haben berechnet, dass die Durchschnittstemperatur auf der Erde bei minus 18 Grad liegen würde. Tatsächlich liegt sie aber bei 15 Grad Celsius – also rund 33 Grad mehr.\n" +
            "\n" +
            "Dass die Temperaturen weder tags- noch nachtsüber so extrem sind, hängt mit unserer Atmosphäre zusammen, die auch als Schutzschild fungiert. Zuerst einmal verhindert unsere Atmosphäre, dass die gesamte Sonnenstrahlung auf die Erde trifft. Insgesamt gelangt weniger als die Hälfte der Sonnenstrahlung auf die Erdoberfläche. Wolken etwa reflektieren ein Viertel der Sonnenstrahlung direkt wieder ins All, die Schneemassen einen weiteren Teil.\n" +
            "\n" +
            "Die übrige Energie gelangt auf die Erdoberfläche, wird dort umgewandelt und in Form von Wärmestrahlung wieder Richtung Weltall geschickt. Wichtig hierbei ist: Was von der Erdoberfläche zurückstrahlt, ist eine andere Strahlung als jene, die aus Richtung der Sonne kommt. Die von der Erde ausgehende Wärmestrahlung kann jedoch zwischen Atmosphäre und Boden reflektiert und in einem gewissen Sinne von Treibhausgasen gefangen werden.\n" +
            "\n" +
            "Diese Gase (Wasserdampf, CO2, Methan und andere) verhindern also, dass die Wärmestrahlung sofort ins Weltall entweicht. Stattdessen wird sie teils erneut zurück zur Erde geschickt - und hierin liegt die Klimawirkung von CO2 und anderen: entscheidend ist die chemische Struktur der Gase in der Atmosphäre. Treibhausgase setzen sich aus drei oder mehr Atomen zusammen. Kohlenstoffdioxid beispielsweise aus einem Kohlenstoff und zwei Sauerstoffatomen.\n" +
            "\n" +
            "Diese Gasmoleküle sind – anders als Sauerstoff oder Stickstoff (zwei Atome) – empfänglich für bestimmte Strahlung. Entscheidend dafür ist deren Wellenlänge. Die Strahlungsenergie wird aufgenommen und versetzt die Moleküle in Bewegungen, konkret in Schwingungen. Bei der Bewegung wiederum wird Energie frei, die etwa als Wärmestrahlung in verschiedene Richtung – circa zur Hälfte auch in Richtung Erdoberfläche – abgegeben wird.\n" +
            "Nur drei- oder mehratomige Moleküle wirken aufs Klima\n" +
            "\n" +
            "Stickstoff und Sauerstoff, die Hauptbestandteile der Atmosphäre, interagieren in höheren Atmosphärenschichten zwar ebenfalls mit Strahlung und führen beispielsweise zu den bekannten Polarlichtern. Mit Wärmestrahlung aus Richtung der Erdoberfläche reagieren sie aber nicht. Nur drei- oder mehratomige Moleküle, wie Kohlenstoffdioxid oder Methan, haben das Potenzial, den Planeten zu erwärmen. Für den Treibhauseffekt spielt der Großteil der Atmosphärengase daher keine Rolle.\n" +
            "\n" +
            "Den größten Effekt auf unsere stabile Temperatur hat der Wasserdampf (Wolken), der zwischen null und vier Volumenprozent ausmacht – an den Polen etwa weniger, in den Tropen mehr. Er trägt daher vor allem zum natürlichen Treibhauseffekt bei. Das Problem: Der Anteil von Wasserdampf in der Atmosphäre hängt von der Temperatur ab. Mehr CO2 führt zu steigenden Temperaturen, das führt zu mehr Wasserdampf und verstärkt den Treibhauseffekt - eine positive Rückkopplung, die große Auswirkungen haben kann.\n" +
            "\n" +
            "Aus diesem Grund führen höhere Konzentrationen der Treibhausgase, auch wenn sie nur wenige Volumenprozente der Atmosphäre ausmachen, zu sich selbst verstärkenden Effekten – sogenannten Feedback Loops. Daraus berechnen die Forscher eine um bis zu 4,5 Grad höhere Durchschnittstemperatur, wenn sich das CO2 in der Atmosphäre verdoppelt – auch wenn das \"nur\" weitere 0,028 Volumenprozent wären. Die Konzentration der Gase allein sagt nichts aus, denn einige wenige Moleküle an CO2 können eine große Wirkung haben, viele Stickstoffmoleküle dagegen für die globale Temperatur bedeutungslos bleiben.\n\n Kohlenstoffdioxid (CO2) wird als „Klimagift“ bezeichnet, weil es im übertragenen Sinne Gift für das Klima ist: Es absorbiert die Wärmeabstrahlung von der Erde und heizt so die Atmosphäre auf.\n Für den Menschen ist CO2 in geringer Konzentration nicht giftig, es behindert aber die Sauerstoffaufnahme. Eine erhöhte Konzentration von CO2 in der Umgebungsluft kann bei Menschen zu Kopfschmerzen führen und letztlich Bewusstlosigkeit auslösen.\n\n Eine Konzentration von acht Prozent oder mehr kann nach 30 bis 60 Minuten zum Tode führen.";

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
        CO2Label1.setText("CO² normal");

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

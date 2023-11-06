package de.simonjpg.Frontend.UI.Swing;

import de.simonjpg.Frontend.UI.Model.ModelMenu;

import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import static java.awt.Font.BOLD;
import static java.lang.Short.MAX_VALUE;
import static javax.swing.GroupLayout.Alignment.LEADING;
import static javax.swing.GroupLayout.DEFAULT_SIZE;

/**
 * Class MenuItem.
 * <p>
 *     Item which can be selected to open another form.
 * </p>
 * @author Simon Balcke
 * @see javax.swing.JPanel
 */
public class MenuItem extends JPanel {
    private JLabel lbIcon;
    private JLabel lbName;

    private boolean selected;

    /**
     * Create Form MenuItem.
     * @param data of the item.
     */

    public MenuItem(ModelMenu data) {
        initComponents();
        setOpaque(false);
        if (data.getType() == ModelMenu.MenuType.MENU) {
            lbIcon.setIcon(data.toIcon());
            lbName.setText(data.getName());
        } else if (data.getType() == ModelMenu.MenuType.TITLE) {
            lbIcon.setText(data.getName());
            lbIcon.setFont(new Font("sansserif", BOLD, 12));
            lbName.setVisible(false);
        } else {
            lbName.setText(" ");
        }
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    private void initComponents() {
        lbIcon = new JLabel();
        lbName = new JLabel();

        lbIcon.setForeground(new Color(255, 255, 255));

        lbName.setForeground(new Color(255, 255, 255));
        lbName.setText("Menu Name");

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(lbIcon)
                                .addGap(18, 18, 18)
                                .addComponent(lbName)
                                .addContainerGap(DEFAULT_SIZE, MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(LEADING)
                        .addComponent(lbIcon, DEFAULT_SIZE, DEFAULT_SIZE, MAX_VALUE)
                        .addComponent(lbName, DEFAULT_SIZE, 35, MAX_VALUE)
        );
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        if (selected) {
            Graphics2D g2 = (Graphics2D) grphcs;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(new Color(255, 255, 255, 80));
            g2.fillRoundRect(10, 0, getWidth() - 20, getHeight(), 5, 5);
        }
        super.paintComponent(grphcs);
    }
}

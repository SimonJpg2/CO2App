package de.simonjpg.Frontend.UI.Swing;

import de.simonjpg.Frontend.UI.Event.EventMenuSelected;
import de.simonjpg.Frontend.UI.Model.ModelMenu;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.SwingUtilities;

/**
 * Class ListMenu.
 * <p>
 *    Actual List for switching between MenuItems.
 * </p>
 * @param <E>
 */
public class ListMenu<E extends Object> extends JList<E> {
    private final DefaultListModel model;
    private int selectedIndex = -1;
    private EventMenuSelected event;

    /**
     * Create Form ListMenu.
     */

    public ListMenu() {
        model = new DefaultListModel();
        setModel(model);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                if (SwingUtilities.isLeftMouseButton(me)) {
                    int index = locationToIndex(me.getPoint());
                    Object o = model.getElementAt(index);
                    if (o instanceof ModelMenu) {
                        ModelMenu menu = (ModelMenu) o;
                        if (menu.getType() == ModelMenu.MenuType.MENU) {
                            selectedIndex = index;
                            if (event != null) {
                                event.selected(index);
                            }
                        }
                    } else {
                        selectedIndex = index;
                    }
                }
            }
        });

    }

    /**
     * Method addEventMenuSelected.
     * @param event which is triggered if MenuItem has been switched.
     */
    public void addEventMenuSelected(EventMenuSelected event) {
        this.event = event;
    }

    @Override
    public ListCellRenderer<? super E> getCellRenderer() {
        return new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> jlist, Object o, int index, boolean selected, boolean focus) {
                ModelMenu data;
                if (o instanceof ModelMenu) {
                    data = (ModelMenu) o;
                } else {
                    data = new ModelMenu("", o + "", ModelMenu.MenuType.EMPTY);
                }
                MenuItem item = new MenuItem(data);
                item.setSelected(selectedIndex == index);
                return item;
            }

        };
    }

    public void addItem(ModelMenu data) {
        model.addElement(data);
    }
}


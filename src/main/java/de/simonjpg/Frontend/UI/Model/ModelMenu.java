package de.simonjpg.Frontend.UI.Model;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * Class ModelMenu.
 *
 * <p>
 *     Model which represents an item of the Menu.
 * </p>
 * @author Simon Balcke
 */
public class ModelMenu {
    public ModelMenu(String icon, String name, MenuType type) {
        this.icon = icon;
        this.name = name;
        this.type = type;
    }

    public ModelMenu() {
    }

    private String icon;
    private String name;
    private MenuType type;

    /**
     * Method toIcon.
     * <p>
     *     Converts String to the specific Icon
     * </p>
     * @return the Icon
     */
    public Icon toIcon() {
        return new ImageIcon(getClass().getResource("/icon/" + icon + ".png"));
    }

    /**
     * Enum MenuType.
     * <p>
     *     Contains type of the item for the menu.
     * </p>
     */
    public static enum MenuType {
        TITLE, MENU, EMPTY
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MenuType getType() {
        return type;
    }

    public void setType(MenuType type) {
        this.type = type;
    }
}

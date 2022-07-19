import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

import java.util.HashMap;
import java.util.List;

public class MenuBuilder {
    MenuBar menuBar;
    HashMap<Menu, List<MenuItem>> menuItems;

    public MenuBuilder(HashMap<Menu, List<MenuItem>> menuItems) {
        menuBar = new MenuBar();
        this.menuItems = menuItems;
    }

    public MenuBar getMenuBar() {
        for (Menu menu : menuItems.keySet()) {
            for (MenuItem menuItem : menuItems.get(menu)) {
                menu.getItems().add(menuItem);
            }
            menuBar.getMenus().add(menu);
        }
        return menuBar;
    }
}


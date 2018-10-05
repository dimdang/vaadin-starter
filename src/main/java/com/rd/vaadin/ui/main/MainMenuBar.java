package com.rd.vaadin.ui.main;

import com.rd.vaadin.ui.viewdeclaration.AppUIScope;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.UI;

import javax.inject.Inject;

/**
 * Created by DANG DIM
 * Date     : 3/5/2018, 4:32 PM
 * Email    : d.dim@gl-f.com
 */

@UIScope
@SpringComponent
public class MainMenuBar extends CssLayout {

    @Inject
    public MainMenuBar() {
        HorizontalLayout mainMenuLayout = new HorizontalLayout();
        mainMenuLayout.setMargin(true);
        mainMenuLayout.setWidth(100, Unit.PERCENTAGE);
        mainMenuLayout.setStyleName("test-my-layout");

        MenuBar home = new MenuBar();
        MenuBar.MenuItem item = home.addItem("Operation", createNavigationCommand(AppUIScope.HOME));
        //item.addItem("Operation", createNavigationCommand(AppUIScope.OPERATION));

        home.addItem("Collection", createNavigationCommand(AppUIScope.COLLECTIONS));
        home.addItem("Persons", createNavigationCommand(AppUIScope.PERSONS));
        home.addItem("Staffs", createNavigationCommand(AppUIScope.STAFFS));
        home.addItem("System", createNavigationCommand(AppUIScope.SYSTEM));
        home.addItem("Configurations", createNavigationCommand(AppUIScope.CONFIGURATION));

        mainMenuLayout.addComponent(home);
        mainMenuLayout.setStyleName("top-css-layout-nav-bar");
        addComponent(mainMenuLayout);
        setWidth(100, Unit.PERCENTAGE);
    }

    private MenuBar.Command createNavigationCommand(final String viewName) {
        return menuItem -> UI.getCurrent().getNavigator().navigateTo(viewName);
    }
}

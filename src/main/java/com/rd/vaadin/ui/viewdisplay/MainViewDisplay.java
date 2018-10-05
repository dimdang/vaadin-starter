package com.rd.vaadin.ui.viewdisplay;

import com.rd.vaadin.ui.main.MainMenuBar;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewDisplay;
import com.vaadin.spring.annotation.SpringViewDisplay;
import com.vaadin.ui.Component;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import javax.inject.Inject;

/**
 * Created by DANG DIM
 * Date     : 3/5/2018, 4:47 PM
 * Email    : d.dim@gl-f.com
 */

@SpringViewDisplay
public class MainViewDisplay extends CustomComponent implements ViewDisplay {

    private static final long serialVersionUID = 904216786030039555L;

    private final VerticalLayout content = new VerticalLayout();

    @Inject
    public MainViewDisplay(MainMenuBar mainMenuBar) {
        final VerticalLayout root = new VerticalLayout();

        root.setSpacing(false);
        root.setSizeFull();
        root.setMargin(false);

        content.setSpacing(false);
        content.setSizeFull();
        content.setMargin(false);

        root.addComponent(mainMenuBar);
        root.addComponent(content);
        setCompositionRoot(root);
    }

    @Override
    public void showView(View view) {
        content.removeAllComponents();
        content.addComponent((Component) view);
        UI.getCurrent().setScrollTop(0);
        UI.getCurrent().setScrollLeft(0);
    }
}
package com.rd.vaadin.ui.view;

import com.rd.vaadin.ui.component.operations.OperationTabComponent;
import com.rd.vaadin.ui.viewdeclaration.AppUIScope;
import com.vaadin.navigator.View;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalLayout;

/**
 * Created by DANG DIM
 * Date     : 3/6/2018, 2:36 PM
 * Email    : d.dim@gl-f.com
 */

@UIScope
@SpringComponent
@SpringView(name = AppUIScope.HOME)
public class HomepageView extends CssLayout implements View {

    public HomepageView() {
        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.setMargin(true);
        horizontalLayout.setSizeFull();

        horizontalLayout.addComponent(new OperationTabComponent());
        addComponent(horizontalLayout);
        setSizeFull();
    }
}

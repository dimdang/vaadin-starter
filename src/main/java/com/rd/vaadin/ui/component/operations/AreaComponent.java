package com.rd.vaadin.ui.component.operations;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Label;

/**
 * Created by DANG DIM
 * Date     : 3/6/2018, 2:44 PM
 * Email    : d.dim@gl-f.com
 */

@SpringComponent
@UIScope
public class AreaComponent extends CssLayout {
    public AreaComponent() {
        CssLayout personLayout = new CssLayout();
        personLayout.addComponent(new Label("Hello person"));
        addComponent(personLayout);
        setWidth(100, Unit.PERCENTAGE);
    }
}

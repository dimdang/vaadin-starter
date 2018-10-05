package com.rd.vaadin.ui.component.operations;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.TabSheet;

/**
 * Created by DANG DIM
 * Date     : 3/6/2018, 2:44 PM
 * Email    : d.dim@gl-f.com
 */
@UIScope
@SpringComponent
public class OperationTabComponent extends CssLayout{

    protected TabSheet operationTab = new TabSheet();

    public OperationTabComponent() {
        CssLayout personTabLayout = new CssLayout();
        personTabLayout.setStyleName("operation-tab-layout");
        personTabLayout. setWidth(100, Unit.PERCENTAGE);

        operationTab.addTab(new OperationComponent(), "Operations");
        operationTab.addTab(new AreaComponent(),"Areas");
        operationTab.addTab(new AreaComponent(),"Receipt Codes");

        personTabLayout.addComponent(operationTab);
        addComponent(personTabLayout);
        setWidth(100, Unit.PERCENTAGE);
    }
}

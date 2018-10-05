package com.rd.vaadin.ui;

import com.vaadin.navigator.View;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

import javax.annotation.PostConstruct;

/**
 * Created by DANG DIM
 * Date     : 3/6/2018, 3:20 PM
 * Email    : d.dim@gl-f.com
 */

@UIScope
public class AccessDeniedView extends VerticalLayout implements View {

    private static final long serialVersionUID = -134715779625065266L;

    @PostConstruct
    void init() {
        //addComponent(new Label("This is the error view - Oops!"));
    }

}

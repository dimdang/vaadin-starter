package com.rd.vaadin.ui;

import com.rd.vaadin.ui.viewdisplay.MainViewDisplay;
import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.navigator.SpringViewProvider;
import com.vaadin.ui.UI;
import javax.inject.Inject;
import java.util.Locale;

/**
 * Created by DANG DIM
 * Date     : 3/5/2018, 5:02 PM
 * Email    : d.dim@gl-f.com
 */

@SpringUI
@Theme("mystyle")
public class DemoUI extends UI {

    private static final long serialVersionUID = 8125033437325957759L;
    private MainViewDisplay mainViewDisplay;
    private SpringViewProvider springViewProvider;

    @Inject
    public DemoUI(MainViewDisplay mainViewDisplay, SpringViewProvider viewProvider) {

        this.mainViewDisplay = mainViewDisplay;
        this.springViewProvider = viewProvider;
    }

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        springViewProvider.setAccessDeniedViewClass(AccessDeniedView.class);
        setContent(mainViewDisplay);
    }

    @Override
    public void setLocale(Locale locale) {
        super.setLocale(locale);
    }
}

package com.rd.vaadin.ui.component.operations;

import com.rd.vaadin.api.HttpMethodsUtil;
import com.rd.vaadin.model.Area;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.Sizeable;
import com.vaadin.ui.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DANG DIM
 * Date     : 3/13/2018, 10:04 AM
 * Email    : d.dim@gl-f.com
 */

@Component
public class OperationsAreas {

    private ComboBox<Area> cbxProvinceArea;
    private TextField txtDltCharge;
    private TextField txtWage;

    private FormLayout formLayout;
    private Panel operationAreasPanel;
    private Button btnNew, btnDelete;
    private Area area;
    private List<Area> areaCollection = new ArrayList<>();
    private HttpMethodsUtil methodsUtil = new HttpMethodsUtil();
    Grid<Area> areaGrid;
    public Panel panelLayOut() {
        operationAreasPanel = new Panel("Operation Areas");
        operationAreasPanel.setContent(operationByAreaLayOut());
        operationAreasPanel.setWidth(50, Sizeable.Unit.PERCENTAGE);
        return operationAreasPanel;
    }

    private FormLayout operationAreasFormLayOut() {
        formLayout = new FormLayout();
        cbxProvinceArea = new ComboBox<>("Province Areas");
        cbxProvinceArea.setRequiredIndicatorVisible(true);
        cbxProvinceArea.setItems(methodsUtil.doGetArea());
        cbxProvinceArea.setItemCaptionGenerator(Area::getAreaName);
        cbxProvinceArea.addValueChangeListener(valueChangeEvent -> {
            if (cbxProvinceArea.getValue() != null) {
                txtDltCharge.setValue(String.valueOf(cbxProvinceArea.getValue().getDLTCharge()));
                txtWage.setValue(String.valueOf(cbxProvinceArea.getValue().getWage()));
            } else {
                txtDltCharge.setValue("");
                txtWage.setValue("");
            }
        });

        txtDltCharge = new TextField("DLT Charge");
        txtDltCharge.setRequiredIndicatorVisible(true);

        txtWage = new TextField("Wage");
        txtWage.setRequiredIndicatorVisible(true);

        formLayout.addComponent(cbxProvinceArea);
        formLayout.addComponent(txtDltCharge);
        formLayout.addComponent(txtWage);

        return formLayout;
    }

    private Grid<Area> operationAreaTable() {
        areaGrid = new Grid<>();
        areaGrid.addColumn(Area::getAreaId).setCaption("ID");
        areaGrid.addColumn(Area::getAreaName).setCaption("Area Name");
        areaGrid.addColumn(Area::getDLTCharge).setCaption("DLT Charge");
        areaGrid.addColumn(Area::getWage).setCaption("Wage");
        areaGrid.addItemClickListener(itemClick -> {
            area = itemClick.getItem();
        });
        areaGrid.setWidth(100, Sizeable.Unit.PERCENTAGE);
        return areaGrid;
    }

    private Area getAreas() {
        area = new Area();
        if (cbxProvinceArea.getValue() != null) {
            area.setAreaId(cbxProvinceArea.getValue().getAreaId());
            area.setAreaName(String.valueOf(cbxProvinceArea.getValue().getAreaName()));
        }
        if (txtDltCharge.getValue() != null)
            area.setDLTCharge(Double.valueOf(txtDltCharge.getValue()));

        if (txtWage.getValue() != null)
            area.setWage(Double.valueOf(txtWage.getValue()));
        return area;
    }

    private HorizontalLayout buttonLayOut() {
        HorizontalLayout horizontalLayout = new HorizontalLayout();

        btnNew = new Button();
        btnNew.setIcon(FontAwesome.ADN);
        btnNew.addClickListener(clickEvent -> {
            areaCollection.add(getAreas());
            areaGrid.setItems(areaCollection);
        });

        btnDelete = new Button();
        btnDelete.setIcon(FontAwesome.MINUS);
        btnDelete.addClickListener(clickEvent -> {
            if (!areaCollection.isEmpty()) {
                areaCollection.remove(area);
                areaGrid.getDataProvider().refreshAll();
            }
        });

        horizontalLayout.addComponent(btnNew);
        horizontalLayout.addComponent(btnDelete);
        return horizontalLayout;
    }

    //Return list of area to operations
    public List<Area> getAreaCollection() {
        return this.areaCollection;
    }

    private Layout operationByAreaLayOut() {
        Layout layout = new VerticalLayout();
        layout.addComponent(operationAreasFormLayOut());
        layout.addComponent(buttonLayOut());
        layout.addComponent(operationAreaTable());
        return layout;
    }
}

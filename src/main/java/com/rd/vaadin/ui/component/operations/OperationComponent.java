package com.rd.vaadin.ui.component.operations;

import com.rd.vaadin.api.HttpMethodsUtil;
import com.rd.vaadin.model.Operation;
import com.rd.vaadin.model.ReceiptCode;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.*;

import java.util.HashSet;

/**
 * Created by DANG DIM
 * Date     : 3/6/2018, 2:45 PM
 * Email    : d.dim@gl-f.com
 */

@UIScope
@SpringComponent
public class OperationComponent extends CssLayout {

    private TextField txtOperationCode;
    private TextField txtOperationDescription;
    private ComboBox<ReceiptCode> cbxReceiptCode;
    private TextField txtPrice;
    private TextField txtDefaultDLT;
    private TextField txtDefaultWage;

    private FormLayout formLayout;
    private HorizontalLayout operationButton;
    private Button btnSave, btnEdit, btnDelete;
    private OperationsAreas operationsAreas;
    private HttpMethodsUtil methodsUtil = new HttpMethodsUtil();
    private Operation operation;

    public OperationComponent() {
        CssLayout operationLayout = new CssLayout();
        operationsAreas = new OperationsAreas();
        operationLayout.addComponent(operationForm());
        operationLayout.addComponent(buttonLayout());
        operationLayout.addComponent(operationTable());
        operationLayout.addComponent(operationsAreas.panelLayOut());
        addComponent(operationLayout);
        setWidth(100, Unit.PERCENTAGE);
    }

    private FormLayout operationForm() {

        formLayout = new FormLayout();

        txtOperationCode = new TextField("OperationCode");
        txtOperationCode.setRequiredIndicatorVisible(true);

        txtOperationDescription = new TextField("Operation Description");
        txtOperationDescription.setRequiredIndicatorVisible(true);

        cbxReceiptCode = new ComboBox("Receipt Code");
        cbxReceiptCode.setRequiredIndicatorVisible(true);
        cbxReceiptCode.setItems(methodsUtil.doGetReceiptCode());
        cbxReceiptCode.setItemCaptionGenerator(ReceiptCode::getReceiptCode);

        txtPrice = new TextField("Operation Price");
        txtPrice.setRequiredIndicatorVisible(true);

        txtDefaultDLT = new TextField("Default DLT");
        txtDefaultDLT.setRequiredIndicatorVisible(true);

        txtDefaultWage = new TextField("Default Wage");
        txtDefaultWage.setRequiredIndicatorVisible(true);

        formLayout.addComponent(txtOperationCode);
        formLayout.addComponent(txtOperationDescription);
        formLayout.addComponent(cbxReceiptCode);
        formLayout.addComponent(txtPrice);
        formLayout.addComponent(txtDefaultDLT);
        formLayout.addComponent(txtDefaultWage);

        return formLayout;
    }

    private Layout buttonLayout() {
        operationButton = new HorizontalLayout();
        operationButton.addComponent(btnSave = new Button("SAVE"));
        btnSave.addClickListener(clickEvent -> {
            methodsUtil.doPostOperations(getOperation());
        });
        operationButton.addComponent(btnEdit = new Button("EDIT"));
        operationButton.addComponent(btnDelete = new Button("DELETE"));
        return operationButton;
    }

    private Grid operationTable() {
        Grid<Operation> grid = new Grid<>();
        grid.addColumn(Operation::getId).setCaption("ID");
        grid.addColumn(Operation::getOperationCode).setCaption("Operation Code");
        grid.addColumn(Operation::getOperationDescription).setCaption("Description");
        grid.addColumn(operation1 -> operation1.getReceiptCode().getReceiptCode()).setCaption("Receipt Code");
        grid.addColumn(Operation::getOperationPrice).setCaption("Price");
        grid.addColumn(Operation::getDefaultDLTCharge).setCaption("Default DLT");
        grid.addColumn(Operation::getDefaultWage).setCaption("Default Wage");
        grid.setItems(methodsUtil.doGetOperation());
        grid.setWidth(50, Unit.PERCENTAGE);
        grid.setStyleName("grid-table-margin-top");
        return grid;
    }

    private Operation getOperation() {
        operation = new Operation();
        operation.setOperationCode(txtOperationCode.getValue());
        operation.setReceiptCode(cbxReceiptCode.getValue());
        operation.setOperationDescription(txtOperationDescription.getValue());
        operation.setOperationPrice(Double.valueOf(txtPrice.getValue()));
        operation.setDefaultDLTCharge(Double.valueOf(txtDefaultDLT.getValue()));
        operation.setDefaultWage(Double.valueOf(txtDefaultWage.getValue()));
        operation.setAreas(new HashSet<>(operationsAreas.getAreaCollection()));
        return operation;
    }

}

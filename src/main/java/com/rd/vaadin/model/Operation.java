package com.rd.vaadin.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * Created by DANG DIM
 * Date     : 3/5/2018, 9:06 AM
 * Email    : d.dim@gl-f.com
 */

@Entity
@Table(name = "operation_tbl")
public class Operation {

    private Long id;
    private String operationCode;
    private String operationDescription;
    private Double operationPrice;
    private Double defaultDLTCharge;
    private Double defaultWage;
    private ReceiptCode receiptCode;
    private Set<Area> areas;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ope_id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "ope_code")
    public String getOperationCode() {
        return operationCode;
    }

    public void setOperationCode(String operationCode) {
        this.operationCode = operationCode;
    }

    @Column(name = "ope_des")
    public String getOperationDescription() {
        return operationDescription;
    }

    public void setOperationDescription(String operationDescription) {
        this.operationDescription = operationDescription;
    }

    @Column(name = "ope_price")
    public Double getOperationPrice() {
        return operationPrice;
    }

    public void setOperationPrice(Double operationPrice) {
        this.operationPrice = operationPrice;
    }

    @Column(name = "ope_def_DLT")
    public Double getDefaultDLTCharge() {
        return defaultDLTCharge;
    }

    public void setDefaultDLTCharge(Double defaultDLTCharge) {
        this.defaultDLTCharge = defaultDLTCharge;
    }

    @Column(name = "def_wage")
    public Double getDefaultWage() {
        return defaultWage;
    }

    public void setDefaultWage(Double defaultWage) {
        this.defaultWage = defaultWage;
    }

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "rec_cod_id")
    public ReceiptCode getReceiptCode() {
        return receiptCode;
    }

    public void setReceiptCode(ReceiptCode receiptCode) {
        this.receiptCode = receiptCode;
    }

    @ManyToMany(cascade = CascadeType.MERGE, targetEntity = Area.class, fetch = FetchType.LAZY)
    @JoinTable(name = "operation_areas_tbl",
            joinColumns = @JoinColumn(name = "ope_id", updatable = false, nullable = false),
            inverseJoinColumns = @JoinColumn(name = "area_id", updatable = false, nullable = false))
    public Set<Area> getAreas() {
        return areas;
    }

    public void setAreas(Set<Area> areas) {
        this.areas = areas;
    }
}

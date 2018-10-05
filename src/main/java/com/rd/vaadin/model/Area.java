package com.rd.vaadin.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by DANG DIM
 * Date     : 3/5/2018, 9:06 AM
 * Email    : d.dim@gl-f.com
 */

@Entity
@Table(name = "area_tbl")
public class Area {
    private Long areaId;
    private String areaName;
    private Double DLTCharge;
    private Double Wage;
    private Set<Operation> operations;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "area_id")
    public Long getAreaId() {
        return areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    @Column(name = "area_name")
    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    @Column(name = "area_dlt")
    public Double getDLTCharge() {
        return DLTCharge;
    }

    public void setDLTCharge(Double DLTCharge) {
        this.DLTCharge = DLTCharge;
    }

    @Column(name = "wage")
    public Double getWage() {
        return Wage;
    }

    public void setWage(Double wage) {
        Wage = wage;
    }

    @ManyToMany(cascade = CascadeType.MERGE, mappedBy = "areas", fetch = FetchType.LAZY, targetEntity = Operation.class)
    @JsonBackReference
    public Set<Operation> getOperations() {
        return operations;
    }

    public void setOperations(Set<Operation> operations) {
        this.operations = operations;
    }
}

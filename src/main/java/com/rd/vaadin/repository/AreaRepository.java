package com.rd.vaadin.repository;

import com.rd.vaadin.model.Area;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by DANG DIM
 * Date     : 3/5/2018, 9:24 AM
 * Email    : d.dim@gl-f.com
 */

public interface AreaRepository extends JpaRepository<Area, Long> {

    List<Area> findAllByAreaId(List<Long> id);
}

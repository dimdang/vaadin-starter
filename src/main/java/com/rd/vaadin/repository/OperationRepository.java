package com.rd.vaadin.repository;

import com.rd.vaadin.model.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by DANG DIM
 * Date     : 3/5/2018, 9:25 AM
 * Email    : d.dim@gl-f.com
 */
@Repository
public interface OperationRepository extends JpaRepository<Operation, Long> {
}

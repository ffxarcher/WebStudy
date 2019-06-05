package com.sq.order.repository;

import com.sq.order.dataobject.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderMasterRepository extends JpaRepository<OrderMaster, String> {

}

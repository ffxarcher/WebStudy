package com.sq.order.repository;

import com.sq.order.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {
}

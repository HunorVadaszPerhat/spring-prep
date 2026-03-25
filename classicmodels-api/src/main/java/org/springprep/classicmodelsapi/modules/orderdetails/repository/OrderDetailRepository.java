package org.springprep.classicmodelsapi.modules.orderdetails.repository;

import org.springprep.classicmodelsapi.modules.orderdetails.model.OrderDetail;
import org.springprep.classicmodelsapi.modules.orderdetails.model.OrderDetailId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, OrderDetailId> {
}

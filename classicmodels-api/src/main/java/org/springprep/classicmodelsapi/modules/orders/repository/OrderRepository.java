package org.springprep.classicmodelsapi.modules.orders.repository;

import org.springprep.classicmodelsapi.modules.orders.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}

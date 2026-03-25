package org.springprep.classicmodelsapi.modules.products.repository;

import org.springprep.classicmodelsapi.modules.products.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
}

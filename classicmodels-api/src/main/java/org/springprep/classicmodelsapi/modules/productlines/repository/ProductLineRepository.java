package org.springprep.classicmodelsapi.modules.productlines.repository;

import org.springprep.classicmodelsapi.modules.productlines.model.ProductLine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductLineRepository extends JpaRepository<ProductLine, String> {
}

package org.springprep.classicmodelsapi.modules.offices.repository;

import org.springprep.classicmodelsapi.modules.offices.model.Office;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfficeRepository extends JpaRepository<Office, String> {
}

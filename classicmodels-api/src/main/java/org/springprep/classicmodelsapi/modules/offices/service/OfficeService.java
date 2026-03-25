package org.springprep.classicmodelsapi.modules.offices.service;

import org.springprep.classicmodelsapi.modules.offices.dto.OfficeDto;

import java.util.List;

public interface OfficeService {

    List<OfficeDto> findAll();

    OfficeDto findById(String officeCode);

    OfficeDto create(OfficeDto officeDto);

    OfficeDto update(String officeCode, OfficeDto officeDto);

    void delete(String officeCode);
}

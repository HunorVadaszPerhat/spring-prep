package org.springprep.classicmodelsapi.modules.offices.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springprep.classicmodelsapi.infrastructure.exception.ResourceNotFoundException;
import org.springprep.classicmodelsapi.modules.offices.dto.OfficeDto;
import org.springprep.classicmodelsapi.modules.offices.mapper.OfficeMapper;
import org.springprep.classicmodelsapi.modules.offices.model.Office;
import org.springprep.classicmodelsapi.modules.offices.repository.OfficeRepository;
import org.springprep.classicmodelsapi.modules.offices.service.OfficeService;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class OfficeServiceImpl implements OfficeService {

    private final OfficeRepository officeRepository;
    private final OfficeMapper officeMapper;

    @Override
    public List<OfficeDto> findAll() {
        return officeRepository.findAll().stream().map(officeMapper::toDto).toList();
    }

    @Override
    public OfficeDto findById(String officeCode) {
        return officeMapper.toDto(getOffice(officeCode));
    }

    @Override
    @Transactional
    public OfficeDto create(OfficeDto officeDto) {
        Office office = officeMapper.toEntity(officeDto);
        return officeMapper.toDto(officeRepository.save(office));
    }

    @Override
    @Transactional
    public OfficeDto update(String officeCode, OfficeDto officeDto) {
        Office existing = getOffice(officeCode);
        existing.setCity(officeDto.city());
        existing.setPhone(officeDto.phone());
        existing.setAddressLine1(officeDto.addressLine1());
        existing.setAddressLine2(officeDto.addressLine2());
        existing.setState(officeDto.state());
        existing.setCountry(officeDto.country());
        existing.setPostalCode(officeDto.postalCode());
        existing.setTerritory(officeDto.territory());
        return officeMapper.toDto(existing);
    }

    @Override
    @Transactional
    public void delete(String officeCode) {
        Office existing = getOffice(officeCode);
        officeRepository.delete(existing);
    }

    private Office getOffice(String officeCode) {
        return officeRepository.findById(officeCode)
                .orElseThrow(() -> new ResourceNotFoundException("Office %s not found".formatted(officeCode)));
    }
}

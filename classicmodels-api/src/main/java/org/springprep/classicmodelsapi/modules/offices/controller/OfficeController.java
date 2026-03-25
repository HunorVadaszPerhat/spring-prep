package org.springprep.classicmodelsapi.modules.offices.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springprep.classicmodelsapi.modules.offices.dto.OfficeDto;
import org.springprep.classicmodelsapi.modules.offices.service.OfficeService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/offices")
@RequiredArgsConstructor
public class OfficeController {

    private final OfficeService officeService;

    @GetMapping
    public List<OfficeDto> getOffices() {
        return officeService.findAll();
    }

    @GetMapping("/{officeCode}")
    public OfficeDto getOffice(@PathVariable String officeCode) {
        return officeService.findById(officeCode);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OfficeDto createOffice(@Valid @RequestBody OfficeDto officeDto) {
        return officeService.create(officeDto);
    }

    @PutMapping("/{officeCode}")
    public OfficeDto updateOffice(@PathVariable String officeCode, @Valid @RequestBody OfficeDto officeDto) {
        return officeService.update(officeCode, officeDto);
    }

    @DeleteMapping("/{officeCode}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOffice(@PathVariable String officeCode) {
        officeService.delete(officeCode);
    }
}

package dev.lucieyarish.phoneshopdemo.controllers;

import dev.lucieyarish.phoneshopdemo.models.dtos.PhoneDto;
import dev.lucieyarish.phoneshopdemo.services.PhoneService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class PhoneController {

    private final PhoneService phoneService;

    @PostMapping(value = "/phones", consumes = MediaType.ALL_VALUE)
    public ResponseEntity<?> createPhone(@Valid @RequestBody PhoneDto phoneDto) {
        phoneService.create(phoneDto.toPhone());

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}

package app.controller;

import app.dto.PriceDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class PriceController {

    @GetMapping("/price")
    public ResponseEntity<List<PriceDto>> getAllPrices() {
        return null;
    }
}

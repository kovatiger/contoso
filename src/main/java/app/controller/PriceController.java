package app.controller;

import app.dto.PriceDto;
import app.entity.Price;
import app.entity.Product;
import app.mapper.PriceMapper;
import app.service.price_service.PriceService;
import app.service.product_service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class PriceController {

    @Autowired
    private ProductService productService;
    @Autowired
    private PriceService priceService;

    @GetMapping("/price")
    public ResponseEntity<List<PriceDto>> getAllPrices() {
        List<Product> products = productService.findAll();
        if (!products.isEmpty()) {
            List<PriceDto> priceDtos = PriceMapper.getPriceDtoFromProduct(products);
            return new ResponseEntity<>(priceDtos, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/price/add")
    public HttpStatus addNewPrice(@RequestBody PriceDto priceDto) {
        Price price = priceService.findPriceById(priceDto.getId());
        if (price != null) {
            priceService.save(PriceMapper.getPriceFromPriceDto(priceDto, price));
            return HttpStatus.OK;
        } else {
            return HttpStatus.NOT_FOUND;
        }
    }
}

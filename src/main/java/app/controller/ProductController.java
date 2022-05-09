package app.controller;

import app.dto.ProductDto;
import app.entity.Product;
import app.mapper.ProductMapper;
import app.service.product_service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<List<ProductDto>> gelAllProducts() {
        List<Product> products = productService.findAll();
        List<ProductDto> productDtoList = ProductMapper.getProductDtoFromProduct(products);
        if (productDtoList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(productDtoList, HttpStatus.OK);
        }
    }

    @PostMapping("/products/add")
    public HttpStatus saveProduct(@RequestBody final ProductDto productDto) {
        if (productDto != null) {
            Product product = ProductMapper.getProductFromProductDto(productDto);
            productService.saveProduct(product);
            return HttpStatus.OK;
        } else {
            return HttpStatus.BAD_REQUEST;
        }
    }

    @PostMapping("/products/update")
    public HttpStatus updateProduct(@RequestBody final ProductDto productDto) {
        if (productDto != null) {
            Product product = ProductMapper.getProductFromProductDto(productDto);
            productService.saveProduct(product);
            return HttpStatus.OK;
        } else {
            return HttpStatus.BAD_REQUEST;
        }
    }

}

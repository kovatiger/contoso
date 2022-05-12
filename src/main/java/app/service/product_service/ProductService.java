package app.service.product_service;

import app.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    List<Product> findAll();

    void saveProduct(Product product);

    Product findProductById(Long id);
}

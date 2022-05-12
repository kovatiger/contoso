package app.mapper;

import app.dto.ProductDto;
import app.entity.Price;
import app.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductMapper {

    public static List<ProductDto> getProductDtoFromProduct(List<Product> products) {
        List<ProductDto> productDtoList = new ArrayList<>();
        for (Product product : products) {
            ProductDto productDto = new ProductDto();
            productDto.setId(product.getId());
            productDto.setName(product.getProduct());
            productDto.setType(product.getName());
            productDto.setColor(product.getColor());
            productDto.setAmount(product.getAmount());
            productDto.setPrice(product.getPriceId().getPrice());
            productDto.setDate(product.getDate());
            productDtoList.add(productDto);
        }
        return productDtoList;
    }

    public static Product getProductFromProductDto(ProductDto productDto) {
        Product product = new Product();
        product.setProduct(productDto.getName());
        product.setName(productDto.getType());
        product.setColor(productDto.getColor());
        product.setAmount(productDto.getAmount());
        product.setDate(productDto.getDate());
        Price price = new Price();
        price.setPrice(productDto.getPrice());
        price.setDate(productDto.getDate());
        product.setPriceId(price);
        return product;
    }


    public static Product updateProductByProductDto(Product product, ProductDto productDto) {
        product.setProduct(productDto.getName());
        product.setName(productDto.getType());
        product.setColor(productDto.getColor());
        product.setDate(productDto.getDate());
        product.setAmount(productDto.getAmount());
        Price price = product.getPriceId();
        price.setPrice(productDto.getPrice());
        price.setDate(productDto.getDate());
        product.setPriceId(price);
        return product;
    }
}

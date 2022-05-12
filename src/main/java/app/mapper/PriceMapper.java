package app.mapper;

import app.dto.PriceDto;
import app.entity.Price;
import app.entity.Product;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PriceMapper {

    public static List<PriceDto> getPriceDtoFromProduct(List<Product> products) {
        List<PriceDto> priceDtos = new ArrayList<>();
        for (Product product : products) {
            PriceDto priceDto = new PriceDto();
            priceDto.setId(product.getPriceId().getId());
            priceDto.setProductName(product.getProduct() + " " + product.getName());
            priceDto.setPrice(product.getPriceId().getPrice());
            priceDto.setDate(product.getPriceId().getDate());
            priceDtos.add(priceDto);
        }
        return priceDtos;
    }

    public static Price getPriceFromPriceDto(PriceDto priceDto, Price price) {
        price.setPrice(priceDto.getPrice());
        Date date = new Date();
        price.setDate(date);
        return price;
    }
}

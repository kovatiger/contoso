package app.mapper;

import app.dto.PriceDto;
import app.entity.Price;
import app.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class PriceMapper {

    public static List<PriceDto> getPriceDtoFromProduct(List<Product> products) {
        List<PriceDto> priceDtos = new ArrayList<>();
        for (Product product : products) {
            PriceDto priceDto = new PriceDto();
            priceDto.setId(product.getPriceId().getId());
            priceDto.setName(product.getProduct());
            priceDto.setType(product.getName());
            priceDto.setPrice(product.getPriceId().getPrice());
            priceDto.setDate(product.getPriceId().getDate());
            priceDtos.add(priceDto);
        }
        return priceDtos;
    }

    public static Price getPriceFromPriceDto(PriceDto priceDto, Price price) {
        price.setPrice(priceDto.getPrice());
        return price;
    }
}

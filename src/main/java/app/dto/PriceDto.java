package app.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PriceDto {
    private Long id;
    private String productName;
    private Date date;
    private double priceOfProduct;
}

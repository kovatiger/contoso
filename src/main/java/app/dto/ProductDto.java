package app.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ProductDto {
    public Long Id;
    public String name;
    public String type;
    public String color;
    public Boolean existsOfProduct;
    public int amount;
    public double price;
    public Date date;
}

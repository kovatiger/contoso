package app.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ProductDto {
    public Long Id;
    public String Name;
    public String Type;
    public String Color;
    public int Amount;
    public double Price;
    public Date date;
}

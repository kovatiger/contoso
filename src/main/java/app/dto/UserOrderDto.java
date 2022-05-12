package app.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UserOrderDto {
    private Long Id;
    private String Customer;
    private String ProductName;
    private String Color;
    private int Amount;
    private Double Price;
    private Date Date;
    private boolean Pay;
    private String Status;
}

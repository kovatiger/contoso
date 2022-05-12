package app.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UserOrderDtoToAdd {
    private int amount;
    private Date date;
    private Boolean pay;
    private String payMethod;
    private String status;
    private Long clientId;
    private Long productId;
}

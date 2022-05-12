package app.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ClientDto {
    private Long id;
    private String productName;
    private String location;
    private String contactName;
    private String numberOfPhone;
    private String email;
}

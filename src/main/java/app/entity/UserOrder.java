package app.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user_order")
@Getter
@NoArgsConstructor
public class UserOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_order_id")
    private Long id;
    @Setter
    private Integer amount;
    @Setter
    private Date date;
    @Setter
    private Boolean pay;
    @Setter
    private String status;
    @Setter
    @Column(name = "payment_method")
    private String paymentMethod;
    @Setter
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id")
    private Client client;
    @Setter
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private Product product;

}

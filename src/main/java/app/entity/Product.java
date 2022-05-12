package app.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "product")
@Getter
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;
    @Setter
    private String product;
    @Setter
    private String name;
    @Setter
    private String color;
    @Setter
    private Integer amount;
    @Setter
    @Column(columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date date;
    @Setter
    @Column(name = "exists_of_product",columnDefinition = "boolean default true")
    private Boolean existsOfProduct;
    @Setter
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "price_id")
    private Price priceId;
    @Setter
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id")
    private Client client;
    @Setter
    @OneToMany(mappedBy = "product")
    private List<UserOrder> userOrderList;
}

package app.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "client")
@Getter
@NoArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id")
    private Long id;
    @Setter
    private String name;
    @Setter
    private String telephone;
    @Setter
    private String city;
    @Setter
    private String email;
    @Setter
    @OneToMany(mappedBy = "product")
    private List<Product> clientProductList;
    @Setter
    @OneToMany(mappedBy = "client")
    private List<UserOrder> userOrderList;
}

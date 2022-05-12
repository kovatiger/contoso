package app.service.user_order_service;

import app.dto.UserOrderDtoToAdd;
import app.entity.Client;
import app.entity.Product;
import app.entity.UserOrder;
import app.repository.ClientRepository;
import app.repository.ProductRepository;
import app.repository.UserOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserOrderServiceImpl implements UserOrderService {
    @Autowired
    private UserOrderRepository userOrderRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ProductRepository productRepository;

    @Override
    public void save(UserOrder resultUserOrder) {
        userOrderRepository.save(resultUserOrder);
    }

    @Override
    public UserOrder addClientAndProduct(UserOrderDtoToAdd userOrderDtoToAdd) {
        UserOrder userOrder = new UserOrder();
        Client client = clientRepository.getById(userOrderDtoToAdd.getClientId());
        Product product = productRepository.getById(userOrderDtoToAdd.getProductId());
        userOrder.setClient(client);
        userOrder.setProduct(product);
        return userOrder;
    }

    @Override
    public List<UserOrder> findAll() {
        return userOrderRepository.findAll();
    }
}

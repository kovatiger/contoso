package app.service.user_order_service;

import app.entity.UserOrder;
import app.repository.UserOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserOrderServiceImpl implements UserOrderService {
    @Autowired
    private UserOrderRepository userOrderRepository;

    @Override
    public List<UserOrder> findAll() {
        return userOrderRepository.findAll();
    }
}

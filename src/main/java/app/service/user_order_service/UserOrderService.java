package app.service.user_order_service;

import app.entity.UserOrder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserOrderService {
    List<UserOrder> findAll();
}

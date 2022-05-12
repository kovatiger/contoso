package app.service.price_service;

import app.entity.Price;
import org.springframework.stereotype.Service;

@Service
public interface PriceService {
    Price findPriceById(Long id);

    void save(Price price);
}

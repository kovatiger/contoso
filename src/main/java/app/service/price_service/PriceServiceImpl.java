package app.service.price_service;

import app.entity.Price;
import app.repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PriceServiceImpl implements PriceService {

    @Autowired
    private PriceRepository priceRepository;

    @Override
    public void save(Price price) {
        priceRepository.save(price);
    }

    @Override
    public Price findPriceById(Long id) {
        return priceRepository.getById(id);
    }
}

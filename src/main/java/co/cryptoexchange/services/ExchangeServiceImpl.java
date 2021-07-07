package co.cryptoexchange.services;

import co.cryptoexchange.data.ExchangeRepository;
import co.cryptoexchange.model.Exchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExchangeServiceImpl implements ExchangeService {

    @Autowired
    private ExchangeRepository exchangeRepository;

    @Override
    public List<Exchange> findAll() {
        return exchangeRepository.findAll();
    }

    @Override
    public Exchange findById(Long id) {
        return exchangeRepository.getById(id);
    }

    @Override
    public Exchange saveExchange(Exchange exchange) {
        return exchangeRepository.saveAndFlush(exchange);
    }

    @Override
    public void deleteExchange(Long id) {
        exchangeRepository.deleteById(id);
    }
}

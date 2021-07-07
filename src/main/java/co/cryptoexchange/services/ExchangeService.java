package co.cryptoexchange.services;

import co.cryptoexchange.model.Exchange;

import java.util.List;

public interface ExchangeService {

    List<Exchange> findAll();

    Exchange findById(Long id);

    Exchange saveExchange(Exchange exchange);

    void deleteExchange(Long id);

}

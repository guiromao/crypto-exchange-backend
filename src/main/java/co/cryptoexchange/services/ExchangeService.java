package co.cryptoexchange.services;

import co.cryptoexchange.model.Coin;
import co.cryptoexchange.model.CoinOwnership;
import co.cryptoexchange.model.Exchange;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface ExchangeService {

    List<Exchange> findAll();

    Exchange findById(Long id);

    Exchange saveExchange(Exchange exchange);

    void deleteExchange(Long id);

    boolean processCoinsBuy(Long exchangeId, String code, Double amount);

    List<CoinOwnership> retrieveCoins(Long exchangeId);

}

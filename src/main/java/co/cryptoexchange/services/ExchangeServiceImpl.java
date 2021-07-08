package co.cryptoexchange.services;

import co.cryptoexchange.data.CoinRepository;
import co.cryptoexchange.data.ExchangeRepository;
import co.cryptoexchange.mappers.CoinMapper;
import co.cryptoexchange.model.Coin;
import co.cryptoexchange.model.CoinOwnership;
import co.cryptoexchange.model.Exchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class ExchangeServiceImpl implements ExchangeService {

    @Autowired
    private ExchangeRepository exchangeRepository;

    @Autowired
    private CoinMapper coinMapper;

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
        Exchange exchange = exchangeRepository.getById(id);
        exchangeRepository.deleteById(id);
    }

    @Override
    public boolean processCoinsBuy(Long exchangeId, String code, Double amount) {
        Exchange exchange = exchangeRepository.getById(exchangeId);
        Coin coin = coinMapper.findCoin(code);
        boolean success = exchange.buyCoins(coin, amount);
        exchangeRepository.saveAndFlush(exchange);

        return success;
    }

    @Override
    public List<CoinOwnership> retrieveCoins(Long exchangeId) {
        List<CoinOwnership> coins = new ArrayList<>();
        Exchange exchange = exchangeRepository.getById(exchangeId);

        for(Map.Entry<String, Double> entry: exchange.getCoins().entrySet()){
            Coin coin = coinMapper.findCoin(entry.getKey());
            CoinOwnership ownership = new CoinOwnership(coin, entry.getValue());
            coins.add(ownership);
        }

        return coins;
    }

}

package co.cryptoexchange.services;

import co.cryptoexchange.data.CoinRepository;
import co.cryptoexchange.data.ExchangeRepository;
import co.cryptoexchange.mappers.CoinMapper;
import co.cryptoexchange.mappers.SystemMapper;
import co.cryptoexchange.model.Coin;
import co.cryptoexchange.model.CoinOwnership;
import co.cryptoexchange.model.DistributedSystem;
import co.cryptoexchange.model.Exchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ExchangeServiceImpl implements ExchangeService {

    private final String BUY = "Buy";
    private final String SELL = "Sell";

    @Autowired
    private ExchangeRepository exchangeRepository;

    @Autowired
    private DistributedSystemService dsService;

    @Autowired
    private CoinMapper coinMapper;

    @Autowired
    private SystemMapper systemMapper;

    @Override
    public List<Exchange> findAll() {
        return exchangeRepository.findAll();
    }

    @Override
    public Exchange findById(Long id) {
        return exchangeRepository.findById(id).get();
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
        Optional<DistributedSystem> ds = dsService.getSystem();

        if(ds.isPresent()){
            Coin coin = coinMapper.findCoin(code);
            boolean success = exchange.buyCoins(ds.get(), coin, amount);
            exchangeRepository.saveAndFlush(exchange);
            dsService.save(ds.get());

            if(success){
                updateSystem(ds.get(), code, amount, BUY);
            }

            return success;
        }

        return false;
    }

    @Override
    public boolean processCoinsSell(Long exchangeId, String code, Double amount) {
        Exchange exchange = exchangeRepository.getById(exchangeId);
        Optional<DistributedSystem> distSystem = dsService.getSystem();

        if(distSystem.isPresent()){
            Coin coin = coinMapper.findCoin(code);
            boolean success = exchange.sellCoins(distSystem.get(), coin, amount);
            exchangeRepository.saveAndFlush(exchange);
            dsService.save(distSystem.get());

            if(success){
                updateSystem(distSystem.get(), code, amount, SELL);
            }

            return success;
        }

        return false;
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

    private void updateSystem(DistributedSystem ds, String code, Double amount, String dynamic){
        Double value;

        if(dynamic.equals(BUY)){
            amount = 0 - amount;
        }

        switch(code){
            case "BTC":
                value = ds.getBtcSupply() + amount;
                systemMapper.updateBtc(value);
                break;

            case "ADA":
                value = ds.getAdaSupply() + amount;
                systemMapper.updateAda(value);
                break;
        }
    }

}

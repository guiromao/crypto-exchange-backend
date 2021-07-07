package co.cryptoexchange.services;

import co.cryptoexchange.data.CoinRepository;
import co.cryptoexchange.model.Coin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoinServiceImpl implements CoinService {

    @Autowired
    private CoinRepository coinRepository;

    @Override
    public List<Coin> retrieveCoins() {
        return coinRepository.findAll();
    }

    @Override
    public Coin addCoin(Coin coin) {
        List<Coin> allCoins = retrieveCoins();

        for(Coin searchCoin: allCoins){
            if(coin.getCode().toUpperCase().trim().equals(searchCoin.getCode().toUpperCase().trim())){
                return null;
            }
        }

        return coinRepository.saveAndFlush(coin);
    }
}

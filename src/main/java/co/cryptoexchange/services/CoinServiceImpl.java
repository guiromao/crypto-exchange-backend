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
    public Coin saveCoin(Coin coin) {
        return coinRepository.saveAndFlush(coin);
    }

    @Override
    public Coin getCoin(Long id) {
        return coinRepository.getById(id);
    }

    @Override
    public void deleteCoin(Long id) {
        coinRepository.deleteById(id);
    }

}

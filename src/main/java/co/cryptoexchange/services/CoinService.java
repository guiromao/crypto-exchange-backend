package co.cryptoexchange.services;

import co.cryptoexchange.model.Coin;

import java.util.List;

public interface CoinService {

    List<Coin> retrieveCoins();

    Coin saveCoin(Coin coin);

    Coin getCoin(Long id);

    void deleteCoin(Long id);

}

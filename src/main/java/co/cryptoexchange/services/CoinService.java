package co.cryptoexchange.services;

import co.cryptoexchange.model.Coin;

import java.util.List;

public interface CoinService {

    List<Coin> retrieveCoins();

    Coin addCoin(Coin coin);

}

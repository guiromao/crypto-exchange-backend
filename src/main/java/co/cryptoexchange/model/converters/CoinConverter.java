package co.cryptoexchange.model.converters;

import co.cryptoexchange.model.Coin;
import co.cryptoexchange.model.dto.CoinDTO;

public class CoinConverter {

    public static Coin convertToCoin(CoinDTO dto){
        return new Coin(dto.getCode(), dto.getName(), dto.getValue());
    }

    public static CoinDTO convertToDTO(Coin coin){
        return new CoinDTO(coin.getName(), coin.getCode(), coin.getValue());
    }

}

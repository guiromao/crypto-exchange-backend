package co.cryptoexchange.model.converters;

import co.cryptoexchange.model.Coin;
import co.cryptoexchange.model.dto.CoinDTO;

public class CoinConverter {

    public static Coin convertToCoin(CoinDTO dto){
        return new Coin(dto.getCode(), dto.getName(), dto.getValue());
    }

}

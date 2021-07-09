package co.cryptoexchange.model.converters;

import co.cryptoexchange.model.Exchange;
import co.cryptoexchange.model.dto.ExchangeDTO;

public class ExchangeConverter {

    public static Exchange convertToExchange(ExchangeDTO dto){
        return new Exchange(dto.getName(), dto.getLiquidity());
    }

    public static ExchangeDTO convertToDTO(Exchange exchange){
        return new ExchangeDTO(exchange.getName(), exchange.getLiquidity());
    }

}

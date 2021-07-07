package co.cryptoexchange.model.dto;

import co.cryptoexchange.model.Exchange;

public class ExchangeDTO {

    private String name;
    private Double liquidity;

    public ExchangeDTO(){

    }

    public ExchangeDTO(String name, Double liquidity){
        this.name = name;
        this.liquidity = liquidity;
    }

    public ExchangeDTO(String name){
        this.name = name;
        liquidity = 10000000d;
    }

    public Exchange convertToExchange(){
        return new Exchange(name, liquidity);
    }

    public String getName() {
        return name;
    }

    public Double getLiquidity() {
        return liquidity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLiquidity(Double liquidity) {
        this.liquidity = liquidity;
    }
}

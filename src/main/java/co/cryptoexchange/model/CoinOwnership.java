package co.cryptoexchange.model;

import javax.persistence.*;

public class CoinOwnership {

    private String coinName;
    private String coinCode;
    private Double coinValue;
    private Double amount;
    private Double valueStored;

    public CoinOwnership(){

    }

    public CoinOwnership(Coin coin, Double amount){
        this.coinName = coin.getName();
        this.coinCode = coin.getCode();
        this.coinValue = coin.getValue();
        this.amount = amount;
        valueStored = this.coinValue * this.amount;
    }

    public CoinOwnership(Coin coin){
        this.coinName = coin.getName();
        this.coinCode = coin.getCode();
        this.coinValue = coin.getValue();
        this.amount = 0d;
        valueStored = this.coinValue * amount;
    }

    @Override
    public String toString(){
        return coinCode + " | " + amount + " units | $" + (coinValue * amount);
    }

    public String getName() {
        return coinName;
    }

    public String getCoinCode() {
        return coinCode;
    }

    public Double getCoinValue() {
        return coinValue;
    }

    public Double getAmount() {
        return amount;
    }

    public Double getValueStored() {
        return valueStored;
    }

    public void setCoinName(String coinName) {
        this.coinName = coinName;
    }

    public void setCoinCode(String coinCode) {
        this.coinCode = coinCode;
    }

    public void setCoinValue(Double value) {
        this.coinValue = value;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public void setValueStored(Double valueStored) {
        this.valueStored = valueStored;
    }
    
}

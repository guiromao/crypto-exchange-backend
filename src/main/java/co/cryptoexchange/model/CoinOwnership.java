package co.cryptoexchange.model;

import javax.persistence.*;

@Entity
@Table(name="coinownerships")
public class CoinOwnership {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ownershipId;

    @ManyToOne
    @JoinColumn(name="exchangeId")
    private Exchange exchange;

    @ManyToOne
    @JoinColumn(name="coinId")
    private Coin coin;

    private Double amount;

    public CoinOwnership(){

    }

    public CoinOwnership(Exchange exchange, Coin coin, Double amount){
        this.exchange = exchange;
        this.coin = coin;
        this.amount = amount;
    }

    public CoinOwnership(Exchange exchange, Coin coin){
        this.exchange = exchange;
        this.coin = coin;
        this.amount = 0d;
    }

    public void addCoins(Double amount){
        this.amount += amount;
    }

    public void removeCoins(Double amount){
        if(this.amount >= amount){
            this.amount -= amount;
        }
    }

    public Long getOwnershipId() {
        return ownershipId;
    }

    public Exchange getExchange() {
        return exchange;
    }

    public Coin getCoin() {
        return coin;
    }

    public Double getAmount() {
        return amount;
    }

    public void setOwnershipId(Long ownershipId) {
        this.ownershipId = ownershipId;
    }

    public void setCoin(Coin coin) {
        this.coin = coin;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}

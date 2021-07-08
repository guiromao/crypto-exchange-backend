package co.cryptoexchange.model;

import net.bytebuddy.description.modifier.Ownership;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name="exchanges")
public class Exchange {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long exchangeId;

    private String name;
    private Double liquidity;

    /*@OneToMany(fetch = FetchType.LAZY, mappedBy="exchange", cascade = {CascadeType.MERGE})
    private Set<CoinOwnership> ownerships;*/

    @ElementCollection
    @CollectionTable(name = "coin_amounts",
            joinColumns = {@JoinColumn(name = "exchange_id", referencedColumnName = "exchangeId")})
    @MapKeyColumn(name = "coinCode")
    @Column(name = "numberCoins")
    private Map<String, Double> coins;

    public Exchange(){

    }

    public Exchange(String name){
        this.name = name;
        this.liquidity = 10000000d;
        coins = new HashMap<>();
    }

    public Exchange(String name, Double value){
        this.name = name;
        this.liquidity = value;
        coins = new HashMap<>();
    }

    public synchronized boolean buyCoins(Coin c, Double numberCoins){
        if(c != null){
            if(liquidity >= numberCoins * c.getValue()){

                coins.putIfAbsent(c.getCode(), 0d);

                Double currAmount = coins.get(c.getCode());
                coins.put(c.getCode(), currAmount + numberCoins);
                liquidity -= (numberCoins * c.getValue());

                return true;
            }
        }

        return false;
    }

    public synchronized boolean sellCoins(Coin c, Double numberCoins){
        if(c != null){
            String code = c.getCode();

            if(coins.get(code) != null){
                Double currAmount = coins.get(code);

                if(currAmount >= numberCoins){
                    currAmount -= numberCoins;
                    coins.put(code, currAmount);
                    liquidity += c.getValue() * numberCoins;

                    return true;
                }
            }
        }

        return false;
    }

    public Long getExchangeId() {
        return exchangeId;
    }

    public String getName() {
        return name;
    }

    public Double getLiquidity() {
        return liquidity;
    }

    public Map<String, Double> getCoins() {
        return coins;
    }

    public void setExchangeId(Long id) {
        this.exchangeId = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLiquidity(Double liquidity) {
        this.liquidity = liquidity;
    }

    public void setCoins(Map<String, Double> c) {
        this.coins = c;
    }

}

package co.cryptoexchange.model;

import net.bytebuddy.description.modifier.Ownership;

import javax.persistence.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Entity
@Table(name="exchanges")
public class Exchange {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long exchangeId;

    private String name;
    private Double liquidity;

    @OneToMany(mappedBy="exchange")
    private Set<CoinOwnership> ownerships;

    public Exchange(){

    }

    public Exchange(String name){
        this.name = name;
        this.liquidity = 10000000d;
        ownerships = new HashSet<>();
    }

    public Exchange(String name, Double value){
        this.name = name;
        this.liquidity = value;
        ownerships = new HashSet<>();
    }

    public synchronized void buyCoins(Coin c, Double numberCoins){
        if(liquidity >= numberCoins * c.getValue()){
            for(CoinOwnership ownership: ownerships){
                if(ownership.getCoin().getCode().equals(c.getCode())){
                    ownership.addCoins(numberCoins);
                    liquidity -= (numberCoins * c.getValue());
                }
            }
        }
    }

    public synchronized void sellCoins(Coin c, Double numberCoins){
        for(CoinOwnership ownership: ownerships){
            if(ownership.getCoin().getCode().equals(c.getCode())){
                if(ownership.getAmount() >= numberCoins){
                    ownership.removeCoins(numberCoins);
                    liquidity += c.getValue() * numberCoins;
                }
            }
        }
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

    public Set<CoinOwnership> getOwnerships() {
        return ownerships;
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

    public void setOwnerships(Set<CoinOwnership> ownership) {
        this.ownerships = ownership;
    }

}

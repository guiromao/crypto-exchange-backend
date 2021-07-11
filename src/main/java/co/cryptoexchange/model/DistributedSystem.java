package co.cryptoexchange.model;

import javax.persistence.*;

@Entity
@Table(name="systems")
public class DistributedSystem {

    private final Double TOTAL_BTC = 21000000d;
    private final Double TOTAL_ADA = 45000000000d;
    private final String BTC_CODE = "BTC";
    private final String ADA_CODE = "ADA";
    private final String ETH_CODE = "ETH";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double btcSupply;
    private Double adaSupply;

    public DistributedSystem(){
        btcSupply = TOTAL_BTC;
        adaSupply = TOTAL_ADA;
    }

    public boolean reduceCoins(Coin coin, Double amount){
        if(coin != null){
            if(hasEnoughTokens(coin, amount)){
                switch(coin.getCode().toUpperCase()){
                    case BTC_CODE: btcSupply -= amount; break;
                    case ADA_CODE: adaSupply -= amount; break;
                }

                return true;
            }
        }

        return false;
    }

    public boolean addCoins(Coin coin, Double amount){
        if(coin != null){
            switch(coin.getCode().toUpperCase()){
                case BTC_CODE: btcSupply += amount; break;
                case ADA_CODE: adaSupply += amount; break;
            }

            return true;
        }

        return false;
    }

    public boolean hasEnoughTokens(Coin coin, Double amount){
        boolean result = false;

        switch(coin.getCode().toUpperCase()){
            case BTC_CODE: result = btcSupply >= amount; break;
            case ADA_CODE: result = adaSupply >= amount; break;
            case ETH_CODE: result = true; break;
        }

        return result;
    }

    public Long getId() {
        return id;
    }

    public Double getBtcSupply() {
        return btcSupply;
    }

    public Double getAdaSupply() {
        return adaSupply;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setBtcSupply(Double btcSupply) {
        this.btcSupply = btcSupply;
    }

    public void setAdaSupply(Double adaSupply) {
        this.adaSupply = adaSupply;
    }

}

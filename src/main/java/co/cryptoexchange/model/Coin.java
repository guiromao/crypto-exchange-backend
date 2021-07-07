package co.cryptoexchange.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="coins")
public class Coin {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long coinId;

    private String code;
    private String name;
    private Double value;

    @OneToMany(mappedBy = "coin")
    private Set<CoinOwnership> ownerships;

    public Coin(){

    }

    public Coin(String code, String name, Double value){
        this.code = code;
        this.name = name;
        this.value = value;
        ownerships = new HashSet<>();
    }

    public Long getCoinId() {
        return coinId;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public Double getValue() {
        return value;
    }

    public Set<CoinOwnership> getOwnerships() {
        return ownerships;
    }

    public void setCoinId(Long id) {
        this.coinId = id;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public void setOwnerships(Set<CoinOwnership> ownerships) {
        this.ownerships = ownerships;
    }
}

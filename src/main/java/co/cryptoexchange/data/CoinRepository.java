package co.cryptoexchange.data;

import co.cryptoexchange.model.Coin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoinRepository extends JpaRepository<Coin, Long> {

}

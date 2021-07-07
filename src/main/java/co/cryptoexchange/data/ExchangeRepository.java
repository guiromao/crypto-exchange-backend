package co.cryptoexchange.data;

import co.cryptoexchange.model.Exchange;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeRepository extends JpaRepository<Exchange, Long> {

}

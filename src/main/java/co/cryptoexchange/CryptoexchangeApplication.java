package co.cryptoexchange;

import co.cryptoexchange.model.Coin;
import org.apache.ibatis.type.MappedTypes;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MappedTypes({Coin.class})
@MapperScan("co.cryptoexchange.mappers")
@SpringBootApplication
public class CryptoexchangeApplication {

	public static void main(String[] args) {
		SpringApplication.run(CryptoexchangeApplication.class, args);
	}

}

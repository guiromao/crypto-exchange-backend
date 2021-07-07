package co.cryptoexchange.controllers;

import co.cryptoexchange.model.Coin;
import co.cryptoexchange.model.converters.CoinConverter;
import co.cryptoexchange.model.dto.CoinDTO;
import co.cryptoexchange.services.CoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/v1/api/coins")
public class CoinController {

    @Autowired
    private CoinService coinService;

    @GetMapping({"", "/"})
    public ResponseEntity<List<Coin>> listCoins(){
        return new ResponseEntity<>(coinService.retrieveCoins(), HttpStatus.OK);
    }

    @PostMapping({"", "/"})
    public ResponseEntity addCoin(@RequestBody CoinDTO coinDTO){
        Coin coin = CoinConverter.convertToCoin(coinDTO);
        coinService.addCoin(coin);

        return new ResponseEntity(HttpStatus.CREATED);
    }

}

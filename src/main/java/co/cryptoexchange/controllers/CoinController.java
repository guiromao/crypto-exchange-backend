package co.cryptoexchange.controllers;

import co.cryptoexchange.model.Coin;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/v1/api/coins")
public class CoinController {

    @GetMapping({"", "/"})
    public ResponseEntity<Set<Coin>> listCoins(){
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

}

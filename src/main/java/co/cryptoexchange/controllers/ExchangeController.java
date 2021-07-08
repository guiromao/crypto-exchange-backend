package co.cryptoexchange.controllers;

import co.cryptoexchange.model.Coin;
import co.cryptoexchange.model.CoinOwnership;
import co.cryptoexchange.model.Exchange;
import co.cryptoexchange.model.converters.ExchangeConverter;
import co.cryptoexchange.model.dto.ExchangeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import co.cryptoexchange.services.ExchangeService;

import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping(path = {"/v1/api/exchanges/", "/v1/api/exchanges"})
public class ExchangeController {

    @Autowired
    private ExchangeService exchangeService;

    @GetMapping({"", "/"})
    public ResponseEntity<List<Exchange>> listExchanges(){
        List<Exchange> exchanges = exchangeService.findAll();

        return new ResponseEntity<>(exchanges, HttpStatus.OK);
    }

    @PostMapping({"", "/"})
    public ResponseEntity createExchange(@RequestBody ExchangeDTO exchangeDto){
        Exchange exchange = ExchangeConverter.convertToExchange(exchangeDto);
        exchangeService.saveExchange(exchange);

        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/{id}/buy")
    public ResponseEntity buyCoins(@PathVariable Long id, @RequestParam String code, @RequestParam Double amount){
        ResponseEntity response = exchangeService.processCoinsBuy(id, code, amount) ?
                new ResponseEntity(HttpStatus.OK) : new ResponseEntity(HttpStatus.BAD_REQUEST);

        return response;
    }

    @GetMapping("/{id}/wallet")
    public ResponseEntity<List<CoinOwnership>> getExchangeCoins(@PathVariable Long id){
        List<CoinOwnership> coins = exchangeService.retrieveCoins(id);

        return new ResponseEntity<>(coins, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteExchange(@PathVariable Long id){
        exchangeService.deleteExchange(id);

        return new ResponseEntity(HttpStatus.OK);
    }

}

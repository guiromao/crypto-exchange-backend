package co.cryptoexchange.controllers;

import co.cryptoexchange.model.Exchange;
import co.cryptoexchange.model.converters.ExchangeConverter;
import co.cryptoexchange.model.dto.ExchangeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import co.cryptoexchange.services.ExchangeService;

import java.util.List;

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

}

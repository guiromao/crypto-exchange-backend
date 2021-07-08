package co.cryptoexchange.controllers;

import co.cryptoexchange.mappers.CoinMapper;
import co.cryptoexchange.model.Coin;
import co.cryptoexchange.model.converters.CoinConverter;
import co.cryptoexchange.model.dto.CoinDTO;
import co.cryptoexchange.model.dto.ValueDTO;
import co.cryptoexchange.services.CoinService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/coins")
public class CoinController {

    @Autowired
    private CoinService coinService;

    @Autowired
    private CoinMapper coinMapper;

    @GetMapping({"", "/"})
    public ResponseEntity<List<Coin>> listCoins(){
        return new ResponseEntity<>(coinService.retrieveCoins(), HttpStatus.OK);
    }

    @PostMapping({"", "/"})
    public ResponseEntity addCoin(@RequestBody CoinDTO coinDTO){
        Coin coin = CoinConverter.convertToCoin(coinDTO);
        ResponseEntity response = (coinService.saveCoin(coin) != null) ? new ResponseEntity(HttpStatus.CREATED) :
                new ResponseEntity(HttpStatus.BAD_REQUEST);

        return response;
    }

    @PutMapping("/{id}")
    public ResponseEntity updateCoinValue(@PathVariable Long id, @RequestBody ValueDTO valueDto){
        ResponseEntity response = coinMapper.updateValue(id, valueDto.getValue()) > 0 ?
                new ResponseEntity(HttpStatus.OK) : new ResponseEntity(HttpStatus.BAD_REQUEST);
        /*ResponseEntity response;
        Coin coin = coinService.getCoin(id);
        Coin updatedCoin = new Coin(coin.getCode(), coin.getName(), valueDto.getValue());
        BeanUtils.copyProperties(updatedCoin, coin, "coinId");
        response = (coinService.saveCoin(coin) != null) ? new ResponseEntity(HttpStatus.OK) :
            new ResponseEntity(HttpStatus.BAD_REQUEST);*/

        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCoin(@PathVariable Long id){
        coinService.deleteCoin(id);

        return new ResponseEntity(HttpStatus.OK);
    }

}

package co.cryptoexchange.controllers;

import co.cryptoexchange.model.DistributedSystem;
import co.cryptoexchange.services.DistributedSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/system")
public class DistributedSystemController {

    @Autowired
    private DistributedSystemService systemService;

    @GetMapping({"/", ""})
    public ResponseEntity<DistributedSystem> getSystem(){
        ResponseEntity<DistributedSystem> response =
                systemService.getSystem().isPresent() ?
                        new ResponseEntity<>(systemService.getSystem().get(), HttpStatus.OK) :
                        new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        return response;
    }

    @PostMapping({"/", ""})
    public ResponseEntity createSystem(){
        ResponseEntity response;

        if(!systemService.getSystem().isPresent()){
            systemService.save(new DistributedSystem());
            response = new ResponseEntity(HttpStatus.CREATED);
        }
        else {
            response = new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        return response;
    }

}

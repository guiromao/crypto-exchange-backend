package co.cryptoexchange.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class WelcomeController {

    @GetMapping({"", "/"})
    public ResponseEntity<String> welcome(){
        return new ResponseEntity<>("Welcome, World!", HttpStatus.OK);
    }

}

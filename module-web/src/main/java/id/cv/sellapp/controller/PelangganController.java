package id.cv.sellapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/pelanggan")
public class PelangganController {

    @GetMapping(value = "")
    public String getPelanggan(){
        return "hallo pelanggan !";
    }
}

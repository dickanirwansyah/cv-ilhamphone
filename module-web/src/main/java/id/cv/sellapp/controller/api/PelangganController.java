package id.cv.sellapp.controller.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping(value = "/api/pelanggan")
public class PelangganController {

    @GetMapping(value = "/data-pelanggan")
    public String daataPelanggan(ModelAndView modelAndView){
        return "data-pelanggan";
    }
}

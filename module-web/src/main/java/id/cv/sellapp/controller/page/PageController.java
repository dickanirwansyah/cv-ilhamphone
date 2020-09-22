package id.cv.sellapp.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping(value = "/login")
    public String login(Model model){
        model.addAttribute("title", "Login Pengguna");
        return "login";
    }

    @GetMapping(value = {"/", "/dashboard", "/index"})
    public String dashboard(Model model){
        model.addAttribute("title", "Dashboard");
        return "content/dashboard";
    }

    @GetMapping(value = "/barang")
    public String pengguna(Model model){
        model.addAttribute("title", "barang");
        return "content/barang/index";
    }
}

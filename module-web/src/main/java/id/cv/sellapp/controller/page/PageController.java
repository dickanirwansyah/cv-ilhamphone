package id.cv.sellapp.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/login")
public class PageController {

    @GetMapping(value = "")
    public String login(Model model){
        model.addAttribute("title", "Login Pengguna");
        return "login";
    }
}

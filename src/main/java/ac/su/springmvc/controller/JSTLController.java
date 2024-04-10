package ac.su.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
@RequestMapping("/jstl")
public class JSTLController {
    @RequestMapping("/example")
    public String timeFormatting(Model model) {
        model.addAttribute("now", new Date());
        model.addAttribute("message", "this is long message");
        return "jstl/example";
    }
}

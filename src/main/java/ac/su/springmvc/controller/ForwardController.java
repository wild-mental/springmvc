package ac.su.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ForwardController {
    @GetMapping("/ex-forward-from")
    public String forwardFrom() {
        return "forward:/ex-forward-to";
    }

    @GetMapping("/ex-forward-to")
    @ResponseBody
    public String forwardTo() {
        return "forwarded to /ex-forward-to";
    }
}

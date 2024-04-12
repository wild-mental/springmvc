package ac.su.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RedirectController {
    @GetMapping("/ex-redirect-from")
    public String redirectFrom() {
        return "redirect:/ex-redirect-to";
    }

    @GetMapping("/ex-redirect-to")
    @ResponseBody
    public String redirectTo() {
        return "successfully redirected to /ex-redirect-to";
    }
}

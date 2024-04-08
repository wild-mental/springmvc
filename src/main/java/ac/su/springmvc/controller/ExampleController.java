package ac.su.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/example")
public class ExampleController {
    @GetMapping("/get")
    public String exampleGetMethod() {
        // GET 요청 처리 로직
        return "index";
    }
}


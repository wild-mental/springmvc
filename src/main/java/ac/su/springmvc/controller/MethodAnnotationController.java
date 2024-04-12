package ac.su.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/method-annotation")
public class MethodAnnotationController {
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody
    public String get() {
        return "this is GET method sample";
    }

    @GetMapping("/get2")
    @ResponseBody
    public String get2() {
        return "this is GET method sample 2";
    }

    @PostMapping("/post")
    @ResponseBody
    public String post() {
        return "this is POST method sample";
    }

    @PutMapping("/put")
    @ResponseBody
    public String put() {
        return "this is PUT method sample";
    }

    @DeleteMapping("/delete")
    @ResponseBody
    public String delete() {
        return "this is DELETE method sample";
    }

    @PatchMapping("/patch")
    @ResponseBody
    public String patch() {
        return "this is PATCH method sample";
    }

    @PatchMapping("/patch2")
    @ResponseBody
    public String patch2() {
        return "this is PATCH method sample 2";
    }
}

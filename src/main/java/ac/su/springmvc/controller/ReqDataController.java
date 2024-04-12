package ac.su.springmvc.controller;

import ac.su.springmvc.domain.LoginForm;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/data-control")
public class ReqDataController {

    // 1. HttpServletRequest 객체 사용 - Legacy 코드 → 보면 Refactoring 합니다.
    @GetMapping("/example1")
    @ResponseBody
    public String example1(HttpServletRequest request) {
        String param1 = request.getParameter("param1");
        int param2 = Integer.parseInt(request.getParameter("param2"));
        return param1 + " / " + param2;
    }

    // 2. @ModelAttribute Annotation 사용 - Legacy 는 아니지만 Legacy-like 함
    @GetMapping("/example2-form")
    public String showForm(Model model) {
        model.addAttribute("loginForm", new LoginForm());
        return "/jstl/login-form";
    }

    @PostMapping("/example2-submit")
    public String submitForm(@ModelAttribute("loginForm") LoginForm formData) {
        System.out.println("Email: " + formData.getEmail() + " / Password: " + formData.getPassword());
        return "/jstl/submit-result";
    }

    // 3. @PathVariable, @RequestParam, @RequestBody  Annotation 사용
    @GetMapping("/example3-pathvar/{param1}/{param2}")
    @ResponseBody
    public String example3PathVar(@PathVariable String param1,
                          @PathVariable String param2) {
        return param1 + " / " + param2;
    }

    @GetMapping("/example3-reqparam")
    @ResponseBody
    public String example3Param(@RequestParam("param1") String param1,
                                @RequestParam("param2") int param2)
    {
        return param1 + " / " + param2;
    }

    @GetMapping("/example3-defaultparam")
    @ResponseBody
    public String example3DefaultParam(@RequestParam(name = "param1", defaultValue = "default1") String param1,
                                       @RequestParam(name = "param2", defaultValue = "0") int param2)
    {
        return param1 + " / " + param2;
    }

    @PostMapping("/example3-reqbody")
    @ResponseBody
    public String example3Body(@RequestBody String payload) {
        return "Received payload: " + payload;
    }
}

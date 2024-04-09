package ac.su.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Encoding;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.Locale;

@Controller
@RequestMapping("/jstl")
public class JSTLController {
    @RequestMapping("/example")
    public String timeFormatting(Model model) {
        model.addAttribute("now", new Date());
        model.addAttribute("message", "this is long message");
        return "jstl/example";
    }

    @Autowired
    private MessageSource messageSource;

    @GetMapping("/i18n-msg")
    public String getMessage(@RequestParam(name = "lang", defaultValue = "en") String lang, Model model) {
        Locale locale = new Locale(lang);
        String message = messageSource.getMessage("hello.message", null, locale);
        // 아래 메시지 정상 출력 확인
        // System.out.println(message);
        model.addAttribute("helloMessage", message);
        return "jstl/i18n-msg";
    }
}

package ac.su.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@Controller
public class JSPController {

    @RequestMapping("sample-jsp-page")
    public String sampleJSP(Model model) {  // 페이지 응답 시 모델 자동 주입
        // 과일 배열 생성
        String[] fruits = {"Apple", "Banana", "Orange", "Grape", "Pineapple"};

        // 모델에 과일 목록 추가
        model.addAttribute("fruits", fruits);

        // 과일 목록 JSP 페이지 이름 반환
        return "sample-jsp-page";
    }
}

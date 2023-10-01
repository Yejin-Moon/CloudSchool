package inflearn.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model) {//spring 에서 모델 만들어서 데이터 넣어서 줌
        model.addAttribute("data","hello!!");
        return "hello"; //templates 밑에 있는 hello.html을 찾아서 타임리프 템플릿 엔진 처리
        //컨트롤러에서 리턴 값으로 문자를 반환하면 뷰 리졸버가 화면을 찾아서 처리한다.
        //resources/templates/hello.html을 찾아서 처리
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name",name);
        return "hello-template";
    }
}

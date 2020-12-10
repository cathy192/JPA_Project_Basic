package jpabook.jpashop;

import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    @GetMapping("hello")
    public String Hello(Model model){
        //model에서 attribute를 통해 속성값을 View로 넘길 수 있음
        model.addAttribute("data","hello!");
        //data라는 키에 hello!를 넘김
        return "hello"; //화면 이름임 resources에 templates에 view이름은 hello.html이어야함
    }

}

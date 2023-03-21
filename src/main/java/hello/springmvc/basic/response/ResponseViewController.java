package hello.springmvc.basic.response;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ResponseViewController {

    @RequestMapping("/response-view-v1")
    public ModelAndView responseViewV1() {
        ModelAndView mav = new ModelAndView("response/hello").addObject("data", "hello v1!");
        return mav;
    }


    @RequestMapping("/response-view-v2")
    public String responseViewV2(Model model) {
        model.addAttribute("data", "hello v2!");
        return "response/hello";
    }

    @RequestMapping("/response/hello") // 경로 이름이랑 리턴주소랑 똑같으면 생략가능 근데 잘안씀
    public void responseViewV3(Model model) {
        model.addAttribute("data", "hello~");
    }
}

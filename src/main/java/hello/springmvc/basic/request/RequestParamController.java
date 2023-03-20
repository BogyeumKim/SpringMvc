package hello.springmvc.basic.request;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Slf4j
@Controller
public class RequestParamController {

    @RequestMapping("/request-param-v1")
    public void requestParamV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        log.info("username={},age={}", username, age);

        response.getWriter().write("ok");
    }

    @RequestMapping("/request-param-v2")
    @ResponseBody // @RestController와 동일 리스판스에 넣어버리는거임
    public String requestParamV2(@RequestParam("username") String memberName, @RequestParam("age") int memberAge) {
        log.info("username={},age={}", memberName, memberAge);

        return "ok";
    }

    @RequestMapping("/request-param-v3")
    @ResponseBody
    public String requestParamV3(@RequestParam String username, @RequestParam int age) {
        log.info("username={},age={}", username, age);

        return "ok";
    }

    @RequestMapping("/request-param-v4")
    @ResponseBody
    public String requestParamV4(String username, int age) { // String , int 등 단순타입이면  @RequestParam 없어도 알아서 바인딩됨
        log.info("username={},age={}", username, age);

        return "ok";
    }

    @RequestMapping("/request-param-required")
    @ResponseBody
    public String requestParamRequired(@RequestParam(required = true) String username, @RequestParam(required = false) Integer age) {
        /* int 는 null 불가라 Integer 객체로 참조시켜줘야함 */
        log.info("username={},age={}", username, age);

        return "ok";
    }

    @RequestMapping("/request-param-default")
    @ResponseBody
    public String requestParamDefault(@RequestParam(required = true,defaultValue = "guest") String username, @RequestParam(required = false,defaultValue = "-1") int age) {
        /* defaultValue는 값이 없을때 기본값 설정 */
        log.info("username={},age={}", username, age);

        return "ok";
    }

    @RequestMapping("/request-param-default")
    @ResponseBody
    public String requestParamMap(@RequestParam Map<String ,Object> paramMap) {
        /* Map으로 담아 바인딩도 가능 MultiValueMap으로 중복 키값도 가능 */
        log.info("username={},age={}", paramMap.get("username"), paramMap.get("age"));

        return "ok";
    }
}

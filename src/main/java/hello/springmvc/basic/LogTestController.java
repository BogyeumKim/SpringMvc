package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


//@Slf4j
@RestController // return 데이터를 http body에 바로 넣어버림
public class LogTestController {

    private final Logger log = LoggerFactory.getLogger(getClass()); // Slf4j쓰면 이걸 알아서 넣어줌

    @RequestMapping("/log-test")
    public String logTest() {
        String name = "Spring";

        log.trace("trace log={}",name);
        log.debug("debug log={}",name); // 디버그(개발서버)에서 볼때
        log.info("info log={}", name); // 중요한 정보
        log.warn("warn log={}",name); // 경고(위험)
        log.error("error log={}",name); // 에러 확인해야함

        return "ok";
    }
}
